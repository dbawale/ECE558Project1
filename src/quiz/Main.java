
package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static java.lang.System.exit;

/**
 * @author Deven Bawale   dbawale@pdx.edu
 * The main file for console {@link quiz.Quiz Quiz} application. Includes the main class
 * that interacts with the user
 */
public class Main {

    /**
     * Main method for the project. Keeps executing PlayQuiz until user inputs 'n' at the end
     * @param args Command line arguments, not used for this project.
     */
    public static void main(String[] args){

        Boolean inputerror = false; //tracks whether there was an input error
        Quiz quiz = startQuiz();


        //keep taking the quiz until user inputs 'n' at the end of the quiz
        while(true){
            //if there was no input error in the previous iteration
            if(!inputerror)
            {
                try
                {
                    playQuiz(quiz);
                } catch (IOException e)
                {
                    System.err.println("There was an input/output error. Please try again");
                }
            }
            System.out.println("Do you want to take the quiz again? (y|n)");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                inputerror = false;
                String playagain = br.readLine();

                //continue playing if the user wants to play again
                if(playagain.equals("y")||playagain.equals("Y"))
                {
                    continue;
                }
                //otherwise break the loop
                else if(playagain.equals("n")||playagain.equals("N"))
                {
                    break;
                }
                //if user enters anything other than y,Y,n or N, set inputerror and ask again
                else
                {
                    System.err.println("You entered an incorrect value. Please try again.");
                    inputerror=true;
                }
            } catch (IOException e) {
                System.err.println("Problem with input/output. Exiting application.");
                exit(1);
            }
        }
    }

    /**
     * Sets up the default quiz.
     * @return The quiz, with all questions and answers
     */
     private static Quiz startQuiz(){
        Quiz quiz = new Quiz();
        quiz.setupDefaultQuiz();
         return quiz;
     }

    /**
     * The play quiz method. Displays the questions and interacts with the user, waiting for user input.
     * Displays whether the current question was answered correctly or not. Displays the score at the end of the game.
     * @param quiz The Quiz object to be played
     * @throws IOException When there is a problem with the input/output device, or when input cannot be read.
     */
    private static void playQuiz(Quiz quiz) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Question> questions = quiz.getQuestions();
        int i=0;
        //repeat for all questions
       while(i<questions.size())
        {
                Boolean isvalidinput = true;
                System.out.println(questions.get(i).toString());
                System.out.print("Enter correct option:");
                String answer = br.readLine();
                if (!validateOptions(answer)) {
                    System.out.println("Please choose one of the four displayed options (eg, a).\n" +
                    "Answer the question again:");
                    isvalidinput=false;
                }
            if(isvalidinput) {
                if (answer.toLowerCase().charAt(0) == questions.get(i).getCorrectanswer().toLowerCase().charAt(0)) {
                    quiz.incrementScore();
                    System.out.println("Correct!");
                } else {
                    System.out.println("Incorrect!");
                }
                System.out.println("Score: " + quiz.getScore());
                i+=1;
            }
        }
            System.out.println("Your final score is: " + quiz.getScore() + "/" + quiz.getQuestions().size());
            float percent = (((float)quiz.getScore() / (float)quiz.getQuestions().size()) * 100);
            System.out.printf("Percentage: %.2f\n" ,percent);
        }

    /**
     * Validates user input. Uses a regular expression
     * @param answer The input to validate
     * @return True or false, depending on whether it matches [a-d]+
     */
    private static boolean validateOptions(String answer) {
        return answer.matches("[a-d]+");
    }
}