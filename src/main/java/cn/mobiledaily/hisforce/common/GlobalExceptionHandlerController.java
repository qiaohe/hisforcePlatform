package cn.mobiledaily.hisforce.common;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.TypeMismatchException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Johnson on 2015/4/23.
 */
@ControllerAdvice
public class GlobalExceptionHandlerController {
    private static final String VALIDATION_ERROR_DELIMITER = ",";
    @Inject
    private LocalizedMessageSource localizedMessageSource;

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result defaultErrorHandler(HttpServletRequest req, HttpServletResponse res, Exception e) throws Exception {
        if (e instanceof HttpRequestMethodNotSupportedException)
            return Result.failResult(localizedMessageSource.getMessage("http.method.notsupport"));
        if (e instanceof TypeMismatchException)
            return Result.failResult(localizedMessageSource.getMessage("http.type.mismatch"));
        return Result.failResult(localizedMessageSource.getMessage(StringUtils.isEmpty(e.getMessage()) ? "server.internal.error" : e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Result defaultNotValidErrorHandler(MethodArgumentNotValidException ex) throws Exception {
        BindingResult bindingResult = ex.getBindingResult();
        List<String> errorMessages = new ArrayList<>();
        for (ObjectError error : bindingResult.getAllErrors()) {
            errorMessages.add(localizedMessageSource.getMessage(error.getDefaultMessage()));
        }
        return Result.failResult(StringUtils.join(errorMessages, VALIDATION_ERROR_DELIMITER));
    }
}