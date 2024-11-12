package br.com.cotiinformatica;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import br.com.cotiinformatica.dtos.ProdutoRequestDto;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class JavaApiProdutosApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	
	
	
	
	
	@Test
	@Order(1)
	void cadastrarProdutoTest() throws Exception {

		//instanciando a biblioteca java-faker
		
		var faker = new Faker(new Locale("pt-BR"));
		
		
		
		// preenchendo os dados do dto para cadastrar o produto
		var dto = new ProdutoRequestDto();
		dto.setNome(faker.commerce().productName());
		dto.setPreco((double)faker.number().numberBetween(1, 1000));
		dto.setQuantidade(faker.number().numberBetween(1, 10));

		// fazendo a requisição para o serviço da API
		var result = mockMvc.perform(post("/api/produtos") // endpoint
				.contentType("application/json") // formato dos dados
				.content(objectMapper.writeValueAsString(dto))) // dados enviados
				.andExpect(status().isOk()) // esperando resposta de sucesso
				.andReturn(); // capturando a resposta

		// capturando a mensagem devolvida pela API após a realização do cadastro
		var content = result.getResponse().getContentAsString(StandardCharsets.UTF_8);
		// verificando se o conteudo da resposta está correto
		assertTrue(content.contains("Produto cadastrado com sucesso"));
	}

	@Test
	@Order(2)
	void atualizarProdutoTest() throws Exception {
		fail("Não implementado.");
	}

	@Test
	@Order(3)
	void excluirProdutoTest() throws Exception {
		fail("Não implementado.");
	}

	@Test
	@Order(4)
	void consultarProdutosTest() throws Exception {
		fail("Não implementado.");
	}

	@Test
	@Order(5)
	void obterProdutoPorIdTest() throws Exception {
		fail("Não implementado.");
	}
}
