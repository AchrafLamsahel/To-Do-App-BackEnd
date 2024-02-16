package ma.arkToDoApp.services;

import lombok.AllArgsConstructor;
import ma.arkToDoApp.dtos.UserRequestDto;
import ma.arkToDoApp.dtos.UserResponseDto;
import ma.arkToDoApp.mappers.MappingProfile;
import ma.arkToDoApp.repositories.UserRepository;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl {
    private final UserRepository userRepository;

    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(MappingProfile::mapToUserDto).toList();
    }

    public UserResponseDto createUser(UserRequestDto userDto) {
        var user = MappingProfile.mapToUserEntity(userDto);
        return MappingProfile.mapToUserDto(userRepository.save(user));
    }

    public Object getUserById(Long id) throws Exception {
        var user = userRepository.findById(id).orElseThrow(() -> new Exception("User not found"));
        return new Object() {
            public Long id = user.getId();
            public String fullName = user.getLastName().toUpperCase() + ", " + user.getFirstName();
            public String email = user.getEmail();

            public List<Object> tasks = Collections.singletonList(user.getTasks().stream().map(task -> new Object() {
                public Long id = task.getId();
                public String title = task.getTitle();
                public String description = task.getDescription();
                public String status = task.getStatus();
                public String dueDate = task.getDueDate().toString();
                public String createdAt = task.getCreatedAt().toString();
                public String updatedAt = task.getUpdatedAt().toString();
            }).toList());
        };
    }

    public UserResponseDto addUser(UserRequestDto userDto) {
        var user = MappingProfile.mapToUserEntity(userDto);
        return MappingProfile.mapToUserDto(userRepository.save(user));
    }

    public UserResponseDto updateUser(Long id, UserRequestDto userDto) throws Exception {
        var user = userRepository.findById(id).orElseThrow(() -> new Exception("User not found"));
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        return MappingProfile.mapToUserDto(userRepository.save(user));
    }
}
