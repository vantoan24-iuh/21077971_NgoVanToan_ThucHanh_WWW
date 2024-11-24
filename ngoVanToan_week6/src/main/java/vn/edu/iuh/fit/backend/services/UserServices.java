package vn.edu.iuh.fit.backend.services;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.backend.models.User;

import java.util.List;

@Component
public interface UserServices {
    Page<User> getAllUserPage(int pageNo, int pageSize, String sortBy, String sortDirection);
    List<User> getAllUserNoPage();
    User getUserById(int id);
    boolean addUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(int id);
}
