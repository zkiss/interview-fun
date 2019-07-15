package kissz;

public class RomanNumber {
    public static final String ZERO_VALUE = "";

    private final String romanForm;
    private final int value;

    public RomanNumber(String romanForm) {
        validate(romanForm);
        this.romanForm = romanForm;
        value = parse(romanForm);
    }

    private void validate(String romanForm) {
        // TODO not implemented now.
    }

    private int parse(String romanForm) {
        int sum = 0;
        char[] symbols = romanForm.toCharArray();
        for (int i = 0; i < symbols.length; i++) {
            RomanSymbol currentSymbol = RomanSymbol.fromChar(symbols[i]);
            RomanSymbol nextSymbol = i < (symbols.length - 1) ? RomanSymbol.fromChar(symbols[i + 1]) : null;

            if (nextSymbol != null && currentSymbol.isSmallerMagnitudeThan(nextSymbol)) {
                sum = sum + (nextSymbol.getValue() - currentSymbol.getValue());
                i++;
            } else {
                sum += currentSymbol.getValue();
            }
        }
        return sum;
    }

    public int value() {
        return value;
    }

    public String getRomanForm() {
        return romanForm;
    }

}
