package tacos;

import java.net.URI;

import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class CommonProperties {
	
	public static final String POST_ENDPOINT_HEADER  = "/{id}";
	public static final String PUT_ENDPOINT_HEADER = "";
	
	public static HttpHeaders buildHeaderLocation(long id, String param) {
		URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path(param)
                .buildAndExpand(id)
                .toUri();
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(location);
		return responseHeaders;
	}

}
