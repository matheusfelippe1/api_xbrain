package teste.xbrain.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("vendas")
public class VendasController {

    @PostMapping
    public void cadastrar(@RequestBody String json){
        System.out.println(json);
    }
}