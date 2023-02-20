package dio.project.personapi.controller;

import dio.project.personapi.dto.response.MessageResponse;
import dio.project.personapi.entity.Person;
import dio.project.personapi.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

	private PersonService personService;

	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponse createPerson(@RequestBody Person person) {
		return personService.createPerson(person);
	}
}
