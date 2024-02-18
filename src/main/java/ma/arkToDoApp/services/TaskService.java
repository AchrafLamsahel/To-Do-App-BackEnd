package ma.arkToDoApp.services;

import ma.arkToDoApp.dtos.TaskRequestDto;
import ma.arkToDoApp.dtos.TaskResponseDto;
import ma.arkToDoApp.exceptions.TaskNotFoundException;
import java.util.List;
public interface TaskService {
    List<TaskResponseDto> getAllTasks();
    TaskResponseDto createTask(TaskRequestDto taskDto);
    TaskResponseDto getTaskById(Long id) throws TaskNotFoundException;
    TaskResponseDto updateTask(Long id, TaskRequestDto taskDto) throws TaskNotFoundException;
    void deleteTask(Long id) throws TaskNotFoundException;
}
