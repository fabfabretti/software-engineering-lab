package mvc.app;

public class Person {

    private String firstName;
    private String lastName;
    // add class fields to store data

    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        // save the formal parameter values to proper class fields
    }

    String getFirstName() {
        // read data
        return firstName;
    }

    void setFirstName(String firstName) {
        // write data
        this.firstName = firstName;
    }

    String getLastName() {
        // read data
        return lastName;
    }

    void setLastName(String lastName) {
        // write data
        this.lastName = lastName;
    }

}
