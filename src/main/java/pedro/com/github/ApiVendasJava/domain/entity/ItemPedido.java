package pedro.com.github.ApiVendasJava.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.text.NumberFormat;
import java.util.Locale;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ItemPedido {
    @JsonIgnore
    @EmbeddedId
    private ItemPedidoPK id = new ItemPedidoPK();

    private Integer quantidade;

    private Double preco;

    public ItemPedido() {
    }

    public ItemPedido(Pedido pedido, Produto produto, Integer quantidade, Double preco) {
        this.id.setPedido(pedido);
        this.id.setProduto(produto);
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public void geraSubTotal(){
        preco = preco * quantidade;
    }

    public double getSubTotal(){
        return preco * quantidade;
    }

    @JsonIgnore
    public Pedido getPedido(){
        return this.id.getPedido();
    }

    public void setPedido(Pedido pedido){
        id.setPedido(pedido);
    }

    public void setProduto(Produto produto){
        id.setProduto(produto);
    }

    public Produto getProduto(){
        return this.id.getProduto();
    }

    public ItemPedidoPK getId() {
        return id;
    }

    public void setId(ItemPedidoPK id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        final StringBuffer sb = new StringBuffer();
        sb.append(getProduto().getTitulo())
                .append(", Qte: " + getQuantidade())
                .append(", PreÃ§o Unitario: " + nf.format(getPreco()))
                .append(" subTotal: " + nf.format(getSubTotal()))
                .append("\n");
        return sb.toString();
    }
}
