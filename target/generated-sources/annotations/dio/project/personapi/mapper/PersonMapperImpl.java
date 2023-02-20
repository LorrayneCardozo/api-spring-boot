package dio.project.personapi.mapper;

import dio.project.personapi.dto.request.PersonDTO;
import dio.project.personapi.dto.request.PhoneDTO;
import dio.project.personapi.entity.Person;
import dio.project.personapi.entity.Phone;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-20T19:20:45-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.17 (Ubuntu)"
)
public class PersonMapperImpl implements PersonMapper {

    private final DateTimeFormatter dateTimeFormatter_dd_MM_yyyy_1156787200 = DateTimeFormatter.ofPattern( "dd-MM-yyyy" );

    @Override
    public Person toModel(PersonDTO personDTO) {
        if ( personDTO == null ) {
            return null;
        }

        Person.PersonBuilder person = Person.builder();

        if ( personDTO.getBirthDate() != null ) {
            person.birthDate( LocalDate.parse( personDTO.getBirthDate(), dateTimeFormatter_dd_MM_yyyy_1156787200 ) );
        }
        person.id( personDTO.getId() );
        person.firstName( personDTO.getFirstName() );
        person.lastName( personDTO.getLastName() );
        person.cpf( personDTO.getCpf() );
        person.phones( phoneDTOListToPhoneList( personDTO.getPhones() ) );

        return person.build();
    }

    @Override
    public PersonDTO toDTO(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDTO.PersonDTOBuilder personDTO = PersonDTO.builder();

        personDTO.id( person.getId() );
        personDTO.firstName( person.getFirstName() );
        personDTO.lastName( person.getLastName() );
        personDTO.cpf( person.getCpf() );
        if ( person.getBirthDate() != null ) {
            personDTO.birthDate( DateTimeFormatter.ISO_LOCAL_DATE.format( person.getBirthDate() ) );
        }
        personDTO.phones( phoneListToPhoneDTOList( person.getPhones() ) );

        return personDTO.build();
    }

    protected Phone phoneDTOToPhone(PhoneDTO phoneDTO) {
        if ( phoneDTO == null ) {
            return null;
        }

        Phone.PhoneBuilder phone = Phone.builder();

        phone.id( phoneDTO.getId() );
        phone.type( phoneDTO.getType() );
        phone.number( phoneDTO.getNumber() );

        return phone.build();
    }

    protected List<Phone> phoneDTOListToPhoneList(List<PhoneDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Phone> list1 = new ArrayList<Phone>( list.size() );
        for ( PhoneDTO phoneDTO : list ) {
            list1.add( phoneDTOToPhone( phoneDTO ) );
        }

        return list1;
    }

    protected PhoneDTO phoneToPhoneDTO(Phone phone) {
        if ( phone == null ) {
            return null;
        }

        PhoneDTO.PhoneDTOBuilder phoneDTO = PhoneDTO.builder();

        phoneDTO.id( phone.getId() );
        phoneDTO.type( phone.getType() );
        phoneDTO.number( phone.getNumber() );

        return phoneDTO.build();
    }

    protected List<PhoneDTO> phoneListToPhoneDTOList(List<Phone> list) {
        if ( list == null ) {
            return null;
        }

        List<PhoneDTO> list1 = new ArrayList<PhoneDTO>( list.size() );
        for ( Phone phone : list ) {
            list1.add( phoneToPhoneDTO( phone ) );
        }

        return list1;
    }
}
