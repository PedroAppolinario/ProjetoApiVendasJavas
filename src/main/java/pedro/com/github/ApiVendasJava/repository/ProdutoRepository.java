package pedro.com.github.ApiVendasJava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pedro.com.github.ApiVendasJava.domain.entity.Produto;


public interface ProdutoRepository extends JpaRepository<Produto,Integer> {

}
