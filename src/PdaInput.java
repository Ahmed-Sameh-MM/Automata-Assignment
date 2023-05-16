import java.util.Objects;

public class PdaInput {
    char input;

    char popItem;

    char pushItem;

    public PdaInput(char input, char popItem, char pushItem) {
        this.input = input;
        this.popItem = popItem;
        this.pushItem = pushItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PdaInput pdaInput = (PdaInput) o;
        return input == pdaInput.input && popItem == pdaInput.popItem && pushItem == pdaInput.pushItem;
    }

    @Override
    public int hashCode() {
        return Objects.hash(input, popItem, pushItem);
    }
}
