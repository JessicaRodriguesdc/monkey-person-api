package br.com.monkey.ecx.person.web;

import br.com.monkey.ecx.person.Person;
import br.com.monkey.ecx.person.PersonCommand;
import br.com.monkey.ecx.person.PersonQuery;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@ExposesResourceFor(Person.class)
@RequestMapping("v1/persons/")
public class PersonRestServer {

	private final PersonCommand command;

	private final PersonQuery query;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Person create(@RequestBody @Valid Person person) {
		return command.create(person);
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public Person update(@RequestBody @Valid Person person) {
		return command.update(person);
	}

	@DeleteMapping("{cpf}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable String cpf) {
		command.delete(cpf);
	}

	@GetMapping("{cpf}")
	@ResponseStatus(HttpStatus.OK)
	public Person findById(@PathVariable String cpf) {
		return query.findById(cpf);
	}
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Person> findAll(){
		return query.findAll();
	}
}
