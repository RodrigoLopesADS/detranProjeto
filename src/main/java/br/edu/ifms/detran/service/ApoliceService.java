package br.edu.ifms.detran.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.detran.dto.ApoliceDto;
import br.edu.ifms.detran.model.Apolice;
import br.edu.ifms.detran.repository.RepositoryApolice;

@Service
public class ApoliceService {
	
	@Autowired
	private RepositoryApolice repositoryApolice;
	

	public List<Apolice> buscarTodos(){
		return repositoryApolice.findAll();
		
	}
	
	public Apolice buscarId(Integer id) {
		Optional<Apolice> apolice = repositoryApolice.findById(id);
		return apolice.orElseThrow();
		
	}
	
	public Apolice inserir(Apolice apolice) {
		apolice.setId(null);
		return repositoryApolice.save(null);
		
	}
	
	public void remover(Integer id) {
		buscarId(id);
		repositoryApolice.deleteById(id);
		
	}
	
	
	
	
	public Apolice atualizar(Apolice apolice) {
		Apolice apoliceNova = buscarId(apolice.getId());
		
		apoliceNova.setValor(apolice.getValor());
		apoliceNova.setCobertura(apolice.getCobertura());
		apoliceNova.setVigencia(apolice.getVigencia());
		
		return repositoryApolice.save(apoliceNova);
		
	}

	public Apolice fromDto(ApoliceDto apoliceDto) {
		return new Apolice(apoliceDto.getId(), apoliceDto.getValor(), apoliceDto.getCobertura(), apoliceDto.getVigencia(), null);
		
				
				
		
		
	}
	
	
	

}
