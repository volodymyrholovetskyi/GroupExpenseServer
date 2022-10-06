package volodymyr.groupexpense.expense.domain.vo;

import lombok.Value;
import volodymyr.groupexpense.expense.domain.exceptions.InvalidGroupNameException;

@Value
public class GroupName {

    String name;

    private GroupName(String name) {

        this.name = name;
    }

    public static GroupName createName(String name) {
        if (name == null || name.length() < 3) {
            throw new InvalidGroupNameException(name);
        }
        return new GroupName(name);
    }
}
