import java.util.HashMap;

public class State {
    String name;
    boolean isAccepted;

    char[] alphabet;

    HashMap<Character, State> nextStates;

    public State(String name, boolean isAccepted, char[] alphabet) {
        this.name = name;
        this.isAccepted = isAccepted;
        this.alphabet = alphabet;
    }

    public void addNextStates(State[] states) throws Exception {

        this.nextStates = new HashMap<Character, State>();

        if(states.length != alphabet.length)
            throw new Exception("Length Mismatch !");

        for(int i = 0; i < alphabet.length; i++) {
            nextStates.put(alphabet[i], states[i]);
        }
    }
}
