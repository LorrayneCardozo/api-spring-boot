package dio.project.personapi.dto.request;

import dio.project.personapi.enums.AddressType;

import dio.project.personapi.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private Long id;
    @Enumerated(EnumType.STRING)
    private AddressType type;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String street;

    @NotEmpty
    private String number;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String neighborhood;

    private String complement;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String city;

    @Enumerated(EnumType.STRING)
    private State state;
}
