package br.com.william.spring_essentials.handler;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.client.DefaultResponseErrorHandler;

@ControllerAdvice
public class RestResponseExceptionHandler extends DefaultResponseErrorHandler {
	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		// TODO Auto-generated method stub
		return super.hasError(response);
	}
	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		// TODO Auto-generated method stub
//		super.handleError(response);
		System.out.println("Erro 404");
		System.out.println(IOUtils.toString(response.getBody(),"UTF-8"));
	}
}
