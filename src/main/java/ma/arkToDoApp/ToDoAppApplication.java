package ma.arkToDoApp;

import ma.arkToDoApp.dtos.TaskRequestDto;
import ma.arkToDoApp.dtos.UserRequestDto;
import ma.arkToDoApp.services.TaskService;
import ma.arkToDoApp.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
public class ToDoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoAppApplication.class, args);
	}

	// swagger : http://localhost:8080/swagger-ui/index.html
	@Bean
	public CommandLineRunner startApplication(UserService userService, TaskService taskService){
		return args -> {
			userService.createUser(new UserRequestDto(1L,"Achraf","Lamsahel",
					"Achraflamsahel1@gmail.com"));
			taskService.createTask(new TaskRequestDto(
					1L,"","Description Task 2",1L,"hey",new Date(2027, Calendar.MAY,11)
			));

		};
	}

}
