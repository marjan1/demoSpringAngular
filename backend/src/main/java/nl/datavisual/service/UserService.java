package nl.datavisual.service;

import nl.datavisual.dto.User;
import nl.datavisual.repo.UserRepository;
import nl.datavisual.spec.bilder.UserSpecificationsBuilder;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {
    Logger log = LoggerFactory.getLogger(UserService.class);
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.modelMapper = new ModelMapper();
    }

    public List<User> searchUser(Integer companyId, Integer roleId, String email, String name, String username, Integer statusCode) {
        log.debug("Search User by email = {}, name ={}, username = {}", email, name, username);

        UserSpecificationsBuilder userSpecificationsBuilder = new UserSpecificationsBuilder()
                .with("email", ":", email)
                .with("name", ":", name)
                .with("username", ":", username);

        List<User> users = userRepository.findAll(userSpecificationsBuilder.build()).stream()
                .map(user -> modelMapper.map(user, User.class)).collect(Collectors.toList());
        return users;
    }

    public User create(User user) {

        final nl.datavisual.entity.User savedUser = userRepository.save(modelMapper.map(user, nl.datavisual.entity.User.class));
        return modelMapper.map(savedUser, User.class);
    }

    public User delete(long id) {
        nl.datavisual.entity.User user = userRepository.findOne(id);
        if (user != null) {
            userRepository.delete(user);
        }
        return modelMapper.map(user, User.class);
    }

    public List<User> findAll() {

        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .map(user -> modelMapper.map(user, User.class)).collect(Collectors.toList());
    }

    public User findById(long id) {
        return modelMapper.map(userRepository.findOne(id), User.class);
    }

    public User update(User user) {
        if (userRepository.exists(user.getIdUsers())) {
            userRepository.save(modelMapper.map(user, nl.datavisual.entity.User.class));
        }
        return modelMapper.map(user, User.class);
    }
}

