package br.edu.ifms.detran.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.detran.model.Apolice;
import br.edu.ifms.detran.model.Carro;
import br.edu.ifms.detran.model.Infracao;
import br.edu.ifms.detran.repository.RepositoryApolice;
import br.edu.ifms.detran.repository.RepositoryCarro;
import br.edu.ifms.detran.repository.RepositoryInfracao;

@Service
public class DBService {

	@Autowired
	RepositoryCarro repositoryCarro;
	
	@Autowired
	RepositoryApolice repositoryApolice;
	
	@Autowired
	RepositoryInfracao repositoryInfracao;
	

	
	
	
	
	public void instantiateTestDataBase() throws ParseException{
		
		Carro cKenely = new Carro(null, "Onix", "Chevrolet", 2014, "OOL 4010", "Verde", null);
		Carro cRodrigo = new Carro(null, "KA+", "Ford", 2019, "QAL 1146", "Branco", null);
		Carro cThais = new Carro(null, "Gol", "VolksWagem", 2014, "OOL 5032", "Vermelho", null);
		
		
		Apolice apo1 = new Apolice(null, 3000, "TOTAL", "12/2030", cThais);
		
		Infracao infra = new Infracao(null, "Avançar Sinal Vermelho", 9, 1300);
		
		repositoryApolice.saveAll(Arrays.asList(apo1));
		repositoryCarro.saveAll(Arrays.asList(cKenely, cRodrigo, cThais));
		//repositoryInfracao.saveAll(Arrays.asList(cRodrigo));
		
		
		
	}
	
	
}
