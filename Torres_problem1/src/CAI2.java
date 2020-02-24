import java.security.SecureRandom;
import java.util.Scanner;

public class CAI2 {

	static SecureRandom randomNumbers = new SecureRandom();
	static Scanner userInput = new Scanner(System.in);
	
	static int answer;
	static int userAnswer;
	static int x;
	static int y;
	
	public static void main(String[] args) {
		
		quiz();
		
	}
	
	public static void quiz() {
	
		System.out.println("Solve this math problem:" );
		
		x = randomNumbers.nextInt(10);
		
		y = randomNumbers.nextInt(10);
		
		answer = x * y;
		
		askQuestion();
		readResponse();
		isAnswerCorrect();
		
	}
	
	public static void askQuestion() {
		
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
			askQuestion();
			readResponse();
			isAnswerCorrect();
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

}
