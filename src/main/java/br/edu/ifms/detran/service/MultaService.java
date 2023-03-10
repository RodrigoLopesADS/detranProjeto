package br.edu.ifms.detran.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.detran.dto.MultaDto;
import br.edu.ifms.detran.model.Multa;
import br.edu.ifms.detran.repository.RepositoryMulta;

@Service
public class MultaService {

	@Autowired
	private RepositoryMulta repositoryMulta;
	

	public List<Multa> buscarTodos(){
		return repositoryMulta.findAll();
		
	}
	
	public Multa buscarId(Long id) {
		Optional<Multa> multa = repositoryMulta.findById(id);
		return multa.orElseThrow();
		
	}
	
	public Multa inserir(Multa multa) {
		multa.setId(null);
		return repositoryMulta.save(null);
		
	}
	
	public void remover(Long id) {
		buscarId(id);
		repositoryMulta.deleteById(id);
		
	}
	
	public Multa atualizar(Multa multa) {
		Multa multaNova = buscarId(multa.getId());
		
		multaNova.setCidade(multa.getCidade());
		multaNova.setAno(multa.getAno());
		
		return repositoryMulta.save(multaNova);
		
	}

	public Multa fromDto(MultaDto multaDto) {
		return new Multa(multaDto.getId(), multaDto.getCidade(), multaDto.getAno(), null, null);
		
	}
	
	
	
	
}
