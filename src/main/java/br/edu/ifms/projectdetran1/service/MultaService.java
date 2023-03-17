package br.edu.ifms.projectdetran1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.edu.ifms.projectdetran1.dto.MultaDto;

import br.edu.ifms.projectdetran1.model.Multa;
import br.edu.ifms.projectdetran1.repository.RepositoryMulta;

@Service
public class MultaService {
	@Autowired
	private RepositoryMulta repositoryMulta;
	
	
	public List<Multa> buscarTodos(){
		return repositoryMulta.findAll();
	}
	
	public Multa buscarPorId(Long id){
		Optional<Multa> multa = repositoryMulta.findById(id);
		return multa.orElseThrow();
	}
	
	//inserir
	public Multa inserir (Multa multa) {
		multa.setId(null);
		return repositoryMulta.save(multa);
	}
	
	//remover
	public void remover (Long id) {
		buscarPorId(id);
		repositoryMulta.deleteById(id);
	}
	
	
	//atualizar
	
	public Multa atualizar(Multa multa) {
		Multa multaNova = buscarPorId(multa.getId());
		
		multaNova.setCidade(multa.getCidade());
		multaNova.setAno(multa.getAno());
		
		
		return repositoryMulta.save(multaNova);
	}
	
	public Multa fromDto(MultaDto multaDto) {
		return new Multa(multaDto.getId(),multaDto.getCidade(),multaDto.getAno(),null,null);
		
	}

}
