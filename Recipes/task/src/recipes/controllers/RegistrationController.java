package recipes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;
import recipes.repositories.UserRepository;

@RestController
public class RegistrationController {
    private static final System.Logger LOG = System.getLogger(RegistrationController.class.getName());
    @Autowired
    UserRepository repository;

    @Autowired
    PasswordEncoder encoder;

}
