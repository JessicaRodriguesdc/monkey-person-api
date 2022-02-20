package br.com.monkey.ecx.person;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class PersonQuery {

    private final PersonRepository repository;

    public Person findById(String cpf) {
        Optional<Person> person = repository.findById(cpf);
        if (person.isEmpty()) {
            throw new RuntimeException("Pessoa não encontrada");
        }
        return person.get();
    }

}
