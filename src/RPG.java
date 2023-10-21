import java.util.Random;
import java.util.Scanner;
public class RPG {
public static int Event_Handler(int damage) {
	
}
public static int MP_Checker() {
	
}
public static void PrintStatus(int PlayerHP, int PlayerMP, int GoblinHP) {
	System.out.println("PLAYER HP: " + PlayerHP);
	System.out.println("PLAYER MP: " + PlayerMP);
	System.out.println("GOBLIN HP: " + GoblinHP);
	System.out.println(" ");
	System.out.println("CHOOESE NEXT ACTION: ");
	System.out.printf("1: Basic Attack%n2: Fireball%n3: Heal%n4: Empower%n5: Flee%n(Input '6' for a detailed guide of each action)");
}
public static void main(String[] args) {
int damage = 0;
int PlayerHP = 100;
int PlayerMP = 50;
int GoblinHP = 80;
Scanner userInput = new Scanner(System.in);
boolean gameRun = true;
System.out.println("Placeholder Text");
System.out.println("");
System.out.println("BATTLE BEGIN");
while (gameRun == true) {
	PrintStatus(PlayerHP, PlayerMP, GoblinHP);
	int input = 0;
	if (userInput.hasNextInt()) {
		
	}
	else {
		
	}
}
}
}