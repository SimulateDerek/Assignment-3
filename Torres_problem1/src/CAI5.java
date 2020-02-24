import java.security.SecureRandom;
import java.util.Scanner;

public class CAI5 {

	static SecureRandom randomNumbers = new SecureRandom();
	static Scanner userInput = new Scanner(System.in);
	
	static double answer;
	static double userAnswer;
	static double x;
	static double y;
	static int correctAnswers = 0;
	final static int amountOfMathProblems = 10;
	static int difficultyLevel;
	static int problemType;
	
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
		readProblemType();
		
		System.out.println("Solve this math problem:" );		
		
		for (int i = 0; i < amountOfMathProblems; i++) {
			
			generateQuestionArgument();
			readResponse();
			isAnswerCorrect();
			
		}
		
		displayCompletionMessage();

		
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
			
			System.out.println("Error, Please ");

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
		
		switch (problemType) {
		case 5:
			int randomQuestion = randomNumbers.nextInt(3)+1;
			switch (randomQuestion) {
			case 4:
				answer = x/y;
				askQuestion("/");
				break;
			case 3:
				answer = x - y;
				askQuestion("-");
				break;
			case 2:
				answer = x * y;
				askQuestion("*");
				break;
			case 1:
				answer = x+y;
				askQuestion("+");
			}
			break;
		case 4:
			answer = x/y;
			askQuestion("/");
			break;
		case 3:
			answer = x - y;
			askQuestion("-");
			break;
		case 2:
			answer = x * y;
			askQuestion("*");
			break;
		case 1:
			answer = x+y;
			askQuestion("+");
		}
	}
	
	public static void askQuestion(String string) {
		
		
		System.out.printf("%s %s %s%n", (int)x, string, (int)y);		
	}
	
	public static void readProblemType() {
		
		System.out.printf("Select one of the following problem sets:%n"
				+ "1 for Addition.%n"
				+ "2 for Multiplication.%n"
				+ "3 for Subtraction.%n"
				+ "4 for Division%n"
				+ "5 for a mixture%n");
		
		problemType = userInput.nextInt();
		
		if(problemType <1 || problemType>5) {
			
			System.out.printf("Error: Please "); 
			readProblemType();
		}
		
	}

}