package br.edu.ifms.projectdetran1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.projectdetran1.model.Infracao;
@Repository
public interface RepositoryInfracao extends JpaRepository<Infracao, Long>{

}
