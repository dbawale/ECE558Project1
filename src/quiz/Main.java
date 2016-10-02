package quiz;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int score;
    public static void main(String[] args){
        Quiz quiz = startQuiz();
        score =0;
        try {
            playQuiz(quiz);
        }
        catch(IOException e){
            System.err.println("There was an input/output error. Please try again");
        }
    }

     private static Quiz startQuiz(){
        Quiz quiz = new Quiz();
        quiz.setupDefaultQuiz();
         return quiz;
     }

    private static void playQuiz(Quiz quiz) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            for (Question q :
                    quiz.getQuestions()) {
                System.out.println(q.toString());
                System.out.print("Enter correct option:");
                String answer = br.readLine();
                if (!validateOptions(answer)) return;
                if (answer.charAt(0) == q.getCorrectanswer().charAt(0)) {
                    score += 1;
                }
                System.out.println("Score: " + score);
            }
            //TODO: Check and fix percentage print format
            System.out.println("Your score is: " + score + "/" + quiz.getQuestions().size());
            float percent = (float) (score / quiz.getQuestions().size()) * 100;
            System.out.println("Percentage: " + percent);
        }

    private static boolean validateYesNo(String takeagain) throws IOException {
        if(takeagain.matches("y") || takeagain.matches("Y")) return true;
        else if(takeagain.matches("n")||takeagain.matches("N")) return false;
        else throw new IOException();
    }


    /**
     * Validates user input. Uses a regular expression
     * @param answer
     * @return
     */
    private static boolean validateOptions(String answer) {
        return answer.matches("[a-d]+");
    }

    /**
     * Allows the user to set up a custom quiz with questions, answers and correct answers
     * @throws IOException When input/output error occurs.
     * TODO: Add method logic, interaction with user and creation of new quiz
     */
    public void setupCustomQuiz() throws IOException {
        throw new NotImplementedException();

    }
}