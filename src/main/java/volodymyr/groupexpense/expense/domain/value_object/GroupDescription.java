package volodymyr.groupexpense.expense.domain.value_object;

import lombok.EqualsAndHashCode;
import lombok.Value;
import volodymyr.groupexpense.expense.domain.exceptions.InvalidGroupDescriptionException;

@Value
@EqualsAndHashCode
public class GroupDescription {

    String groupDescription;

    private GroupDescription(String groupDescription) {

        this.groupDescription = groupDescription;
    }

    public static GroupDescription ofName(String groupDescription) {
        if (groupDescription == null || groupDescription.length() < 3) {
            throw new InvalidGroupDescriptionException(groupDescription);
        }
        return new GroupDescription(groupDescription);
    }
}
