package br.com.alura.adopet.api.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class AdocaoControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@Test
	void deveriaDevolverCodigo400ParaSolicitacaoDeAdocaoComErros() throws Exception {
		//ARRENGE
		String json = "{}";
		
		//ACT
		var response = mvc.perform(
				post("/adocoes")
				.content(json)
				.contentType(MediaType.APPLICATION_JSON)
		).andReturn().getResponse();
		
		//ASSERT
		Assertions.assertEquals(400, response.getStatus());
	}

}