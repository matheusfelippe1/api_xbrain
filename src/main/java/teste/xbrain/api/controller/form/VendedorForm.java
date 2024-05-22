package teste.xbrain.api.controller.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import teste.xbrain.api.model.Vendedor;
import teste.xbrain.api.repository.VendedorRepository;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendedorForm {

    @NotNull @NotEmpty @Length(min = 5)
    private String nome;

    public Vendedor converter(VendedorRepository vendedorRepository) {
        List<Vendedor> vendedor = vendedorRepository.findByNome(nome);
        return new Vendedor(nome);
    }
}