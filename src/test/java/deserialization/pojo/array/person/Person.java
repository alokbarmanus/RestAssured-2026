package deserialization.pojo.array.person;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Person {

	private int id;
	private String first_name;
	private String last_name;
	private String profession;
	private List<Address> address;
}
