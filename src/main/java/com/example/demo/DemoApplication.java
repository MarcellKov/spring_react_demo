package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

class Termek{
	public int left;
	public String name;
	public String id;
	public Termek(String name,int left,String id){
		this.name=name;
		this.left=left;
		this.id=id;
	}

	
}