package agorlab.willy.services;

import agorlab.willy.dto.response.UserResponseDto;
import agorlab.willy.exceptions.response.UserNotFoundException;
import agorlab.willy.mappers.UserMapper;
import agorlab.willy.models.User;
import agorlab.willy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }

    @Transactional
    public UserResponseDto updateUserFirstName(Long id, String firstName) {
        User user = findById(id);
        user.setFirstName(firstName);

        User updatedUser = userRepository.save(user);
        return userMapper.toDto(updatedUser);
    }

    @Transactional
    public UserResponseDto updateUserLastName(Long id, String lastName) {
        User user = findById(id);
        user.setLastName(lastName);

        User updatedUser = userRepository.save(user);
        return userMapper.toDto(updatedUser);
    }

    public User save(User user){
        return userRepository.save(user);
    }

    @PreAuthorize("hasRole('ANALISTA')")
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }
}