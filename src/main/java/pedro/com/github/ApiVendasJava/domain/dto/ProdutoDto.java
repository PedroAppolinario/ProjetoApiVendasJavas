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
public class ProdutoDto {

    private Integer id;

    @NotEmpty(message = "Título é obrigatório")
    @Length(min = 8, max = 15, message = "o Telefone deve contar entre 5 e 120 char.")
    private String titulo;

    @NotEmpty(message = "Valor é obrigatório")
    private Double valor;


}
