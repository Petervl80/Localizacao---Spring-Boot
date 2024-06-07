package io.gitgub.petervl80.localizacao;

import io.gitgub.petervl80.localizacao.domain.entity.Cidade;
import io.gitgub.petervl80.localizacao.domain.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Override
	public void run(String... args) throws Exception {
		listarCidades();
	}

	@Transactional
	void salvarCidade() {
		var cidade = new Cidade(1L, "Recife", 12396372L);
		cidadeRepository.save(cidade);
	}

	void listarCidades() {
		cidadeRepository.findAll().forEach(System.out::println);
	}


	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}

}