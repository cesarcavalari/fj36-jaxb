package br.com.caelum.jaxb;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class TesteValidacao {

	public static void main(String[] args) throws JAXBException, SAXException, IOException {
		Livro livro = new Livro();
		//livro.setCodigo("arq");// o código deve ser maiusculo
		livro.setValor(new BigDecimal("-45.9"));
		
		JAXBContext context = JAXBContext.newInstance(Livro.class);
		JAXBSource source = new JAXBSource(context, livro);
		
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = sf.newSchema(new File("schema.xsd"));
		
		Validator validator = schema.newValidator();
		validator.setErrorHandler(new ValidationHandler());
		validator.validate(source);
//		validator.validate(new StreamSource(new File("livro.xml"))); //valida arquivo xml
	}
}
