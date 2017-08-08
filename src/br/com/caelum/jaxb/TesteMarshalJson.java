package br.com.caelum.jaxb;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TesteMarshalJson {
	
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		Livro livro = new Livro();
		livro.setCodigo("ARQ");
		livro.setNomeAutor("Arquitetura Java");
		livro.setTitulo("Paulo Silveira");
		livro.setValor(new BigDecimal("29.90"));
		Categoria categoria = new Categoria();
		categoria.setNome("TI");
		livro.setCategoria(categoria);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("livro.json"), livro);
	}

}
