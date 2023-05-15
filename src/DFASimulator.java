public class DFASimulator {
    public static void question_1(String inputString) {

        char[] alphabet = {'0', '1'};

        // Accepted state
        State q0 = new State("q0", true, alphabet);

        // Rejected states
        State q1 = new State("q1", false, alphabet);
        State q2 = new State("q2", false, alphabet);
        State q3 = new State("q3", false, alphabet);

        try {
            // Transition table for the DFA
            q0.addNextStates(new State[] {q1, q3});
            q1.addNextStates(new State[] {q0, q2});
            q2.addNextStates(new State[] {q3, q1});
            q3.addNextStates(new State[] {q2, q0});
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }

        State curState = q0; // Starting state is q0

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
        State q0 = new State("q0", false, alphabet);
        State q1 = new State("q1", false, alphabet);
        State q2 = new State("q2", false, alphabet);

        // Accepted states
        State q3 = new State("q3", true, alphabet);
        State q4 = new State("q4", true, alphabet);

        try {
            // Transition table for the DFA
            q0.addNextStates(new State[] {q1, q0});
            q1.addNextStates(new State[] {q2, q0});
            q2.addNextStates(new State[] {q3, q0});
            q3.addNextStates(new State[] {q3, q4});
            q4.addNextStates(new State[] {q1, q4});
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            System.exit(-2);
        }

        State curState = q0; // Starting state is q0

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

}
