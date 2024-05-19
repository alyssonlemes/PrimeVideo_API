package unifacef.edu.primevideo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unifacef.edu.primevideo.model.dto.FilmeDTO;
import unifacef.edu.primevideo.model.entity.FilmeEntity;
import unifacef.edu.primevideo.model.repository.FilmeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//classe serviço para operações de CRUD
@Service
public class FilmeService {
    //injeção de dependencias
    @Autowired
    FilmeRepository injecao;
    public FilmeDTO insere(FilmeDTO filmeDTO){
        //convertemos filme DTO em filmeEntity para enviar para o banco de dados
        //o metodo esta sendo chamado sem necessidade de instanciar o objeto
        //convertemos filmeEntity em filmeDTO para enviar ao front end
        FilmeEntity resposta = injecao.save(converteDTO(filmeDTO));
        return converteEntity(resposta);
    }

    //converte lista de filme entity em uma lista de FilmeDTO

    public List<FilmeDTO> converteEntities(List<FilmeEntity> filmesEntities){
        //criar uma lista de FilmeDTO
        List<FilmeDTO> filmeDTOS = new ArrayList<FilmeDTO>();

        //percorre filme entities e converte cada filme Entity, adicionando-os no vetor de filmeDTOS
        for(FilmeEntity filmeEntity: filmesEntities){
            filmeDTOS.add(converteEntity(filmeEntity));
        }
        return filmeDTOS;
    }

    //retorna lista de filmes
    public List<FilmeDTO> consultaTodos(){
        return converteEntities(injecao.findAll());
    }

    //consukta um filme especifico por id
    public FilmeDTO consultaPorId(Long id){
        //retorna um valor opcional pois pode encontrar ou não o ID
        Optional<FilmeEntity> optional = injecao.findById(id);
        if (optional.isPresent()){
            return converteEntity(optional.get());
        }
        else return null;
    }

    //remove de filme por id

    public String remove(Long id){
        if (injecao.existsById(id)){
            injecao.deleteById(id);
            return "Remoção realizada com sucesso";
        }
        else {
            return "Filme não encontrado";
        }
    }



    //converte filmeDTO em filmeEntity para enviar os dados para o banco
    public FilmeEntity converteDTO(FilmeDTO filmeDTO){
        return new FilmeEntity(filmeDTO.getId(), filmeDTO.getNome(), filmeDTO.getAnoLancamento(), filmeDTO.getNota());
    }

    //converte filmeEntity em filmeDTO para enviar os dados para o front end
    public FilmeDTO converteEntity(FilmeEntity filmeEntity){
        return new FilmeDTO(filmeEntity.getId(), filmeEntity.getNome(), filmeEntity.getAnoLancamento(),filmeEntity.getNota());
    }
}
