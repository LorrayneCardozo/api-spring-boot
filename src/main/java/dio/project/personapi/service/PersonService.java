package dio.project.personapi.service;

import dio.project.personapi.dto.response.MessageResponse;
import dio.project.personapi.entity.Person;
import dio.project.personapi.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonService {
    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponse createPerson(Person person) {
        Person savePerson = personRepository.save(person);
        return MessageResponse
                .builder().message("Created person with ID: "+savePerson.getId())
                .build();
    }
}
