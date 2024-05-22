package teste.xbrain.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import teste.xbrain.api.controller.dto.VendedorDto;
import teste.xbrain.api.controller.form.VendedorForm;
import teste.xbrain.api.model.Vendedor;
import teste.xbrain.api.repository.VendedorRepository;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {

    @Autowired
    private VendedorRepository vendedorRepository;

    @GetMapping
    public List<VendedorDto> lista(String nomeVendedor){
        if (nomeVendedor == null){
            List<Vendedor> vendedores = vendedorRepository.findAll();
            return VendedorDto.converter(vendedores);
        } else {
            List<Vendedor> vendedores = vendedorRepository.findByNome(nomeVendedor);
            return VendedorDto.converter(vendedores);
        }
    }

    @PostMapping
    public ResponseEntity<VendedorDto> cadastrar(@RequestBody @Valid VendedorForm form, UriComponentsBuilder uriBuilder){
        Vendedor vendedor = form.converter(vendedorRepository);
        vendedorRepository.save(vendedor);

        URI uri = uriBuilder.path("/vendedores/{id}").buildAndExpand(vendedor.getId()).toUri();
        return ResponseEntity.created(uri).body(new VendedorDto(vendedor));
    }

    @GetMapping("/{id}")
    public VendedorDto detalhar(@PathVariable Long id){
        Vendedor vendedor = vendedorRepository.getReferenceById(id);
        return new VendedorDto(vendedor);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        Vendedor vendedor = vendedorRepository.getReferenceById(id);
        vendedorRepository.delete(vendedor);
    }

    @PutMapping("/{id}")
    @Transactional
    public VendedorDto alterar(@PathVariable Long id, @RequestBody @Valid VendedorForm form){
        Vendedor vendedor = vendedorRepository.getReferenceById(id);
        vendedor.setNome(form.getNome());
        vendedorRepository.save(vendedor);
        return new VendedorDto(vendedor);
    }

}