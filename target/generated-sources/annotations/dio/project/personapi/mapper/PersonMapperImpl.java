package dio.project.personapi.mapper;

import dio.project.personapi.dto.request.AddressDTO;
import dio.project.personapi.dto.request.PersonDTO;
import dio.project.personapi.dto.request.PhoneDTO;
import dio.project.personapi.entity.Address;
import dio.project.personapi.entity.Person;
import dio.project.personapi.entity.Phone;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-21T13:20:55-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.17 (Ubuntu)"
)
public class PersonMapperImpl implements PersonMapper {

    @Override
    public Person toModel(PersonDTO personDTO) {
        if ( personDTO == null ) {
            return null;
        }

        Person person = new Person();

        if ( personDTO.getBirthDate() != null ) {
            person.setBirthDate( LocalDate.parse( personDTO.getBirthDate(), DateTimeFormatter.ofPattern( "dd-MM-yyyy" ) ) );
        }
        person.setId( personDTO.getId() );
        person.setFirstName( personDTO.getFirstName() );
        person.setLastName( personDTO.getLastName() );
        person.setCpf( personDTO.getCpf() );
        person.setPhones( phoneDTOListToPhoneList( personDTO.getPhones() ) );
        person.setAddresses( addressDTOListToAddressList( personDTO.getAddresses() ) );

        return person;
    }

    @Override
    public PersonDTO toDTO(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();

        personDTO.setId( person.getId() );
        personDTO.setFirstName( person.getFirstName() );
        personDTO.setLastName( person.getLastName() );
        personDTO.setCpf( person.getCpf() );
        if ( person.getBirthDate() != null ) {
            personDTO.setBirthDate( DateTimeFormatter.ISO_LOCAL_DATE.format( person.getBirthDate() ) );
        }
        personDTO.setPhones( phoneListToPhoneDTOList( person.getPhones() ) );
        personDTO.setAddresses( addressListToAddressDTOList( person.getAddresses() ) );

        return personDTO;
    }

    protected Phone phoneDTOToPhone(PhoneDTO phoneDTO) {
        if ( phoneDTO == null ) {
            return null;
        }

        Phone phone = new Phone();

        phone.setId( phoneDTO.getId() );
        phone.setType( phoneDTO.getType() );
        phone.setNumber( phoneDTO.getNumber() );

        return phone;
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

    protected Address addressDTOToAddress(AddressDTO addressDTO) {
        if ( addressDTO == null ) {
            return null;
        }

        Address address = new Address();

        address.setId( addressDTO.getId() );
        address.setType( addressDTO.getType() );
        address.setStreet( addressDTO.getStreet() );
        address.setNumber( addressDTO.getNumber() );
        address.setNeighborhood( addressDTO.getNeighborhood() );
        address.setComplement( addressDTO.getComplement() );
        address.setCity( addressDTO.getCity() );
        address.setState( addressDTO.getState() );

        return address;
    }

    protected List<Address> addressDTOListToAddressList(List<AddressDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Address> list1 = new ArrayList<Address>( list.size() );
        for ( AddressDTO addressDTO : list ) {
            list1.add( addressDTOToAddress( addressDTO ) );
        }

        return list1;
    }

    protected PhoneDTO phoneToPhoneDTO(Phone phone) {
        if ( phone == null ) {
            return null;
        }

        PhoneDTO phoneDTO = new PhoneDTO();

        phoneDTO.setId( phone.getId() );
        phoneDTO.setType( phone.getType() );
        phoneDTO.setNumber( phone.getNumber() );

        return phoneDTO;
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

    protected AddressDTO addressToAddressDTO(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setId( address.getId() );
        addressDTO.setType( address.getType() );
        addressDTO.setStreet( address.getStreet() );
        addressDTO.setNumber( address.getNumber() );
        addressDTO.setNeighborhood( address.getNeighborhood() );
        addressDTO.setComplement( address.getComplement() );
        addressDTO.setCity( address.getCity() );
        addressDTO.setState( address.getState() );

        return addressDTO;
    }

    protected List<AddressDTO> addressListToAddressDTOList(List<Address> list) {
        if ( list == null ) {
            return null;
        }

        List<AddressDTO> list1 = new ArrayList<AddressDTO>( list.size() );
        for ( Address address : list ) {
            list1.add( addressToAddressDTO( address ) );
        }

        return list1;
    }
}
