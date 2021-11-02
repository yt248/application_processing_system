package eugene.com.application.processing.system.service;


import eugene.com.application.processing.system.model.Application;
import eugene.com.application.processing.system.model.User;

public interface UserService {


    /**
     * @param userId пользователя
     * @param application для создания
     */
     void addApplicationToUser(Long userId, Application application);


    /**
     * @param username Имя пользователя
     * @return пользователь
     */
    User findByUsername(String username);
}
