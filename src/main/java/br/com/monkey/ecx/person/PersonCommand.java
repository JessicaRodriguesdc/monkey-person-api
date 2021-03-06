package br.com.monkey.ecx.person;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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

	public Person update(Person person) {
		if (repository.findById(person.getCpf()).isEmpty()) {
			throw new RuntimeException("Pessoa não cadastrada");
		}
		return repository.save(person);
	}

	public void delete(String cpf) {
		Optional<Person> personDb = repository.findById(cpf);
		if (personDb.isEmpty()) {
			throw new RuntimeException("Pessoa não cadastrada");
		}
		repository.delete(personDb.get());
	}

}
