package teste.xbrain.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import teste.xbrain.api.controller.dto.VendaDto;
import teste.xbrain.api.controller.form.VendaForm;
import teste.xbrain.api.model.Venda;
import teste.xbrain.api.repository.VendaRepository;
import teste.xbrain.api.repository.VendedorRepository;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendasController {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private VendedorRepository vendedorRepository;

    @GetMapping
    public List<VendaDto> lista(Long id){
        if (id == null){
            List<Venda> vendas = vendaRepository.findAll();
            return VendaDto.converter(vendas);
        } else {
            List<Venda> vendas = vendaRepository.findByVendedorId(id);
            return VendaDto.converter(vendas);
        }
    }

    @PostMapping
    public ResponseEntity<VendaDto> cadastrar(@RequestBody @Valid VendaForm form, UriComponentsBuilder uriBuilder){
        Venda venda = form.converter(vendedorRepository);
        vendaRepository.save(venda);

        URI uri = uriBuilder.path("/vendas/{id}").buildAndExpand(venda.getId()).toUri();
        return ResponseEntity.created(uri).body(new VendaDto(venda));
    }

    @GetMapping("/{id}")
    public VendaDto detalhar(@PathVariable Long id){
        Venda venda = vendaRepository.getReferenceById(id);
        return new VendaDto(venda);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        Venda venda = vendaRepository.getReferenceById(id);
        vendaRepository.delete(venda);
    }

    @PutMapping("/{id}")
    @Transactional
    public VendaDto alterar(@PathVariable Long id, @RequestBody @Valid VendaForm form){
        Venda venda = vendaRepository.getReferenceById(id);
        venda.setId(form.getIdVendedor());
        venda.setValor(form.getValor());
        vendaRepository.save(venda);
        return new VendaDto(venda);
    }

}