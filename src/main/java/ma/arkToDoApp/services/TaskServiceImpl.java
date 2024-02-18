package ma.arkToDoApp.services;

import lombok.AllArgsConstructor;
import ma.arkToDoApp.dtos.TaskRequestDto;
import ma.arkToDoApp.dtos.TaskResponseDto;
import ma.arkToDoApp.mappers.MappingProfile;
import ma.arkToDoApp.repositories.TaskRepository;
import ma.arkToDoApp.utils.DPCombinator.TaskRegistrationValidator;
import ma.arkToDoApp.utils.DPCombinator.UserRegistrationValidator;
import ma.arkToDoApp.utils.DPCombinator.ValidationResult;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

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
        if( TaskRegistrationValidator.statusIsValid()
                .and(TaskRegistrationValidator.titleIsValid())
                .and(TaskRegistrationValidator.dueDateIsValid())
                .apply(taskDto) != ValidationResult.SUCCESS ) throw new RuntimeException();
        var task = MappingProfile.mapToEntity(taskDto);
        return MappingProfile.mapToDto(taskRepository.save(task));
    }

    @Override
    public TaskResponseDto getTaskById(Long id) throws Exception {
        var task = taskRepository.findById(id).orElseThrow(() -> new Exception("Task not found"));
        return MappingProfile.mapToDto(task);
    }

    @Override
    public TaskResponseDto updateTask(Long id, TaskRequestDto taskDto) throws Exception {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new Exception("Task not found"));
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setId(taskDto.getId());
        task.setStatus(taskDto.getStatus());
        task.setDueDate(task.getDueDate());
        return MappingProfile.mapToDto(taskRepository.save(task));
    }

    @Override
    public void deleteTask(Long id) throws Exception {
        var task = taskRepository.findById(id).orElseThrow(() -> new Exception("Task not found"));
        taskRepository.delete(task);
    }
}