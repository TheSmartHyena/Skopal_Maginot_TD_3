package xml;

public class WrongClientTypeException extends Exception { 
    public WrongClientTypeException(String errorMessage) {
        super(errorMessage);
    }
}