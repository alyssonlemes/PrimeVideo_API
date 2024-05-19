package unifacef.edu.primevideo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unifacef.edu.primevideo.model.dto.FilmeDTO;
import unifacef.edu.primevideo.service.FilmeService;

import java.util.List;

@RestController
@RequestMapping("/filme")
public class FilmeController {
    //injeção de dependÊncia com o FilmeService
    @Autowired
    FilmeService injecao;

    @PostMapping
    public FilmeDTO inserir(@RequestBody FilmeDTO filmeDTO){
        return injecao.insere(filmeDTO);
    }

    @GetMapping
    public List<FilmeDTO> consultaTodos(){
        return injecao.consultaTodos();

    }

    @GetMapping("/{id}")
    public FilmeDTO consultaPorId(@PathVariable Long id){
        return injecao.consultaPorId(id);
    }

    @DeleteMapping("/{id}")
    public String removePorId(@PathVariable Long id){
        return injecao.remove(id);
    }
}
