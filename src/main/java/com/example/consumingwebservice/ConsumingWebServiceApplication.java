
package com.example.consumingwebservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ConsumingWebServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConsumingWebServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(UsersClient quoteClient) {
		return args -> {
			String userlastname = "Иванов";
			ObjectMapper mapper = new ObjectMapper();

			if (args.length > 0) {
				userlastname = args[0];
			}
			GetUsersResponse response = quoteClient.getUsers(userlastname);
			String s = mapper.writeValueAsString(response.getReturn());
			System.out.println(s);

		};
	}

}
