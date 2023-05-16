import java.util.Scanner;

public class DFASimulator {
    public static void question_1(String inputString) {

        char[] alphabet = {'0', '1'};

        // Accepted state
        DfaState q0 = new DfaState("q0", true);

        // Rejected states
        DfaState q1 = new DfaState("q1", false);
        DfaState q2 = new DfaState("q2", false);
        DfaState q3 = new DfaState("q3", false);

        try {
            // Transition table for the DFA
            q0.addNextStates(new DfaState[] {q1, q3});
            q1.addNextStates(new DfaState[] {q0, q2});
            q2.addNextStates(new DfaState[] {q3, q1});
            q3.addNextStates(new DfaState[] {q2, q0});
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }

        DfaState curState = q0; // Starting state is q0

        System.out.print("\nTransitions: q0");

        // Traverse the input string and update the current state
        for (char c : inputString.toCharArray()) {
            if (c == '0') {
                curState = curState.nextStates.get('0');
                System.out.print(" -> " + curState.name);
            } else if (c == '1') {
                curState = curState.nextStates.get('1');
                System.out.print(" -> " + curState.name);
            } else {
                System.out.println("Invalid input character: " + c);
                System.exit(0);
            }
        }

        // Check if the final state is accepting
        if (curState.isAccepted) {
            System.out.println("\nThe input string is accepted at state " + curState.name);
        } else {
            System.out.println("\nThe input string is not accepted at state " + curState.name);
        }
    }

    public static void question_2(String inputString) {

        char[] alphabet = {'0', '1'};

        // Rejected states
        DfaState q0 = new DfaState("q0", false);
        DfaState q1 = new DfaState("q1", false);
        DfaState q2 = new DfaState("q2", false);

        // Accepted states
        DfaState q3 = new DfaState("q3", true);
        DfaState q4 = new DfaState("q4", true);

        try {
            // Transition table for the DFA
            q0.addNextStates(new DfaState[] {q1, q0});
            q1.addNextStates(new DfaState[] {q2, q0});
            q2.addNextStates(new DfaState[] {q3, q0});
            q3.addNextStates(new DfaState[] {q3, q4});
            q4.addNextStates(new DfaState[] {q1, q4});
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            System.exit(-2);
        }

        DfaState curState = q0; // Starting state is q0

        System.out.print("\nTransitions: q0");

        // Traverse the input string and update the current state
        for (char c : inputString.toCharArray()) {
            if (c == '0') {
                curState = curState.nextStates.get('0');
                System.out.print(" -> " + curState.name);
            } else if (c == '1') {
                curState = curState.nextStates.get('1');
                System.out.print(" -> " + curState.name);
            } else {
                System.out.println("Invalid input character: " + c);
                System.exit(0);
            }
        }

        // Check if the final state is accepting
        if (curState.isAccepted) {
            System.out.println("\nThe input string is accepted at state " + curState.name);
        } else {
            System.out.println("\nThe input string is not accepted at state " + curState.name);
        }
    }

    public static void main(String[] args) {
        System.out.print("Question 1\n");

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the input string: ");
        String inputString = input.nextLine();

        DFASimulator.question_1(inputString);

        System.out.print("\nQuestion 2\n");

        System.out.print("Enter the input string: ");
        String inputString2 = input.nextLine();

        DFASimulator.question_2(inputString2);
    }

}
