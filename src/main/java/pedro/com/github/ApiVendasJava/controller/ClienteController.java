package pedro.com.github.ApiVendasJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pedro.com.github.ApiVendasJava.controller.api.ClienteAPI;
import pedro.com.github.ApiVendasJava.domain.dto.ClienteDto;
import pedro.com.github.ApiVendasJava.domain.entity.Cliente;
import pedro.com.github.ApiVendasJava.repository.ClienteRepository;
import pedro.com.github.ApiVendasJava.service.ClienteService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController implements ClienteAPI {

    @Autowired
    private ClienteRepository clientRepository;
    @Autowired
    private ClienteService clienteService;


    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> inserirCliente(@RequestBody @Valid Cliente cliente) {
        clienteService.inserirCliente(cliente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @ResponseStatus
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateClient(@PathVariable Integer id, @Valid @RequestBody ClienteDto clienteDto) {
        Cliente cliente = clienteService.fromDto(clienteDto);
        cliente.setId(id);
        clienteService.updateCliente(cliente);
        return ResponseEntity.noContent().build();

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> findClient(@PathVariable Integer id) {
        Cliente cliente = clienteService.find(id);
        return ResponseEntity.ok().body(cliente);

    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteCliente(@PathVariable Integer id){
        clienteService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }
    @RequestMapping
    public ResponseEntity<List<Cliente>> findAll(){
        List<Cliente> list = clientRepository.findAll();
        return ResponseEntity.ok().body(list);
    }
}
