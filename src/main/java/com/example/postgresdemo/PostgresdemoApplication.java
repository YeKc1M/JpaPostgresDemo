package com.example.postgresdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SpringBootApplication
public class PostgresdemoApplication {

	@Autowired
	PersonService personService;

	public static void main(String[] args) {
		SpringApplication.run(PostgresdemoApplication.class, args);
	}

	@GetMapping()
	public String index(@RequestParam(value = "name", defaultValue = "world") String name){
		return String.format("Hello, %s", name);
	}

	@GetMapping("/create")
	public Person create(@ModelAttribute Person person){
		return personService.create(person);
	}

	@GetMapping("/list")
	public List<Person> list(){return personService.list();}

	@GetMapping("/update")
	public Person update(@ModelAttribute Person person){
		return personService.update(person);
	}

	@GetMapping("/fakecreate")
	public Person fakecreate(@RequestParam int id, @RequestParam String name){
		return new FakePersonService().save(new Person(id, name));
	}
	
}
