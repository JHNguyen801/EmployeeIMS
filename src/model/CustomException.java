package model;

public class CustomException extends Throwable {

    public void checkId(){
        System.out.println("Employee ID must be greater than or equal to 1");
    }
}
