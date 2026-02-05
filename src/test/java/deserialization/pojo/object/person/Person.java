package deserialization.pojo.object.person;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Person {

	private int id;
	private String first_name;
	private String last_name;
	private String profession;
	private Address address;
}
