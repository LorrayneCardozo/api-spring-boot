package dio.project.personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AddressType {
    HOUSE("House"),
    APARTMENT("Apartment"),
    COMMERCE("Commerce");
    private final String description;
}
