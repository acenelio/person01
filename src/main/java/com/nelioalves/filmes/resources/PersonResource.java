package com.nelioalves.filmes.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nelioalves.filmes.domain.Person;
import com.nelioalves.filmes.repository.PersonRepository;

@RestController
@RequestMapping("/person")
public class PersonResource {

	@Autowired
	private PersonRepository repo;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Person>> list() {
		return ResponseEntity.status(HttpStatus.OK).body(repo.findAll());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Person person) {
		person = repo.save(person);
		URI uri = getUri("/{id}", person.getId());
		return ResponseEntity.created(uri).build();
	}
	
	private URI getUri(String key, Integer value) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path(key).buildAndExpand(value).toUri();
	}
}
