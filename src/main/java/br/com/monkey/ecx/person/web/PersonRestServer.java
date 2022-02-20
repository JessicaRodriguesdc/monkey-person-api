package br.com.monkey.ecx.person.web;

import br.com.monkey.ecx.person.Person;
import br.com.monkey.ecx.person.PersonCommand;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@ExposesResourceFor(Person.class)
@RequestMapping("v1/persons/")
public class PersonRestServer {

	private final PersonCommand command;

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

}
