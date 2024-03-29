package br.com.alura.adopet.api.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.alura.adopet.api.dto.CadastroAbrigoDto;
import br.com.alura.adopet.api.dto.CadastroPetDto;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.model.ProbabilidadeAdocao;
import br.com.alura.adopet.api.model.TipoPet;

class CalculadoraProbabilidadeAdocaoTest {

	@Test
	void deveriaRetornarProbabilidadeAltaParaPetComPesoBaixoEIdadeBaixa() {
	//idade 4 anos e 4kg = ALTA
	
	//ARRANGE
	Abrigo abrigo = new Abrigo(new CadastroAbrigoDto("Abrigo feliz", "94999999999", "abrigofeliz@gmail.com")); 
	
	Pet pet = new Pet(new CadastroPetDto(TipoPet.GATO, "miau", "Siames", 4, "Cinza", 4.0f), abrigo);
	CalculadoraProbabilidadeAdocao calculadora = new CalculadoraProbabilidadeAdocao();	
	
	//ACT
	ProbabilidadeAdocao probabilidade = calculadora.calcular(pet);
	
	//ASSERT
	Assertions.assertEquals(ProbabilidadeAdocao.ALTA, probabilidade);
	
	}
	
	@Test
	void deveriaRetornarProbabilidadeMediaParaPetComPesoBaixoEIdadeAlta() {
	//idade 15 anos e 4kg = MEDIA
	
	//ARRANGE
	Abrigo abrigo = new Abrigo(new CadastroAbrigoDto("Abrigo feliz", "94999999999", "abrigofeliz@gmail.com")); 
	
	Pet pet = new Pet(new CadastroPetDto(TipoPet.GATO, "miau", "Siames", 15, "Cinza", 4.0f), abrigo);
	CalculadoraProbabilidadeAdocao calculadora = new CalculadoraProbabilidadeAdocao();	
	
	//ACT
	ProbabilidadeAdocao probabilidade = calculadora.calcular(pet);
	
	//ASSERT
	Assertions.assertEquals(ProbabilidadeAdocao.MEDIA, probabilidade);
	
	}
	
}
