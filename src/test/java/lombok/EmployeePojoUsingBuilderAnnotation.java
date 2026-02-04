package lombok;

@Builder(toBuilder=true)
@Getter
public class EmployeePojoUsingBuilderAnnotation {
	
	private int id;
	private String first_name;
	private String last_name;
	private boolean married;
	
}
