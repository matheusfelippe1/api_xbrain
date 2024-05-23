package repository;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import teste.xbrain.api.model.Vendedor;
import teste.xbrain.api.repository.VendedorRepository;

import java.util.List;

@RunWith(SpringRunner.class)

@DataJpaTest
public class VendedorRepositoryTest {

    @Autowired
    private VendedorRepository repository;

    @Test
    public void deveriaCarerregarUmVendedorAoBuscarPeloSeuNome() {
        String nomeVendedor = "thiago";
        List<Vendedor> vendedor =	repository.findByNome(nomeVendedor);
        Assert.assertNotNull(List.of(vendedor));
        Assert.assertEquals(nomeVendedor, vendedor.get(0).getNome());
    }

    @Test
    public void naoDeveriaCarerregarUmVendedorSemEstarCadastrado() {
        String nomeVendedor = "andre";
        List<Vendedor> vendedor =	repository.findByNome(nomeVendedor);
        Assert.assertNotEquals(nomeVendedor, vendedor);
    }

}