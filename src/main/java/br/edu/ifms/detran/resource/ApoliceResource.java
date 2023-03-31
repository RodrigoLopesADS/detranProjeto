package br.edu.ifms.detran.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.ifms.detran.dto.ApoliceDto;
import br.edu.ifms.detran.model.Apolice;
import br.edu.ifms.detran.service.ApoliceService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value ="/apolice")
public class ApoliceResource {

	@Autowired
	private ApoliceService apolice;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Apolice> find(@PathVariable Integer id) {		
		Apolice obj = apolice.buscarId(id);
		return ResponseEntity.ok().body(obj);
	}
		
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ApoliceDto objDto) {
		Apolice obj = apolice.fromDto(objDto);
		obj = apolice.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ApoliceDto objDto, @PathVariable Integer id) {
		Apolice obj = apolice.fromDto(objDto);
		obj.setId(id);
		obj = apolice.atualizar(obj);
		return ResponseEntity.noContent().build();
	}	
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@RequestBody Apolice obj,@PathVariable Integer id){
		apolice.remover(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ApoliceDto>> findAll() {		
		List<Apolice> list = apolice.buscarTodos();
		List<ApoliceDto> listDto = list.stream().map(obj -> new ApoliceDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}	

}
