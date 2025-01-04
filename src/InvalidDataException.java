/*
>> Name: Serge MUNEZA
>> Class: InvalidDataException
>> Description: This class represents a custom exception that is thrown when invalid data is encountered.
>> Instance variables:
    - message: A descriptive error message detailing the nature of the invalid data.
>> Methods:
    - Constructor: Accepts a message as input and passes it to the superclass (Exception).
 */
public class InvalidDataException extends Exception {
    public InvalidDataException(String message) {

        super(message);
    }
}
