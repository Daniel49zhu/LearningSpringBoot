package com.zjc.websocket;

import com.zjc.websocket.domain.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@SpringBootApplication
public class WebsocketApplication {


	@RequestMapping(value = "/search",produces = {MediaType.APPLICATION_JSON_VALUE})
	public Person search(String personName){
		return new Person(personName,new Random().nextInt(20)+10,"wuhu");
	}

	public static void main(String[] args) {
		SpringApplication.run(WebsocketApplication.class, args);
	}

}

