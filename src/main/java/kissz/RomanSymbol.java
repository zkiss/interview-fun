package kissz;

import java.util.Comparator;

enum RomanSymbol {
    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000);

    private final int value;

    RomanSymbol(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    static Comparator<RomanSymbol> byMagnitudeIncreasing() {
        // happens to be
        return Comparator.naturalOrder();
    }

    public boolean isSmallerMagnitudeThan(RomanSymbol other) {
        return byMagnitudeIncreasing().compare(this, other) < 0;
    }

    public static RomanSymbol fromChar(char symbol) {
        return valueOf(Character.toString(symbol));
    }
}
