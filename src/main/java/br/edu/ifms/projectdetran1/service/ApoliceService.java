package br.edu.ifms.projectdetran1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.projectdetran1.dto.ApoliceDto;
import br.edu.ifms.projectdetran1.model.Apolice;
import br.edu.ifms.projectdetran1.repository.RepositoryApolice;

@Service
public class ApoliceService {
	
	@Autowired
	private RepositoryApolice repositoryApolice;
	
	
	
	public List<Apolice> buscarTodos(){
		return repositoryApolice.findAll();
	}
	//buscarPorId
	public Apolice buscarPorId(Long id) {
		Optional<Apolice> apolice = repositoryApolice.findById(id);
		return apolice.orElseThrow();
	}
	
	//inserir
	public Apolice inserir (Apolice apolice) {
		apolice.setId(null);
		return repositoryApolice.save(apolice);
	}
	
	//remover
	public void remover (Long id) {
		buscarPorId(id);
		repositoryApolice.deleteById(id);
	}
	
	
	//atualizar
	
	public Apolice atualizar(Apolice apolice) {
		Apolice apoliceNovo = buscarPorId(apolice.getId());
		
		
		apoliceNovo.setValor(apolice.getValor());
		apoliceNovo.setCobertura(apolice.getCobertura());
		apoliceNovo.setVigencia(apolice.getVigencia());
		apoliceNovo.setCarro(apolice.getCarro());
		return repositoryApolice.save(apoliceNovo);
	}
	
	public Apolice fromDto(ApoliceDto apoliceDto) {
		
		return new Apolice(apoliceDto.getId(),apoliceDto.getValor(),apoliceDto.getCobertura(),apoliceDto.getVigencia(),null);
		
	}
}
