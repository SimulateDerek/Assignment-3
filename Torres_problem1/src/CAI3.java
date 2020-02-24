import java.security.SecureRandom;
import java.util.Scanner;

public class CAI3 {

	static SecureRandom randomNumbers = new SecureRandom();
	static Scanner userInput = new Scanner(System.in);
	
	static int answer;
	static int userAnswer;
	static int x;
	static int y;
	static int correctAnswers = 0;
	final static int amountOfMathProblems = 10;
	
	public static void main(String[] args) {
		
		int userAcceptance = 1;
		
		while(userAcceptance == 1) {
			quiz();
			
			System.out.println("Would you like to Solve more problems? Enter 1 to continue.");
			
			userAcceptance = userInput.nextInt();
		}
		
	}
	
	public static void quiz() {
	
		System.out.println("Solve this math problem:" );		
		
		for (int i = 0; i < amountOfMathProblems; i++) {
			
			askQuestion();
			readResponse();
			isAnswerCorrect();
			
		}
		
		displayCompletionMessage();

		
	}
	
	public static void askQuestion() {
		
		x = randomNumbers.nextInt(10);
		
		y = randomNumbers.nextInt(10);
		
		answer = x * y;
		
		System.out.printf("%s x %s%n", x,y);		
	}
	
	public static void readResponse() {		
		
		userAnswer = userInput.nextInt();	
	}
	
	
	public static void isAnswerCorrect() {
		
		if(answer == userAnswer) {
			displayCorrectResponse();
		}
		else {
			displayIncorrectResponse();
		}
	}
	
	public static void displayCorrectResponse() {
		switch (randomNumbers.nextInt(4)+1) {
		case 4:
			System.out.println("Very Good!");
			break;
		case 3:
			System.out.println("Excellent!");
			break;
		case 2:
			System.out.println("Nice work!");
			break;
		case 1:
			System.out.println("Keep up the good work!");
			break;
		}
		correctAnswers++;
	}
	
	public static void displayIncorrectResponse() {
		switch (randomNumbers.nextInt(4)+1) {
		case 4:
			System.out.println("No. Please try again.");
			break;
		case 3:
			System.out.println("Wrong. Try once more.");
			break;
		case 2:
			System.out.println("Don’t give up!");
			break;
		case 1:
			System.out.println("No. Keep trying.");
			break;
		}
	}
	
	public static void displayCompletionMessage() {
		
		double studentScore = (double)correctAnswers/amountOfMathProblems;
		
		System.out.printf("You scored %.2f.%n", studentScore);
		
		if(studentScore<0.75) {
			System.out.println("Please ask your teacher for extra help.");
		}
		else
			System.out.println("Congratulations, you are ready to go to the next level!");
		
	}

}