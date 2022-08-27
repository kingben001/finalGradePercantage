import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int conceptTest1 = getScore("Enter score for Concept Test 1");
        int programmingTest1 = getScore("Enter score for Programming Test 1");
        int conceptTest2 = getScore("Enter score for Concept Test 2");
        int programmingTest2 = getScore("Enter score for Programming Test 2");
        int conceptFinal = getScore("Enter score for Concept Final");
        int programmingFinal = getScore("Enter score for Programming Final");

        conceptTest1 = overrideScore(conceptTest1,conceptFinal);
        programmingTest1 = overrideScore(programmingTest1, programmingFinal);
        conceptTest2 = overrideScore(conceptTest2,conceptFinal);
        programmingTest2 = overrideScore(programmingTest2,programmingFinal);

        double finalPercentage =  calculateFinalPercentage( conceptTest1, programmingTest1,
                conceptTest2, programmingTest2, conceptFinal,  programmingFinal);

char letterGrade =  determineLetterGrade(finalPercentage);

printInfo(finalPercentage,letterGrade);

    }
    public static int getScore(String message) {
        
        Scanner keyboard = new Scanner(System.in);
        int score;
        do {
            System.out.println(message);
            score = keyboard.nextInt();
            if (score < 0 || score > 100) {
                System.out.println("Please enter a valid number?");
            }

        } while (score < 0 || score > 100);

        return score ;
    }



    public static int overrideScore(int test, int finalTest){

        if (test < finalTest){
            test = finalTest;
        }

        return test;
    }

    public static double calculateFinalPercentage(int conceptTest1, int programmingTest1, int
            conceptTest2, int programmingTest2, int conceptFinal, int programmingFinal){

    return (conceptTest1 * .20) + (programmingTest1 * .20) + (conceptTest2 * .20) + (programmingTest2 * .20) + (conceptFinal * .10) + (programmingFinal *.10);

    }

    public static char determineLetterGrade(double finalPercentage) {
        
        char letterGrade = 0;
        if (finalPercentage >= 80 && finalPercentage <= 100) {
            letterGrade = 'A';
        }
        if (finalPercentage >= 60 && finalPercentage <= 79) {
            letterGrade = 'B';
        }
        if (finalPercentage >= 1 && finalPercentage <= 59) {
            letterGrade = 'C';
        }
        if (finalPercentage <= 0) {
            letterGrade = 'D';
        }


        return letterGrade;
    }

        public static void printInfo ( double finalPercentage, char letterGrade){

            System.out.println("Your final grade is: " +finalPercentage+ ". This leaves you with a " + letterGrade);
        }
        }
