package pedro.com.github.ApiVendasJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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



}
