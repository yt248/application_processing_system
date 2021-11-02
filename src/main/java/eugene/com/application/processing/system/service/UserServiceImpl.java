package eugene.com.application.processing.system.service;

import eugene.com.application.processing.system.model.Application;
import eugene.com.application.processing.system.model.User;
import eugene.com.application.processing.system.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    @Transactional
    public void addApplicationToUser(Long userId, Application application) {
        User user = userRepo.getById(userId);
        application.setCreatorApplication(user);
        user.getApplicationList().add(application);
        userRepo.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}
