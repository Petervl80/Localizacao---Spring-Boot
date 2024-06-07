package io.gitgub.petervl80.localizacao.service;

import io.gitgub.petervl80.localizacao.domain.entity.Cidade;
import io.gitgub.petervl80.localizacao.domain.repository.CidadeRepository;
import static io.gitgub.petervl80.localizacao.domain.repository.specs.CidadeSpecs.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class CidadeService {

    private final CidadeRepository repository;

    public CidadeService(CidadeRepository repository) {
        this.repository = repository;
    }

    public void listarCidadesPorNome() {
        Pageable pageable = PageRequest.of(0, 2);
        repository
                .findByNomeLike("porto%", pageable).forEach(System.out::println);
    }

    public void listarCidadesPorNomeNomeSQL() {
        repository.findByNomeSqlNativo("Recife")
                .stream().map(cidadeProjections -> new Cidade(cidadeProjections.getId(), cidadeProjections.getNome(), null))
                .forEach(System.out::println);
    }

    public void listarCidadesPorHabitantes() {
        repository.findByHabitantes(1000000L).forEach(System.out::println);
    }

    @Transactional
    public void salvarCidade() {
        var cidade = new Cidade(1L, "Recife", 12396372L);
        repository.save(cidade);
    }

    public void listarCidades() {
        repository.findAll().forEach(System.out::println);
    }

    public List<Cidade> filtroDinamico(Cidade cidade) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING);
        Example<Cidade> example = Example.of(cidade, matcher);
        return repository.findAll(example);
    }

    public void listarCidadesByNomeSpecs() {
        Specification<Cidade> spec = nomeEqual("Recife").and(habitantesGreaterThan(1000L));
        repository.findAll(spec).forEach(System.out::println);
    }

    public void listarCidadesSpecsFiltroDinamico(Cidade filtro) {
        Specification<Cidade> specs = Specification.where((root, query, cb) -> cb.conjunction());

        if(filtro.getId() != null) {
            specs = specs.and((idEqual(filtro.getId())));
        }

        if(StringUtils.hasText(filtro.getNome())) {
            specs = specs.and(nomeLike(filtro.getNome()));
        }

        if(filtro.getHabitantes() != null) {
            specs = specs.and((habitantesGreaterThan(filtro.getHabitantes())));
        }

        repository.findAll(specs).forEach(System.out::println);
    }
}
