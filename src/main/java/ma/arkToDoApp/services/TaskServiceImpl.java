package ma.arkToDoApp.services;

import lombok.AllArgsConstructor;
import ma.arkToDoApp.dtos.TaskRequestDto;
import ma.arkToDoApp.dtos.TaskResponseDto;
import ma.arkToDoApp.exceptions.TaskInputNotValidException;
import ma.arkToDoApp.exceptions.TaskNotFoundException;
import ma.arkToDoApp.mappers.MappingProfile;
import ma.arkToDoApp.repositories.TaskRepository;
import ma.arkToDoApp.utils.DPCombinator.TaskRegistrationValidator;
import ma.arkToDoApp.utils.DPCombinator.ValidationResult;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import static ma.arkToDoApp.utils.DPCombinator.TaskRegistrationValidator.dueDateIsValid;
import static ma.arkToDoApp.utils.DPCombinator.TaskRegistrationValidator.titleIsEmpty;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService{
    private final TaskRepository taskRepository;

    @Override
    public List<TaskResponseDto> getAllTasks() {
        return taskRepository.findAll().stream()
                .map(MappingProfile::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public TaskResponseDto createTask(TaskRequestDto taskDto) {
        if( TaskRegistrationValidator.statusIsEmpty()
                .and(titleIsEmpty())
                .and(dueDateIsValid())
                .apply(taskDto) != ValidationResult.SUCCESS )
            throw new TaskInputNotValidException("Task Input not Valid ! ");
        var task = MappingProfile.mapToEntity(taskDto);
        return MappingProfile.mapToDto(taskRepository.save(task));
    }

    @Override
    public TaskResponseDto getTaskById(Long id) throws TaskNotFoundException {
        var task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found"));
        return MappingProfile.mapToDto(task);
    }

    @Override
    public TaskResponseDto updateTask(Long id, TaskRequestDto taskDto) throws TaskNotFoundException {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task Not found !"));
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setId(taskDto.getId());
        task.setStatus(taskDto.getStatus());
        task.setDueDate(task.getDueDate());
        return MappingProfile.mapToDto(taskRepository.save(task));
    }

    @Override
    public void deleteTask(Long id) throws TaskNotFoundException {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found"));
        taskRepository.delete(task);
    }
}