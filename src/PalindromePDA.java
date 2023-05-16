import java.util.Scanner;
import java.util.Stack;

public class PalindromePDA {
    private Stack<Character> pdaStack;

    public PalindromePDA() {
        pdaStack = new Stack<Character>();
    }

    public boolean accept(String input) {

        // Rejected states
        PdaState qStart = new PdaState("qStart", false);
        PdaState qLoop = new PdaState("qLoop", false);
        PdaState q1 = new PdaState("q1", false);
        PdaState q2 = new PdaState("q2", false);
        PdaState q3 = new PdaState("q3", false);
        PdaState q4 = new PdaState("q4", false);
        PdaState q5 = new PdaState("q5", false);

        // Accepted state
        PdaState qAccept = new PdaState("qAccept", true);

        try {
            // Transition table for the PDA
            qStart.addNextStates(new PdaInput[]{new PdaInput('ε', 'ε', '$')}, new PdaState[] {
                    q1
            });

            q1.addNextStates(new PdaInput[]{new PdaInput('ε', 'ε', 'S')}, new PdaState[] {
                    qLoop
            });

            q2.addNextStates(new PdaInput[]{new PdaInput('ε', 'ε', 'S')}, new PdaState[] {
                    q3
            });

            q3.addNextStates(new PdaInput[]{new PdaInput('ε', 'ε', 'a')}, new PdaState[] {
                    qLoop
            });

            q4.addNextStates(new PdaInput[]{new PdaInput('ε', 'ε', 'S')}, new PdaState[] {
                    q5
            });

            q5.addNextStates(new PdaInput[]{new PdaInput('ε', 'ε', 'b')}, new PdaState[] {
                    qLoop
            });

            qLoop.addNextStates(new PdaInput[]{
                    new PdaInput('ε', '$', 'ε'),
                    new PdaInput('ε', 'S', 'a'),
                    new PdaInput('ε', 'S', 'b'),

                    new PdaInput('ε', 'S', 'a'),
                    new PdaInput('ε', 'S', 'b'),
                    new PdaInput('ε', 'S', 'ε'),
                    new PdaInput('b', 'b', 'ε'),
                    new PdaInput('a', 'a', 'ε'),

            }, new PdaState[] {
                    qAccept,
                    q2,
                    q4,

                    qLoop,
                    qLoop,
                    qLoop,
                    qLoop,
                    qLoop,
            });
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }

        PdaState curState = qStart;

        char pushedItem = '$';

        pdaStack.push(pushedItem);
        curState = curState.getNextState(new PdaInput('ε', 'ε', pushedItem));

        System.out.println("\nTransitions: " + curState.getGrammer(new PdaInput('ε', 'ε', pushedItem)));

        pushedItem = 'S';

        pdaStack.push(pushedItem);
        curState = curState.getNextState(new PdaInput('ε', 'ε', pushedItem));

        System.out.println(curState.getGrammer(new PdaInput('ε', 'ε', pushedItem)));


        while(input.length() > 0) {
            char symbol = input.charAt(0);

            if(curState == qLoop) {
                if(symbol == pdaStack.peek()) {
                    curState = curState.getNextState(new PdaInput(symbol, symbol, 'ε'));

                    System.out.println(curState.getGrammer(new PdaInput(symbol, symbol, 'ε')));

                    pdaStack.pop();

                    // remove the first character of the original string
                    input = input.substring(1);
                }

                else {
                    if(pdaStack.peek() != 'S') {
                        return false;
                    }

                    if(input.length() == pdaStack.size() - 2) {
                        curState = curState.getNextState(new PdaInput('ε', pdaStack.peek(), 'ε'));

                        System.out.println(curState.getGrammer(new PdaInput('ε', pdaStack.peek(), 'ε')));

                        pdaStack.pop();
                    }

                    else if(input.length() < pdaStack.size()) {
                        curState = qLoop;

                        System.out.println(curState.getGrammer(new PdaInput('ε', pdaStack.peek(), symbol)));

                        pdaStack.push(symbol);
                    }

                    else {
                        if(symbol == 'a') {
                            curState = q2;
                        }
                        else if(symbol == 'b') {
                            curState = q4;
                        }

                        System.out.println(curState.getGrammer(new PdaInput('ε', pdaStack.peek(), symbol)));

                        pdaStack.pop();

                        pdaStack.push(symbol);
                    }
                }
            }

            else {
                System.out.println(curState.getGrammer(curState.transitionStates.get(0)));

                pdaStack.push(curState.getPushedItem(curState.transitionStates.get(0)));

                curState = curState.getNextState(curState.transitionStates.get(0));
            }
        }

        return pdaStack.peek() == '$';
    }

    public static void main(String[] args) {
        PalindromePDA pda = new PalindromePDA();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an input string: ");
        String input = scanner.nextLine();

        if (pda.accept(input)) {
            System.out.println("The input string is Accepted");
        } else {
            System.out.println("The input string is Rejected");
        }
    }
}