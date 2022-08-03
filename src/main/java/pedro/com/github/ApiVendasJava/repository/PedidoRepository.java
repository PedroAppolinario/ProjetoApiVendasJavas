package pedro.com.github.ApiVendasJava.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pedro.com.github.ApiVendasJava.domain.entity.Cliente;
import pedro.com.github.ApiVendasJava.domain.entity.Pedido;

import javax.transaction.Transactional;
import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido,Integer> {


    @Transactional
    Page<Pedido> findByCliente(Optional<Cliente> byId, Pageable pageRequest);
}
