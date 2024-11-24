package vn.edu.iuh.fit.backend.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.User;
import vn.edu.iuh.fit.backend.repositoty.UserRepository;
import vn.edu.iuh.fit.backend.services.UserServices;

import java.util.List;

@Service
public class UserServicesImp implements UserServices {

    @Autowired
    private UserRepository userRepository;
    @Override
    public Page<User> getAllUserPage(int pageNo, int pageSize, String sortBy, String sortDirection) {
//        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
//        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
//        return (Page<User>) userRepository.getAllUser(pageable);
        return null;
    }
    @Override
    public List<User> getAllUserNoPage() {

        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public boolean addUser(User user) {

        user.setFirstName(user.getFirstName());
        user.setMiddleName(user.getMiddleName());
        user.setLastName(user.getLastName());
        user.setMobile(user.getMobile());
        user.setEmail(user.getEmail());
        user.setPasswordHash(user.getPasswordHash());
        user.setRegisteredAt(user.getRegisteredAt());
        user.setLastLogin(user.getLastLogin());
        user.setIntro(user.getIntro());
        user.setProfile(user.getProfile());

        userRepository.save(user);
        return true;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }
}
