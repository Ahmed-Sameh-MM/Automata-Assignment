import java.util.HashMap;

public class DfaState {
    String name;
    boolean isAccepted;

    char[] alphabet = {'0', '1'};

    HashMap<Character, DfaState> nextStates;

    public DfaState(String name, boolean isAccepted) {
        this.name = name;
        this.isAccepted = isAccepted;
    }

    public void addNextStates(DfaState[] states) throws Exception {

        this.nextStates = new HashMap<Character, DfaState>();

        if(states.length != alphabet.length)
            throw new Exception("Length Mismatch !");

        for(int i = 0; i < alphabet.length; i++) {
            nextStates.put(alphabet[i], states[i]);
        }
    }
}
