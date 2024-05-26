package teste.xbrain.api.controller.form;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import teste.xbrain.api.model.Venda;
import teste.xbrain.api.model.Vendedor;
import teste.xbrain.api.repository.VendedorRepository;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendaForm {

    @NotNull
    private double valor;
    @NotNull
    private Long idVendedor;

    public Venda converter(VendedorRepository vendedorRepository) {
        Optional<Vendedor> vendedorOptional = vendedorRepository.findById(idVendedor);
        Vendedor vendedor = vendedorOptional.get();
        return new Venda(valor, vendedor);
    }
}