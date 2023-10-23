import java.util.Random;
import java.util.Scanner;
public class RPG {
	
public static boolean MP_Checker(int PlayerMP, int MPCost) {
	boolean MPEnough = true;
	if (PlayerMP - MPCost > 0) {
		MPEnough = true;
	}
	if (PlayerMP - MPCost < 0) {
		MPEnough = false;
	}
	return MPEnough;
}
public static int damageCalc(int lower_bound, int upper_bound, int empower) {
	int total_dmg = 0;
	Random random = new Random();
	if (empower == 0) {
		total_dmg = random.nextInt(upper_bound - lower_bound + 1) + lower_bound;
		return total_dmg;
	}
	else {
		upper_bound = upper_bound + empower*2;
		lower_bound = lower_bound + empower;
		total_dmg = random.nextInt(upper_bound - lower_bound + 1) + lower_bound;
		return total_dmg;
	}
}
public static int diceRoll(int dice_limit, int dice) {
	Random random = new Random();
	dice = random.nextInt(9) + 1;
	return dice;
}
public static void PrintStatus(int PlayerHP, int PlayerMP, int GoblinHP) {
	System.out.println("PLAYER HP: " + PlayerHP + "/100");
	System.out.println("PLAYER MP: " + PlayerMP + "/50");
	System.out.println("GOBLIN HP: " + GoblinHP + "/80");
	System.out.println(" ");
	System.out.println("CHOOESE NEXT ACTION: ");
	System.out.printf("1: Basic Attack%n2: Fireball%n3: Heal%n4: Empower%n5: Flee%n(Input '6' for a detailed guide of each action)%n");
}
public static void main(String[] args) {
int damage = 0;
int PlayerHP = 100;
int PlayerMP = 50;
int MPCost = 0;
int GoblinHP = 80;
int GoblinDMG = 0;
int lower_bound = 0;
int upper_bound = 0;
int dice = 0;
int dice_limit = 0;
int empower = 0;
Scanner userInput = new Scanner(System.in);
boolean gameRun = true;
System.out.println("Placeholder Text");
System.out.println("");
System.out.println("BATTLE BEGIN");
while (gameRun == true) {
	PrintStatus(PlayerHP, PlayerMP, GoblinHP);
	int input = 0;
	int cont = 0;
	if (userInput.hasNextInt()) {
		input = userInput.nextInt();
		if (input == 1) {
			lower_bound = 5;
			upper_bound = 10;
			dice_limit = 10;
			if (diceRoll(dice_limit, dice) <= 8) {
				damage = damageCalc(lower_bound, upper_bound, empower);
				System.out.println("ATTACK HIT FOR " + damage);
				GoblinHP = GoblinHP - damage;
			}
			else {
				System.out.println("Your attack missed! 0 damage was done.");
			}
		}
		if (input == 2) {
			lower_bound = 10;
			upper_bound = 25;
			MPCost = 6;
			if (MP_Checker(PlayerMP, MPCost) == true) {
				PlayerMP = PlayerMP - MPCost;
				damage = damageCalc(lower_bound, upper_bound, empower);
				System.out.println("ATTACK HIT FOR " + damage);
				GoblinHP = GoblinHP - damage;
				}
			if (MP_Checker(PlayerMP, MPCost) == false) {
				System.out.println("NOT ENOUGH MP TO CAST FIREBALL");
			}			
		}
		if (input == 3) {
			lower_bound = 20;
			upper_bound = 30;
			MPCost = 8;
			if (MP_Checker(PlayerMP, MPCost) == true) {
				PlayerMP = PlayerMP - MPCost;
				damage = damageCalc(lower_bound, upper_bound, empower);
				System.out.println("HEALED PLAYER FOR " + damage);
				PlayerHP = PlayerHP + damage;
				}
			if (MP_Checker(PlayerMP, MPCost) == false) {
				System.out.println("NOT ENOUGH MP TO CAST HEAL");
		}
		}
		if (input == 4) {
			System.out.println("TEST4");
		}
		if (input == 5) {
			System.out.println("TEST5");
		}
		if (input == 6) {
			System.out.print("BASIC ATTACK: 80% chance to deal 5-10 damage to the enemy.");
			System.out.printf("%nFIREBALL: Deal between 10-25 damage at the cost of 6 MP.%nHEAL: Regain 20-30 HP at the cost of 8 MP.%nEMPOWER: Increases minumum damage done by 1 and maximum by 2. *Permanent effect*%n");
			System.out.println("FLEE: Chance to flee and escape combat, ending the encounter.");
			System.out.println(" ");
		}
		else {
			
		}
	}
	else {
		System.out.println("Please input an acceptable action.");
	}
	while (cont == 0) {
		System.out.println("Please press 1 to continue.");
		input = userInput.nextInt();
		if (input == 1) {
			cont = 1;
		}
		else {
			cont = 0;
		}
	}
}
}
}