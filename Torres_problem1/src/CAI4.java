import java.security.SecureRandom;
import java.util.Scanner;

public class CAI4 {

	static SecureRandom randomNumbers = new SecureRandom();
	static Scanner userInput = new Scanner(System.in);
	
	static int answer;
	static int userAnswer;
	static int x;
	static int y;
	static int correctAnswers = 0;
	final static int amountOfMathProblems = 10;
	static int difficultyLevel;
	
	public static void main(String[] args) {
		
		int userAcceptance = 1;
		
		while(userAcceptance !=0) {
			quiz();
			
			System.out.println("Would you like to Solve more problems? Enter 0 to exit.");
			
			userAcceptance = userInput.nextInt();
		}
		
	}
	
	public static void quiz() {
	
		readDifficultyLevel();
		
		System.out.println("Solve this math problem:" );		
		
		for (int i = 0; i < amountOfMathProblems; i++) {
			
			askQuestion();
			readResponse();
			isAnswerCorrect();
			
		}
		
		displayCompletionMessage();

		
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
		
		double studentScore = ((double)correctAnswers/amountOfMathProblems)*100;
		
		System.out.printf("You scored %.2f.%%%n", studentScore);
		
		if(studentScore<75) {
			System.out.println("Please ask your teacher for extra help.");
		}
		else
			System.out.println("Congratulations, you are ready to go to the next level!");
		
	}
	
	public static void readDifficultyLevel() {
		
		System.out.println("Enter your difficulty level: 1-4");
		
		difficultyLevel = userInput.nextInt();
		
		if(difficultyLevel <1 || difficultyLevel>4) {
			readDifficultyLevel();
		}

	}
	
	public static void generateQuestionArgument() {
		
		int difficultyRange = 1;
		
		switch (difficultyLevel) {
		case 1:
			difficultyRange = 10;
			break;
		case 2:
			difficultyRange = 100;
			break;
		case 3:
			difficultyRange = 1000;
			break;
		case 4:
			difficultyRange = 10000;
		}
		
		x = randomNumbers.nextInt(difficultyRange);
		
		y = randomNumbers.nextInt(difficultyRange);
		
		answer = x * y;
	}

}