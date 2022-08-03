package pedro.com.github.ApiVendasJava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pedro.com.github.ApiVendasJava.domain.entity.ItemPedido;
import pedro.com.github.ApiVendasJava.domain.entity.Pedido;
import pedro.com.github.ApiVendasJava.exception.ObjectNotFoundException;
import pedro.com.github.ApiVendasJava.repository.ClienteRepository;
import pedro.com.github.ApiVendasJava.repository.ItemPedidoRepository;
import pedro.com.github.ApiVendasJava.repository.PedidoRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;
import java.util.OptionalInt;

@Service
@RequiredArgsConstructor
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private ClienteRepository c;

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

    public Pedido findById(Integer id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        return pedido.orElseThrow(()-> new ObjectNotFoundException("Obj não encontrado! id:" + id + "tipo: " +
                Pedido.class.getName()));
    }

    public Page<Pedido> findPage(Integer page, Integer linesPerPage, String orderBy,
                                 String direction, Integer id){
        PageRequest pageRequest = PageRequest.of(page,linesPerPage, Sort.Direction.valueOf(direction), orderBy);

        return pedidoRepository.findByCliente(c.findById(id), pageRequest);
    }
}
