package br.edu.ifms.detran.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.detran.dto.CarroDto;
import br.edu.ifms.detran.model.Carro;
import br.edu.ifms.detran.repository.RepositoryCarro;
import br.edu.ifms.detran.service.exception.ObjectNotFoundException;

@Service
public class CarroService {
	
	@Autowired
	private RepositoryCarro repositoryCarro;
	

	public List<Carro> buscarTodos(){
		return repositoryCarro.findAll();
		
	}
	
	public Carro buscarId(Integer id) {
		Optional<Carro> carro = repositoryCarro.findById(id);
		return carro.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Carro.class.getName()));
		
	}
	
	public Carro inserir(Carro carro) {
		carro.setId(null);
		return repositoryCarro.save(carro);
		
	}
	
	public void remover(Integer id) {
		buscarId(id);
		repositoryCarro.deleteById(id);
		
	}
	
	public Carro atualizar(Carro carro) {
		Carro carroNovo = buscarId(carro.getId());
		
		carroNovo.setNome(carro.getNome());
		carroNovo.setPlaca(carro.getPlaca());
		carroNovo.setMarca(carro.getMarca());
		carroNovo.setModelo(carro.getModelo());
		carroNovo.setCor(carro.getCor());
		
		return repositoryCarro.save(carroNovo);
		
	}

	public Carro fromDto(CarroDto carroDto) {
		return new Carro(carroDto.getId(), carroDto.getNome(), carroDto.getMarca(), carroDto.getModelo(), carroDto.getPlaca(), carroDto.getCor(), null);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
