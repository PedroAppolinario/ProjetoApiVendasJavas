package pedro.com.github.ApiVendasJava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pedro.com.github.ApiVendasJava.domain.entity.ItemPedido;
import pedro.com.github.ApiVendasJava.domain.entity.Pedido;
import pedro.com.github.ApiVendasJava.repository.ItemPedidoRepository;
import pedro.com.github.ApiVendasJava.repository.PedidoRepository;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ProdutoService produtoService;

    public Pedido inserirPedido(Pedido pedido) {
        pedido.setId(null);
        pedido.setInstante(new Date());
        pedido.setCliente(clienteService.find(pedido.getCliente().getId()));
        pedido = pedidoRepository.save(pedido);

        for (ItemPedido ip : pedido.getItens()) {
            ip.setProduto(produtoService.find(ip.getProduto().getId()));
            ip.setPreco(ip.getProduto().getPreco());
            ip.geraSubTotal();
            ip.setPedido(pedido);
        }
        itemPedidoRepository.saveAll(pedido.getItens());
        return pedido;
    }

}
