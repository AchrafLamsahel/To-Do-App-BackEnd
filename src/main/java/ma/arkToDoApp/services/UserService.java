package ma.arkToDoApp.services;

import ma.arkToDoApp.dtos.UserRequestDto;
import ma.arkToDoApp.dtos.UserResponseDto;
import java.util.List;
public interface UserService {
    List<UserResponseDto> getAllUsers();
    UserResponseDto createUser(UserRequestDto userDto);
    public UserResponseDto addUser(UserRequestDto userDto);
    UserResponseDto updateUser(Long id, UserRequestDto userDto) throws Exception;
}
