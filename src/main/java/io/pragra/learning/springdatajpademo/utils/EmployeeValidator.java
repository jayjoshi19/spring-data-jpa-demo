package io.pragra.learning.springdatajpademo.utils;

public class EmployeeValidator {

    public static boolean validateId(Long id) {
        ///  id should be more than 5 digits and less than 7 digits
        ///  5 < id < 7 <-- Id should be in this range
        return id < 1000000 && id > 0;
    }

    public static boolean validateLastName(String lastName) {
        // last lastName should contain string values only
        //if (lastName.equalsIgnoreCase("")) return false;
        return lastName.matches("[A-Z][a-z]*");
    }
}
