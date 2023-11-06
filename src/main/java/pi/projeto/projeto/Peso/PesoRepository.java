package pi.projeto.projeto.Peso;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PesoRepository extends JpaRepository<Peso, Long> {

    List<Peso> getPesoByUsuarioId(Long usuarioId);
}
