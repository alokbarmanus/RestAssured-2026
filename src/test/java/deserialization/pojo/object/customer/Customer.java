package deserialization.pojo.object.customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {

	private int accountNo = 319848816;
	private double balance = 1111.11;
	private String first_name = "Alok";
	private String last_name = "Barman";
	private String email = "test@abc.com";
	private String gender = "Male";
}
