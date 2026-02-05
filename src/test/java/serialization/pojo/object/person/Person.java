package serialization.pojo.object.person;

import lombok.Getter;
import lombok.Setter;
import serialization.pojo.array.person.Address;

@Getter
@Setter
public class Person {

	private int id;
	private String first_name;
	private String last_name;
	private String profession;
	private Address address;

}
