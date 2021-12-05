import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * 例外ハンドリングクラス
 */
@ControllerAdvice
public class ControllerExceptionHandler {


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public String handlMethodTypeMismatchError(MethodArgumentTypeMismatchException e) {
        return "{ Error" + e.getMessage() + " }";
    }

    @ExceptionHandler(NumberFormatException.class)
    public String handlNumberFormatError(NumberFormatException e) {
        return "{ Error" + e.getMessage() + " }";
    }
}
