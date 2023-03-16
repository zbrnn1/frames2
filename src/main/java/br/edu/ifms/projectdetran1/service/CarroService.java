package br.edu.ifms.projectdetran1.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.projectdetran1.dto.CarroDto;
import br.edu.ifms.projectdetran1.model.Carro;
import br.edu.ifms.projectdetran1.repository.RepositoryCarro;

@Service
public class CarroService {
	@Autowired
	private RepositoryCarro repositoryCarro;
	
	
	
	public List<Carro> buscarTodos(){
		return repositoryCarro.findAll();
	}
	//buscarPorId
	public Carro buscarPorId(Long id) {
		Optional<Carro> carro = repositoryCarro.findById(id);
		return carro.orElseThrow();
	}
	
	//inserir
	public Carro inserir (Carro carro) {
		carro.setId(null);
		return repositoryCarro.save(carro);
	}
	
	//remover
	public void remover (Long id) {
		buscarPorId(id);
		repositoryCarro.deleteById(id);
	}
	
	
	//atualizar
	
	public Carro atualizar(Carro carro) {
		Carro carroNovo = buscarPorId(carro.getId());
		
		carroNovo.setNome(carro.getNome());
		carroNovo.setPlaca(carro.getPlaca());
		carroNovo.setMarca(carro.getMarca());
		carroNovo.setModelo(carro.getModelo());
		carroNovo.setCor(carro.getCor());
		return repositoryCarro.save(carroNovo);
	}
	
	public Carro fromDto(CarroDto carroDto) {
		return new Carro(carroDto.getId(),carroDto.getNome(),carroDto.getPlaca(),carroDto.getMarca(),carroDto.getModelo(),carroDto.getCor(),null);
		
	}

}
