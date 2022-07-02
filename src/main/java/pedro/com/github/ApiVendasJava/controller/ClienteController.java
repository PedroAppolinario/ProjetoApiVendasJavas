package pedro.com.github.ApiVendasJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pedro.com.github.ApiVendasJava.domain.entity.Client;
import pedro.com.github.ApiVendasJava.repository.ClienteRepository;
import pedro.com.github.ApiVendasJava.service.ClienteService;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clientRepository;

    private ClienteService clienteService;



    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> inserirCliente(@RequestBody @Valid Client cliente){
        clienteService.inserirCliente(cliente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

}
