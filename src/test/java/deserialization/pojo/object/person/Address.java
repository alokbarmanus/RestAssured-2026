package deserialization.pojo.object.person;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Address {

    private int houseNo;
    private String streetName;
    private String city;
    private String state;
    private String country;
}
