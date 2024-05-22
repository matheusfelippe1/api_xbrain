package teste.xbrain.api.controller.form;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import teste.xbrain.api.model.Venda;
import teste.xbrain.api.model.Vendedor;
import teste.xbrain.api.repository.VendaRepository;
import teste.xbrain.api.repository.VendedorRepository;

@Setter
@Getter
public class AtualizaVendaForm {

    @NotNull
    private double valor;
    @NotNull
    private Long idVendedor;

    public Venda atualizar(Long id, VendaRepository repository, VendedorRepository vendedorRepository) {
        Venda venda = repository.getReferenceById(id);
        Vendedor vendedor = vendedorRepository.getReferenceById(this.idVendedor);

        venda.setValor(this.valor);
        venda.setVendedor(vendedor);

        return venda;
    }

}