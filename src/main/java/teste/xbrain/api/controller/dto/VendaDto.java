package teste.xbrain.api.controller.dto;

import lombok.Getter;
import teste.xbrain.api.model.Venda;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Getter
public class VendaDto {

    private Long id;
    private LocalDateTime dataVenda;
    private Double valor;
    private Long idVendedor;
    private String nomeVendedor;

    public VendaDto(Venda venda) {
        this.id = venda.getId();
        this.dataVenda = venda.getDataVenda();
        this.valor = venda.getValor();
        this.idVendedor = venda.getVendedor().getId();
        this.nomeVendedor = venda.getVendedor().getNome();

    }
    public static List<VendaDto> converter(List<Venda> vendas) {
        return vendas.stream().map(VendaDto::new).collect(Collectors.toList());
    }

}