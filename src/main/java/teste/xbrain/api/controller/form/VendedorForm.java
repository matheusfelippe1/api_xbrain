package teste.xbrain.api.controller.form;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import teste.xbrain.api.model.Vendedor;
import teste.xbrain.api.repository.VendedorRepository;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendedorForm {

    @NotBlank
    private String nome;

    public Vendedor converter(VendedorRepository vendedorRepository) {
        List<Vendedor> vendedor = vendedorRepository.findByNome(nome);
        return new Vendedor(nome);
    }
}