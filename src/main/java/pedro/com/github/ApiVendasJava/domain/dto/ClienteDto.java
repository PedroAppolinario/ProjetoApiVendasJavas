package pedro.com.github.ApiVendasJava.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {

    private Integer id;

    @NotEmpty(message = "Campo nome é obrigatório")
    @Length(min = 5, max = 120, message = "o tamanho deve ser entre 5 e 120 letras")
    private String nome;

    @NotEmpty(message = "Campo email é obrigatório")
    @Email(message = "Email invalido !")
    private String email;

    @NotEmpty(message = "Telefone é obrigatório")
    @Length(min = 8, max = 15, message = "o Telefone deve contar entre 5 e 120 char.")
    private String telefone;

}
