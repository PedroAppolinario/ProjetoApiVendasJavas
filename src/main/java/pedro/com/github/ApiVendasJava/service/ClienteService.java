package pedro.com.github.ApiVendasJava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pedro.com.github.ApiVendasJava.domain.entity.Client;
import pedro.com.github.ApiVendasJava.repository.ClienteRepository;

import javax.transaction.Transactional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional //Desfaz a determinada ação desde o inicio
    public Client inserirCliente(Client cliente){
        cliente.setId(null);
        return clienteRepository.save(cliente);

    }
}
