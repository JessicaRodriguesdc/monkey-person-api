package br.com.monkey.ecx.person;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class PersonCommand {

	private final PersonRepository repository;

	public Person create(Person person) {
		if (repository.findById(person.getCpf()).isPresent()) {
			throw new RuntimeException("Pessoa já cadastrada");
		}
		return repository.save(person);
	}

}
