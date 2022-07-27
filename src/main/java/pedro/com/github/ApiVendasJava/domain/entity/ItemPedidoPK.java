package pedro.com.github.ApiVendasJava.domain.entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;

@Data
public class ItemPedidoPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

}