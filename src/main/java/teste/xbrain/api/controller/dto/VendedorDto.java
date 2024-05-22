package teste.xbrain.api.controller.dto;

import lombok.Getter;
import teste.xbrain.api.model.Vendedor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class VendedorDto {

    private Long id;
    private String nome;

    public VendedorDto(Vendedor vendedor){
        this.id = vendedor.getId();
        this.nome = vendedor.getNome();
    }

    public static List<VendedorDto> converter(List<Vendedor> vendedores) {
        return vendedores.stream().map(VendedorDto::new).collect(Collectors.toList());
    }

}