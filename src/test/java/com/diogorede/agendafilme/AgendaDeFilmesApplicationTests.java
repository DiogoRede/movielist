package com.diogorede.agendafilme;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.diogorede.agendafilme.models.Filme;
import com.diogorede.agendafilme.repositories.FilmeRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class AgendaDeFilmesApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Autowired
	private FilmeRepository filmeRepository;

	@Test
	void testFilmeSaveSucess() {
		Filme filme = new Filme("Nome 1", "indicacao 1", 5, "descricao 1", false);
		webTestClient
					.post()
					.uri("/filmes")
					.bodyValue(filme)
					.exchange()
					.expectStatus().isCreated()
					.expectBody()
					.jsonPath("$").isArray()
					.jsonPath("$.length()").isEqualTo(1)
					.jsonPath("$[0].nome").isEqualTo(filme.getNome())
					.jsonPath("$[0].indicacao").isEqualTo(filme.getIndicacao())
					.jsonPath("$[0].prioridade").isEqualTo(filme.getPrioridade())
					.jsonPath("$[0].descricao").isEqualTo(filme.getDescricao());
	}

	@Test
	void testFilmeSaveFailure() {
		Filme filme = new Filme("", "indicacao 1", 5, "descricao 1", false);
		webTestClient
					.post()
					.uri("/filmes")
					.bodyValue(filme)
					.exchange()
					.expectStatus().isBadRequest();
	}

	@Test
	void testFilmeDeleteSucess(){
		/* TODO: ARRUMAR ESSE TESTE */
		Filme filme = new Filme("Nome 1", "indicacao 1", 5, "descricao 1", false);

		Filme savedFilme = filmeRepository.save(filme);
		System.out.println(savedFilme.getId());

		webTestClient
			.delete()
			.uri("/filmes/", savedFilme.getId())
			.exchange()
			.expectStatus().isOk();
	}

	/* TODO: FAZER O TESTE PARA O CRUD INTEIRO, faltando (RUD) */
}