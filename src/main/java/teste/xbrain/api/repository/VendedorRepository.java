package teste.xbrain.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import teste.xbrain.api.model.Vendedor;

import java.util.List;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

    List<Vendedor> findByNome(String nomeVendedor);

}