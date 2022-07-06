package pedro.com.github.ApiVendasJava.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import pedro.com.github.ApiVendasJava.domain.entity.Cliente;

import javax.validation.Valid;

public interface ClienteAPI {

    ResponseEntity<Void> inserirCliente(@RequestBody @Valid Cliente cliente);
    //ResponseEntity<Void> atualizarCLiente();
    //ResponseEntity<Void> buscarCLiente();
    //ResponseEntity<Void> deletarCLiente();


    }

