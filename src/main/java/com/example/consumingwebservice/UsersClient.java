
package com.example.consumingwebservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class UsersClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(UsersClient.class);

	public GetUsersResponse getUsers(String userlastname) {

		GetUsersRequest request = new GetUsersRequest();
		request.setLastname(userlastname);

		log.info("Requesting for " + userlastname);

		GetUsersResponse response = (GetUsersResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://127.0.0.1/SOAP1C/ws/soap.1cws", request,
						new SoapActionCallback(
								"http://spring.io/guides/gs-producing-web-service/GetCountryRequest"));

		return response;
	}

}
