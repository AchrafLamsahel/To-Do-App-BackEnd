package ma.arkToDoApp;

import ma.arkToDoApp.services.TaskService;
import ma.arkToDoApp.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToDoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoAppApplication.class, args);
	}

	public CommandLineRunner startApplication(UserService userService, TaskService taskService){
		return args -> {

		};
	}

}
