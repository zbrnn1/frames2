package br.edu.ifms.projectdetran1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.edu.ifms.projectdetran1.dto.InfracaoDto;

import br.edu.ifms.projectdetran1.model.Infracao;
import br.edu.ifms.projectdetran1.repository.RepositoryInfracao;

@Service
public class InfracaoService {
	@Autowired
	private RepositoryInfracao repositoryInfracao;
	
	
	public List<Infracao> buscarTodos(){
		return repositoryInfracao.findAll();
	}
	
	public Infracao buscarPorId(Long id){
		Optional<Infracao> infracao = repositoryInfracao.findById(id);
		return infracao.orElseThrow();
	}
	
	//inserir
	public Infracao inserir (Infracao infracao) {
		infracao.setId(null);
		return repositoryInfracao.save(infracao);
	}
	
	//remover
	public void remover (Long id) {
		buscarPorId(id);
		repositoryInfracao.deleteById(id);
	}
	
	
	//atualizar
	
	public Infracao atualizar(Infracao infracao) {
		Infracao infracaoNova = buscarPorId(infracao.getId());
		
		infracaoNova.setDescricao(infracao.getDescricao());
		infracaoNova.setPontos(infracao.getPontos());
		infracaoNova.setValor(infracao.getValor());
		
		return repositoryInfracao.save(infracaoNova);
	}
	
	public Infracao fromDto(InfracaoDto infracaoDto) {
		return new Infracao(infracaoDto.getId(),infracaoDto.getDescricao(),infracaoDto.getPontos(),infracaoDto.getValor());
		
	}

}
