package projects.onlineshop.web.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import projects.onlineshop.domain.model.User;
import projects.onlineshop.domain.model.UserDetails;
import projects.onlineshop.web.command.EditUserCommand;
import projects.onlineshop.web.command.RegisterUserCommand;

@Component
@Slf4j
public class UserConverter {


    public User from(RegisterUserCommand registerUserCommand) {
        return User.builder()
                .username(registerUserCommand.getUsername())
                .password(registerUserCommand.getPassword())
                .build();
    }

    public UserDetails from (EditUserCommand editUserCommand, User userToEdit) {
        log.debug("Dane do zmiany : {}" , editUserCommand);
        UserDetails userDetails = userToEdit.getUserDetails();
        userDetails.setFirstName(editUserCommand.getFirstName());
        userDetails.setFlatNumber(editUserCommand.getFlatNumber());
        userDetails.setHomeNumber(editUserCommand.getHomeNumber());
        userDetails.setLastName(editUserCommand.getLastName());
        userDetails.setStreet(editUserCommand.getStreet());
        userDetails.setTown(editUserCommand.getTown());
        userDetails.setZipCode(editUserCommand.getZipCode());
        return userDetails;
    }
}
