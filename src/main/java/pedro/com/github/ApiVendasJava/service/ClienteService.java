package pedro.com.github.ApiVendasJava.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import pedro.com.github.ApiVendasJava.domain.dto.ClienteDto;
import pedro.com.github.ApiVendasJava.domain.entity.Cliente;
import pedro.com.github.ApiVendasJava.exception.ObjectNotFoundException;
import pedro.com.github.ApiVendasJava.repository.ClienteRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional //Desfaz a determinada ação desde o inicio
    public Cliente inserirCliente(Cliente cliente){
        cliente.setId(null);
        return clienteRepository.save(cliente);

    }

    public Cliente updateCliente(Cliente cliente){
        Cliente clienteToUpdate = find(cliente.getId());
        updateData(clienteToUpdate, cliente);
        return clienteRepository.save(clienteToUpdate);

    }

    public void updateData(Cliente clienteToUpdate, Cliente cliente) {
        clienteToUpdate.setNome(cliente.getNome());
        clienteToUpdate.setNome(cliente.getEmail());
        clienteToUpdate.setNome(cliente.getTelefone());
    }

    public Cliente find(Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElseThrow(() -> new ObjectNotFoundException("CLinte não foi encontrado" + id + ", tipo: "
                + Cliente.class.getName()));
    }

    public Cliente fromDto(ClienteDto clienteDto) {
        return new Cliente(clienteDto.getId(), clienteDto.getNome(), clienteDto.getEmail(), clienteDto.getTelefone(),
                null, null);
    }

    public void deleteCliente(Integer id) {
        find(id);
        try{
            clienteRepository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Não é possível exluir um cliente com dados vinculados");
        }

    }
    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

}
