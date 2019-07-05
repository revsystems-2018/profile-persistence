package com.dharbor.set.fusion.dynamicentityservice.exception;

import com.dharbor.set.social.common.hystrix.exception.ExceptionConverter;
import com.dharbor.set.social.common.hystrix.exception.HystrixCommandException;
import org.springframework.http.HttpStatus;

import java.util.Map;

/**
 * @author rvasquez
 */
public class CommandExceptionConverter implements ExceptionConverter {

    private static final String TYPE = "invalid_grant";

    @Override
    @SuppressWarnings("unchecked")
    public <T extends RuntimeException> T convert(HystrixCommandException source) {
        Map<String, Object> exceptionData = source.getData();

        Integer status = (Integer) exceptionData.get("status");
        String error = (String) exceptionData.get("error");

        if (null == status) {
            if (error.equals(TYPE)) {
                return (T) new EntityNotFoundException();
            }
            throw new UnsupportedOperationException("Unable to convert the Exception because 'status' is null", source);
        }

        if (HttpStatus.NOT_FOUND.value() == status) {
            return (T) new EntityNotFoundException();
        }
        if (HttpStatus.FORBIDDEN.value() == status) {
            return (T) new EntityNotFoundException();
        }
        if (HttpStatus.CONFLICT.value() == status) {
            return (T) new EntityNotFoundException();
        }

        throw new UnsupportedOperationException("Unhandled value:"
                + " status " + status
                + ", unable to convert the Exception", source);
    }
}
