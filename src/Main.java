import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Question 1\n");

        Scanner input = new Scanner(System.in);

//        System.out.print("Enter the input string: ");
//        String inputString = input.nextLine();
//
//        DFASimulator.question_1(inputString);

        System.out.print("Question 2\n");

        System.out.print("Enter the input string: ");
        String inputString2 = input.nextLine();

        DFASimulator.question_2(inputString2);
    }
}