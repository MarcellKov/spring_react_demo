package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

@Document(collection = "termek")
class Termek{
	public int left;
	public String name;
	@Id
	public String id;
	public Termek(String name,int left,String id){
		this.name=name;
		this.left=left;
		this.id=id;
	}

	
}