package pedro.com.github.ApiVendasJava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pedro.com.github.ApiVendasJava.domain.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {

}
