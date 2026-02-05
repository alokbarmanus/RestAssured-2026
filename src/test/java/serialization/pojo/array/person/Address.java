package serialization.pojo.array.person;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {

    private int houseNo = 3;
    private String streetName = "Marshall Street";
    private String city = "Irvington";
    private String state = "NJ";
    private String country = "USA";
    
}
