package unifacef.edu.primevideo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unifacef.edu.primevideo.model.entity.FilmeEntity;

public interface FilmeRepository extends JpaRepository<FilmeEntity, Long> {
        //interface herdando todos os metodos de crud relacionado a FilmeEntity
}
