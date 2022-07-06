package pedro.com.github.ApiVendasJava.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
@Table(name = "produto")
@NoArgsConstructor
@AllArgsConstructor
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "titulo", length = 100)
    @NotEmpty(message = "Campo titulo é obrigatório")
    private String titulo;

    @Column(name = "preco_unitario")
    @NotNull(message = "Campo preco é obrigatório")
    private Double preco;

}
