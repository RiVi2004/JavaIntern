import java.util.Scanner;

public class QuizApplication
{
	private static final int TOTAL_QUESTIONS = 5;
	private static final int TIME_LIMIT_SECONDS = 60;
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args)
	{
		System.out.println("Welcome to the Quiz Application!");
		System.out.println("You have " + TIME_LIMIT_SECONDS + " seconds to complete " + TOTAL_QUESTIONS + " questions.");
	
        		Quiz quiz = new Quiz();
        		Thread timerThread = new Thread(new Timer());
        		timerThread.start();

	        	for (int i = 0; i < TOTAL_QUESTIONS; i++)
		{
            			System.out.println("Question " + (i + 1) + ": " + quiz.getQuestion(i));
            			System.out.print("Your answer: ");
            			String answer = scanner.nextLine();
            			quiz.submitAnswer(answer);
        		}
	        	timerThread.interrupt(); // Stop the timer thread
	      	System.out.println("Quiz completed!");
        		System.out.println("Your score: " + quiz.getScore() + "/" + TOTAL_QUESTIONS);
    	}

    	static class Timer implements Runnable
	{
        		@Override
        		public void run()
		{
            			try 
			{
                			Thread.sleep(TIME_LIMIT_SECONDS * 1000);
                			System.out.println("\nTime's up!");
                			System.exit(0); // Terminate the program when time is up
            			}
			catch (InterruptedException e)
			{
			                // Timer thread was interrupted, likely because quiz completed before time ran out
            			}
        		}
    	}

	static class Quiz 
	{
        		private String[] questions = 
		{
            			"What is the capital of France?",
            			"What is the largest planet in our solar system?",
            			"Who wrote 'Romeo and Juliet'?",
            			"What is the chemical symbol for water?",
            			"What is the powerhouse of the cell?"
        		};
        		private String[] answers = {"Paris", "Jupiter", "William Shakespeare", "H2O", "Mitochondria"};
        		private int score = 0;

        		public String getQuestion(int index) 
		{
            			return questions[index];
        		}

        		public void submitAnswer(String answer) 
		{
            			if (answer.equalsIgnoreCase(answers[score])) 
			{
                			System.out.println("Correct!");
                			score++;
            			}	
			else 
			{
                			System.out.println("Incorrect!");
            			}
        		}

        		public int getScore() 
		{
            			return score;
        		}
    	}
}
