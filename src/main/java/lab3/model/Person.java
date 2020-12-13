package lab3.model;

import lab3.repository.ICrudRepository;

public abstract class Person implements ICrudRepository {

    private String firstName;
    private String lastName;

    public Person(){}

    /**
     * constructor
     * @param firstName
     * @param lastName
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'';
    }
}

