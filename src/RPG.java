import java.util.Random;
import java.util.Scanner;
public class RPG {
public static int Event_Handler(int damage) {
	
}
public static int MP_Checker() {
	
}
public static int damageCalc(int lower_bound, int upper_bound) {
	
}
public static int diceRoll(int dice_limit, int dice) {
	Random random = new Random();
	dice = random.nextInt(10);
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
int GoblinHP = 80;
int lower_bound = 0;
int upper_bound = 0;
int dice = 0;
int dice_limit = 0;
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
				System.out.println("PLACEHOLDER TEXT FOR ATTACK HIT");
			}
			else {
				System.out.println("Your attack missed! 0 damage was done.");
			}
		}
		if (input == 2) {
			lower_bound = 10;
			upper_bound = 25;
			
		}
		if (input == 3) {
			System.out.println("TEST3");
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