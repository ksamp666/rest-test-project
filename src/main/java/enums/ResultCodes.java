package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ResultCodes {
    OK("Ok"),
    UNAUTHORIZED("Unauthorized");

    @Getter
    private String textValue;
}
