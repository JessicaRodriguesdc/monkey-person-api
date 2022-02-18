package br.com.monkey.ecx.person;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import org.springframework.hateoas.server.core.Relation;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Entity
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(access = PRIVATE)
@Relation(value = "person", collectionRelation = "persons")
public class Person {

	@Id
	@Column(updatable = false)
	private String cpf;

	@NotEmpty
	private String firstName;

	@NotEmpty
	private String lastName;

	@NotNull
	private LocalDate birthDate;

}
