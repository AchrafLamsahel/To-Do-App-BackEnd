package ma.arkToDoApp.web;

import lombok.AllArgsConstructor;
import ma.arkToDoApp.dtos.TaskRequestDto;
import ma.arkToDoApp.dtos.TaskResponseDto;
import ma.arkToDoApp.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;
    // add ExceptionHandling
    // create custom exceptions NotFoundException, DataNotValidException, etc.
    // BONUS : Add Swagger documentation (OpenAPI)!
    @GetMapping(value = "/" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllTasks() {
        List<TaskResponseDto> alltasks = taskService.getAllTasks();
        if( alltasks.isEmpty() ){
            return new ResponseEntity<>("Taks doesn't exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTaskById(@PathVariable("id") Long id) throws Exception {
        taskService.getTaskById(id);
        return new ResponseEntity<>();
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createTask(@RequestBody TaskRequestDto taskDto) {
        return new ResponseEntity<>(taskService.createTask(taskDto), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateById(@RequestBody TaskRequestDto taskDto) {
        return new ResponseEntity<>(taskService.updateTask(taskDto), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) throws Exception {
        return new ResponseEntity<>(taskService.deleteTask(id));
    }


}