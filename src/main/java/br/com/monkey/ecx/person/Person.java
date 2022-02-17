package br.com.monkey.ecx.person;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import org.springframework.hateoas.server.core.Relation;
import javax.validation.constraints.NotEmpty;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@ToString
@Builder(toBuilder = true)
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
@EqualsAndHashCode(callSuper = false)
@Relation(value = "person", collectionRelation = "persons")
public class Person {

	@Id
	@Column(updatable = false)
	private String cpf;

	@NotEmpty
	private String firstName;

	@NotEmpty
	private String lastName;

	@NotEmpty
	private LocalDate birthDate;

}
