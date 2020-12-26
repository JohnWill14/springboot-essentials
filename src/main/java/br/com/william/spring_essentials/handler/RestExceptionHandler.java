package br.com.william.spring_essentials.handler;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.william.spring_essentials.error.details.ResourcesNotFoundDetails;
import br.com.william.spring_essentials.error.details.ValidationErrorDetails;
import br.com.william.spring_essentials.error.exception.ResourceNotFoundException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handlerResourceNotFoundException(ResourceNotFoundException rnfe) {
		ResourcesNotFoundDetails.Builder builder = ResourcesNotFoundDetails.builder();
		ResourcesNotFoundDetails resourcesNotFoundDetails = builder.withTimestamp(new Date().getTime())
				.withSatus(HttpStatus.NOT_FOUND.value()).withTitle("Resource not found").withDetail(rnfe.getMessage())
				.withDeveloperMessage(rnfe.getClass().getName()).build();

		return new ResponseEntity<>(resourcesNotFoundDetails, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException manve,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<FieldError> fieldErrors = manve.getBindingResult().getFieldErrors();
		String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(", "));
		String fieldMessages = fieldErrors.stream().map(FieldError::getDefaultMessage)
				.collect(Collectors.joining(", "));

		ValidationErrorDetails.Builder builder = ValidationErrorDetails.builder();
		ValidationErrorDetails validationErrorDetails = builder.withTimestamp(new Date().getTime())
				.withSatus(status.value()).withTitle("Validation Error")
				.withDetail("Field  Validation Error").withDeveloperMessage(manve.getClass().getName())
				.withField(fields).withFieldMessage(fieldMessages).build();

		return new ResponseEntity<>(validationErrorDetails, HttpStatus.BAD_REQUEST);

	}
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ResourcesNotFoundDetails.Builder builder = ResourcesNotFoundDetails.builder();
		ResourcesNotFoundDetails resourcesNotFoundDetails = builder.withTimestamp(new Date().getTime())
				.withSatus(status.value()).withTitle("Internal Exception: "+ex.getClass().getSimpleName()).withDetail(ex.getMessage())
				.withDeveloperMessage(ex.getClass().getName()).build();

		return new ResponseEntity<>(resourcesNotFoundDetails, status);
	}

}
