import java.security.SecureRandom;
import java.util.Scanner;

public class CAI1 {

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
		System.out.println("Very Good!");
	}
	
	public static void displayIncorrectResponse() {
		System.out.println("No. Please try again.");
	}

}
