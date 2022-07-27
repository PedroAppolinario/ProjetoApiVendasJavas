package pedro.com.github.ApiVendasJava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pedro.com.github.ApiVendasJava.domain.entity.Cliente;
import pedro.com.github.ApiVendasJava.domain.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido,Integer> {

}
