package uz.jl.dto.test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.jl.dto.GenericDto;

/**
 * @author Bakhromjon Wed, 9:39 AM 1/26/2022
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TestUpdateDto extends GenericDto {
    private String question;
}
