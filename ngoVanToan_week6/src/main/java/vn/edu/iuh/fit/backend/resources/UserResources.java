package vn.edu.iuh.fit.backend.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.backend.models.User;
import vn.edu.iuh.fit.backend.repositoty.UserRepository;
import vn.edu.iuh.fit.backend.services.UserServices;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserResources {

    @Autowired
    private UserServices userServices;

    @GetMapping
    public List<User> getAllUser() {
        return userServices.getAllUserNoPage();
    }


}
