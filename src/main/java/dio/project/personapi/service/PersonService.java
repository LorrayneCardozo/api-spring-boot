package dio.project.personapi.service;

import dio.project.personapi.dto.request.PersonDTO;
import dio.project.personapi.dto.response.MessageResponse;
import dio.project.personapi.entity.Person;
import dio.project.personapi.mapper.PersonMapper;
import dio.project.personapi.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponse createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return createMessageResponse(savedPerson.getId(), "Created person with ID ");
    }

    private MessageResponse createMessageResponse(Long id, String message) {
        return MessageResponse
                .builder()
                .message(message + id)
                .build();
    }
}
