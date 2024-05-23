package teste.xbrain.api.controller.form;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import teste.xbrain.api.model.Vendedor;
import teste.xbrain.api.repository.VendedorRepository;

@Setter
@Getter
public class AtualizaVendedorForm {

    @NotEmpty @Length(min = 5)
    private String nome;

    public Vendedor atualizar(Long id, VendedorRepository repository) {
        Vendedor vendedor = repository.getReferenceById(id);

        vendedor.setNome(this.nome);

        return vendedor;
    }

}