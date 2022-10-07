package volodymyr.groupexpense.expense.domain.type;

import java.util.Arrays;

public enum Status {

    IN_PROGRESS, SETTLED;


    public static Status verificationType(String currency) {
        return Arrays.stream(Status.values())
                .filter(c -> c.name().equalsIgnoreCase(currency))
                .findFirst()
                .orElseGet(() -> IN_PROGRESS);
    }
}
