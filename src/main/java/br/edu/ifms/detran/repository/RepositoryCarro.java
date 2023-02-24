package br.edu.ifms.detran.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.detran.model.Carro;


@Repository
public interface RepositoryCarro extends JpaRepository<Carro, Long> {
	

}
