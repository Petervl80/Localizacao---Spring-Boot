package io.gitgub.petervl80.localizacao;

import io.gitgub.petervl80.localizacao.domain.entity.Cidade;
import io.gitgub.petervl80.localizacao.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

	@Autowired
	private CidadeService service;

	@Override
	public void run(String... args) throws Exception {
		service.listarCidadesPorNomeNomeSQL();
	}

	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}

}
