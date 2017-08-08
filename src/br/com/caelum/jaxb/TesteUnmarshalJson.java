package br.com.caelum.jaxb;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TesteUnmarshalJson {
	
	public static void main(String[] args) throws JAXBException, JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		Livro livro = mapper.readValue(new File("livro.json"), Livro.class);
		System.out.println(livro.toString());
	}

}
