package br.edu.ifms.projectdetran1.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.projectdetran1.model.Apolice;
import br.edu.ifms.projectdetran1.model.Carro;
import br.edu.ifms.projectdetran1.model.Infracao;
import br.edu.ifms.projectdetran1.model.Multa;
import br.edu.ifms.projectdetran1.repository.RepositoryApolice;
import br.edu.ifms.projectdetran1.repository.RepositoryCarro;
import br.edu.ifms.projectdetran1.repository.RepositoryInfracao;
import br.edu.ifms.projectdetran1.repository.RepositoryMulta;

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
	public void instantiateTestDatabase() throws ParseException{
		// TODO Auto-generated method stub
		
		Carro cKenely = new Carro(null, "Onix", "OOL 4110", "Chevrolet", 2014, "Preto", null);
		Carro cRodrigo = new Carro(null,"KA","KAL 1146","Ford",2019,"Branco",null);
		Carro cThais = new Carro(null,"Gol","HUJ 0029","Volkswagen",2010,"Vermelho",null);
		Carro cFabiola = new Carro(null,"Cruse","HUJ 0029","Chevrolet",2022,"Branco",null);
		
		Apolice apo1 = new Apolice (null, 3000,"Total","12/2030",cThais);
		
		Infracao infra1 = new Infracao(null,"Avançou sinal",5,250);
		Infracao infra2 = new Infracao(null,"Estacionamento proibido",7,150);
		Infracao infra3 = new Infracao(null,"Cinco de segurança",5,100);
		Infracao infra4 = new Infracao(null,"Velocidade acima da permitida",10,299);
		Infracao infra5 = new Infracao(null,"ULtrapassagem em faixa continua",10,299);
		
		Multa m1 = new Multa(null, "Corumba", 2020, cKenely, infra3);
		Multa m2 = new Multa(null, "Ladario", 2023, cKenely, infra2);
		Multa m3 = new Multa(null, "Corumba", 2021, cRodrigo, infra4);
		Multa m4 =new Multa(null, "Miranda", 2023, cRodrigo, infra1);	
		Multa m5 = new Multa(null, "Campo Grande", 2023, cFabiola, infra5);
		
		
		repositoryApolice.saveAll(Arrays.asList(apo1));
		repositoryCarro.saveAll(Arrays.asList(cKenely,cRodrigo,cThais,cFabiola));
		repositoryInfracao.saveAll(Arrays.asList(infra1,infra2,infra3,infra4,infra5));
		repositoryMulta.saveAll(Arrays.asList(m1,m2,m3,m4,m5));
		
		
		
		
	}

}