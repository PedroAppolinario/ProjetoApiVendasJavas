package pedro.com.github.ApiVendasJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pedro.com.github.ApiVendasJava.domain.entity.Pedido;
import pedro.com.github.ApiVendasJava.service.PedidoService;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/pedido")
public class PedidoController {


    @Autowired
    private PedidoService pedidoService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> inserirPedido(@Valid @RequestBody Pedido pedido) {
        pedido = pedidoService.inserirPedido(pedido);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(pedido.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @RequestMapping
    public ResponseEntity<Pedido> find(@PathVariable Integer id){
        Pedido pedido= pedidoService.findById(id);
        return ResponseEntity.ok().body(pedido);
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<Page<Pedido>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerpage,
            @RequestParam(value = "orderBy", defaultValue = "instante") String orderBy,
            @RequestParam(value = "direction", defaultValue = "DESC") String direction,
            @RequestBody Integer id
    ) {
        Page<Pedido> list = pedidoService.findPage(page, linesPerpage, orderBy, direction, id);
        return ResponseEntity.ok().body(list);
    }

}
