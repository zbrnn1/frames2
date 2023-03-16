package br.edu.ifms.projectdetran1.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.projectdetran1.model.Apolice;
import br.edu.ifms.projectdetran1.model.Carro;
import br.edu.ifms.projectdetran1.model.Infracao;
import br.edu.ifms.projectdetran1.repository.RepositoryApolice;
import br.edu.ifms.projectdetran1.repository.RepositoryCarro;
import br.edu.ifms.projectdetran1.repository.RepositoryInfracao;

@Service
public class DBService {
	@Autowired
	RepositoryCarro repositoryCarro;
	@Autowired
	RepositoryApolice repositoryApolice;
	@Autowired
	RepositoryInfracao repositoryInfracao;
	public void instantiateTestDatabase() throws ParseException{
		// TODO Auto-generated method stub
		
		Carro cKenely = new Carro(null, "Onix", "OOL 4110", "Chevrolet", 2014, "Preto", null);
		Carro cRodrigo = new Carro(null,"KA","KAL 1146","Ford",2019,"Branco",null);
		Carro cThais = new Carro(null,"Gol","HUJ 0029","Volkswagen",2010,"Vermelho",null);
		
		Apolice apo1 = new Apolice (null, 3000,"Total","12/2030",cThais);
		
		Infracao infra1 = new Infracao(null,"Avançou sinal",5,250);
		
		repositoryApolice.saveAll(Arrays.asList(apo1));
		repositoryCarro.saveAll(Arrays.asList(cKenely,cRodrigo,cThais));
		repositoryInfracao.saveAll(Arrays.asList(infra1));
		
	}

}