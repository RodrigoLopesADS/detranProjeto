package br.edu.ifms.detran.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.detran.model.Apolice;
import br.edu.ifms.detran.model.Carro;
import br.edu.ifms.detran.model.Infracao;
import br.edu.ifms.detran.model.Multa;
import br.edu.ifms.detran.repository.RepositoryApolice;
import br.edu.ifms.detran.repository.RepositoryCarro;
import br.edu.ifms.detran.repository.RepositoryInfracao;
import br.edu.ifms.detran.repository.RepositoryMulta;

@Service
public class DBService {

	@Autowired
	RepositoryCarro repositoryCarro;

	@Autowired
	RepositoryApolice repositoryApolice;

	@Autowired
	RepositoryInfracao repositoryInfracao;

	@Autowired
	RepositoryMulta repositoryMulta;

	public void instantiateTestDataBase() throws ParseException {

		Carro cKenely = new Carro(null, "Onix", "Chevrolet", 2014, "OOL 4010", "Verde", null);
		Carro cRodrigo = new Carro(null, "KA+", "Ford", 2019, "QAL 1146", "Branco", null);
		Carro cThais = new Carro(null, "Gol", "VolksWagem", 2014, "OOL 5032", "Vermelho", null);
		Carro cFabiola = new Carro(null, "Cruze", "Chevrolet", 2022, "OOL 0040", "Preto", null);

		Apolice apo1 = new Apolice(null, 3000, "TOTAL", "12/2030", cThais);

		Infracao infra1 = new Infracao(null, "Avançar Sinal Vermelho", 9, 1300);
		Infracao infra2 = new Infracao(null, "Estacionar em Local Proibido", 7, 900);
		Infracao infra3 = new Infracao(null, "Condutor sem cinto de Segurança", 5, 99);
		Infracao infra4 = new Infracao(null, "Ultrapassar em faixa contínua", 10, 499);
		Infracao infra5 = new Infracao(null, "Velocidade acima da permitida", 5, 199);

		Multa multa1 = new Multa(null, "Corumbá", 2022, cThais, infra3);
		Multa multa2 = new Multa(null, "Miranda", 2023, cThais, infra5);
		Multa multa3 = new Multa(null, "Aquidauana", 2022, cRodrigo, infra1);
		Multa multa4 = new Multa(null, "Corumbá", 2022, cRodrigo, infra2);
		Multa multa5 = new Multa(null, "Terenos", 2022, cKenely, infra1);
		Multa multa6 = new Multa(null, "Corumbá", 2022, cKenely, infra4);
		Multa multa7 = new Multa(null, "Campo Grande", 2022, cFabiola, infra4);
		Multa multa8 = new Multa(null, "Miranda", 2022, cFabiola, infra2);

		repositoryApolice.saveAll(Arrays.asList(apo1));
		repositoryCarro.saveAll(Arrays.asList(cKenely, cRodrigo, cThais, cFabiola));

		repositoryInfracao.saveAll(Arrays.asList(infra1, infra2, infra3, infra4, infra5));
		
	
		
		repositoryMulta.saveAll(Arrays.asList(multa1, multa2, multa3, multa4, multa5, multa6, multa7, multa8));

	}

}
