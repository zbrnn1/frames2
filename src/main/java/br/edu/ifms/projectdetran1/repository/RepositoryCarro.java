package br.edu.ifms.projectdetran1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.projectdetran1.model.Carro;
@Repository
public interface RepositoryCarro extends JpaRepository<Carro, Long> {
	//public Carro findByPlacaContaing(String str);
}
