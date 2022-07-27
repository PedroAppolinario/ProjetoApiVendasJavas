package pedro.com.github.ApiVendasJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pedro.com.github.ApiVendasJava.domain.entity.Produto;
import pedro.com.github.ApiVendasJava.repository.ProdutoRepository;
import pedro.com.github.ApiVendasJava.service.ProdutoService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoService produtoService;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> inserirProduto(@RequestBody @Valid Produto produto){
        produtoService.inserirProduto(produto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateProduto(@PathVariable Integer id, @Valid @RequestBody Produto produto){
        produto.setId(id);
        produtoService.updateProduto(produto);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Produto> findProduto(@PathVariable Integer id){
        Produto produto = produtoService.find(id);
        return ResponseEntity.ok().body(produto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletProduto(@PathVariable Integer id){
        produtoService.deleteProduto(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Produto>> findAll(){
        List<Produto> list = produtoService.findAll();
        return ResponseEntity.ok().body(list);
    }

}
