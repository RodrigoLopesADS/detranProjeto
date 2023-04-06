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

import br.edu.ifms.detran.dto.InfracaoDto;
import br.edu.ifms.detran.model.Infracao;
import br.edu.ifms.detran.service.InfracaoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/infracao")
public class InfracaoResource {

	@Autowired
	private InfracaoService infracao;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Infracao> find(@PathVariable Integer id) {
		Infracao obj = infracao.buscarId(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody InfracaoDto objDto) {
		Infracao obj = infracao.fromDto(objDto);
		obj = infracao.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody InfracaoDto objDto, @PathVariable Integer id) {
		Infracao obj = infracao.fromDto(objDto);
		obj.setId(id);
		obj = infracao.atualizar(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@RequestBody Infracao obj, @PathVariable Integer id) {
		infracao.remover(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<InfracaoDto>> findAll() {
		List<Infracao> list = infracao.buscarTodos();
		List<InfracaoDto> listDto = list.stream().map(obj -> new InfracaoDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

}
