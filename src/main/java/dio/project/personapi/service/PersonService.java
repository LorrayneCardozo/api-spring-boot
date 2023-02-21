package dio.project.personapi.service;

import dio.project.personapi.dto.request.PersonDTO;
import dio.project.personapi.dto.response.MessageResponse;
import dio.project.personapi.entity.Person;
import dio.project.personapi.exceptions.PersonNotFoundException;
import dio.project.personapi.mapper.PersonMapper;
import dio.project.personapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {
    private PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponse createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return createMessageResponse(savedPerson.getId(), "Created person with ID ");
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        //Optional<Person> optionalPerson = personRepository.findById(id);
        Person person = verifyIfExists(id);
        return  personMapper.toDTO((person));
    }

    public void deleteById(Long id) throws PersonNotFoundException {
        verifyIfExists(id);
        personRepository.deleteById(id);
    }

    public MessageResponse updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);
        Person personToUpdate = personMapper.toModel(personDTO);

        Person updatedPerson = personRepository.save(personToUpdate);
        return createMessageResponse(updatedPerson.getId(), "Created person with ID ");
    }
    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    private MessageResponse createMessageResponse(Long id, String message) {
        return MessageResponse
                .builder()
                .message(message + id)
                .build();
    }

}
