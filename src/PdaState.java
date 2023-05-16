import java.util.ArrayList;
import java.util.HashMap;

public class PdaState {
    String name;
    boolean isAccepted;

    char[] alphabet = {'a', 'b'};

    HashMap<PdaInput, PdaState> nextStates;

    ArrayList<PdaInput> transitionStates;

    public PdaState(String name, boolean isAccepted) {
        this.name = name;
        this.isAccepted = isAccepted;
    }

    public void addNextStates(PdaInput[] pdaInputs, PdaState[] pdaStates) throws Exception {

        this.nextStates = new HashMap<PdaInput, PdaState>();

        this.transitionStates = new ArrayList<PdaInput>();

        if(pdaInputs.length != pdaStates.length)
            throw new Exception("Length Mismatch !");

        for(int i = 0; i < pdaStates.length; i++) {
            nextStates.put(pdaInputs[i], pdaStates[i]);

            transitionStates.add(pdaInputs[i]);
        }
    }


    public char getPushedItem(PdaInput pdaInput) {
        return pdaInput.pushItem;
    }

    public PdaState getNextState(PdaInput pdaInput) {
        return nextStates.get(pdaInput);
    }

    public String getGrammer(PdaInput pdaInput) {
        return pdaInput.input + ", " + pdaInput.popItem + " -> " + pdaInput.pushItem;
    }
}