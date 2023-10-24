import java.util.Random;
import java.util.Scanner;
public class RPG {
	/*
	MP_Checker - Checks if the Player has enough MP to cast an MP costing action.
	@PlayerMP - Player's current MP.
	@MPCost - MP needed to cast.
	@return - returns true if the player has enough MP, and false if the player does not.
	 */
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
/*
 damageCalc - Calculates the damage done.
 @lower_bound - lower bound of the damage that can be done.
 @upper_bound - upper bound of the damage that can be done.
 @empower - amount of times that empower has been casted, increasing the damage.
 @return - total damage done.
 */
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
/*
 diceRoll - rolls a dice by generating a number between 1-10.
 @dice - number generated between 1-10.
 @return - number generated between 1-10.
 */
public static int diceRoll(int dice) {
	Random random = new Random();
	dice = random.nextInt(10) + 1;
	return dice;
}
/*
 PrintStatus - Prints current PlayerHP, MP, GoblinHP, and lists the actions that can be performed.
 @PlayerHP - Current Player HP.
 @PlayerMP - Current Player MP.
 @GoblinHP - Current GoblinHP.
 @return - void.
 */
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
int empower = 0;
int Goblinturn = 0;
Scanner userInput = new Scanner(System.in);
boolean gameRun = true;
boolean validInput = true;
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
			if (diceRoll(dice) <= 8) {
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
			MPCost = 10;
			if (MP_Checker(PlayerMP, MPCost) == true) {
				PlayerMP = PlayerMP - MPCost;
				empower = empower + 1;
				System.out.println("CASTED EMPOWER CURRENT STACK: " + empower);
			}
			if (MP_Checker(PlayerMP, MPCost) == false) {
				System.out.println("NOT ENOUGH MP TO CAST EMPOWER");
			}
		}
		if (input == 5) {
			if (diceRoll(dice) >= 6) {
				System.out.println("YOU SUCESSFULLY FLED ENDING ENCOUNTER");
				System.exit(0);
			}
			if (diceRoll(dice) <= 5) {
				System.out.println("YOUR OPPONENT DID NOT ALLOW YOU TO FLEE");
			}
		}
		if (input == 6) {
			System.out.print("BASIC ATTACK: 80% chance to deal 5-10 damage to the enemy.");
			System.out.printf("%nFIREBALL: Deal between 10-25 damage at the cost of 6 MP.%nHEAL: Regain 20-30 HP at the cost of 8 MP.%nEMPOWER: Increases minumum damage done by 1 and maximum by 2. *Permanent effect*%n");
			System.out.println("FLEE: Chance to flee and escape combat, ending the encounter.");
			System.out.println(" ");
			Goblinturn = 2;
		}
	}
	else {
		System.out.println("Please input an acceptable action.");
		validInput = false;
		while (validInput == false) {
			userInput.next();
			if (userInput.hasNextInt()) {
				input = userInput.nextInt();
				validInput = true;
				Goblinturn = 2;
			}
			else {
				System.out.println("Please input an acceptable action.");
			}
		}
	}
	while (Goblinturn < 2) {
		if (diceRoll(dice) >= 6) {
			lower_bound = 3;
			upper_bound = 7;
			GoblinDMG = damageCalc(lower_bound, upper_bound, 0);
			PlayerHP = PlayerHP - GoblinDMG;
			System.out.println("GOBLIN ATTACKED PLAYER FOR " + GoblinDMG);
			Goblinturn = Goblinturn + 1;
		}
		if (diceRoll(dice) <= 5) {
			System.out.println("GOBLIN'S ATTACK MISSED");
			Goblinturn = Goblinturn + 1;
		}
	}
	if (PlayerHP < 0) {
		gameRun = false;
		System.out.println("PLAYER DIED, YOU'VE LOST");
		System.exit(0);
	}
	if (GoblinHP < 0) {
		gameRun = false;
		System.out.println("GOBLIN DIED, YOU'VE WON");
		System.exit(0);
	}
	while (cont == 0) {
		System.out.println("Please press 1 to continue.");
		if (userInput.hasNextInt()) {
			input = userInput.nextInt();
			if (input == 1) {
				cont = 1;
				Goblinturn = 0;
			}
			else {
				cont = 0;
		}
		}
		else {
			System.out.println("1 was not entered, ending code.");
			System.exit(0);
		}
		
	}
}
}
}