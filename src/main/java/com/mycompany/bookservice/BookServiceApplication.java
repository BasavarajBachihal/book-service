package com.mycompany.bookservice;

import com.mycompany.bookservice.controller.GreetingController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class BookServiceApplication {

	public static void main(String[] args) {
		GreetingController gc = new GreetingController();
		 //String result = gc.greet();
		System.out.println("Enter your name");
		Scanner sc = new Scanner(System.in);
		String result = gc.greetWithName(sc.nextLine());
		System.out.println(result);
		SpringApplication.run(BookServiceApplication.class, args);
	}

}
