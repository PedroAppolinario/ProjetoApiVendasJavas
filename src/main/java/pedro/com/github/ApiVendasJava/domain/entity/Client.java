package pedro.com.github.ApiVendasJava.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "client")
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    @NotEmpty(message = "Campo nome é obrigatório")
    @Length(min = 5, max = 120, message = "o tamanho deve ser entre 5 e 120 letras")
    private String nome;

    @Column
    @NotEmpty(message = "Campo email é obrigatório")
    @Email(message = "Email invalido !")
    private String email;

    @Column
    @NotEmpty(message = "Telefone é obrigatório")
    @Length(min = 8, max = 15, message = "o Telefone deve contar entre 5 e 120 char.")
    private String telefone;

    @Column(unique = true, name = "cpf")
    @CPF
    @NotEmpty(message = "CPF não pode ser vazio")
    private String cpf;

    @Column(name = "endereco")
    @Length(min = 5, max = 120, message = "o tamanho deve ser entre 5 e 120 letras")
    private String endereco;

}
