package io.gitgub.petervl80.localizacao.domain.repository;

import io.gitgub.petervl80.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    List<Cidade> findByNome(String nome);

    List<Cidade> findByHabitantes(String nome);

}
