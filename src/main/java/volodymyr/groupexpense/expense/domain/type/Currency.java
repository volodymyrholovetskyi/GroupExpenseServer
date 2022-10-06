package volodymyr.groupexpense.expense.domain.type;

import java.util.Arrays;

public enum Currency {

    PLN, USD, HRN, EURO;

    public static Currency verificationType(String currency) {
        return Arrays.stream(Currency.values())
                .filter(c -> c.name().equalsIgnoreCase(currency))
                .findFirst()
                .orElseGet(() -> PLN);
    }
}
