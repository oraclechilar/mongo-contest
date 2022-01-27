package uz.jl.exception;

import uz.jl.enums.HttpStatus;

/**
 * @author Bakhromjon Wed, 8:09 PM 1/26/2022
 */
public class CustomException extends RuntimeException{
    private HttpStatus status;

    public CustomException(String message) {
        super(message);
        this.status = HttpStatus.HTTP_200;
    }

    public CustomException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
