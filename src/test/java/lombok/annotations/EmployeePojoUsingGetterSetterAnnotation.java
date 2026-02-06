package lombok.annotations;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeePojoUsingGetterSetterAnnotation {
	
	private int id;
	private String first_name;
	private String last_name;
	private boolean married;
	
}
