package eugene.com.application.processing.system.service;

import eugene.com.application.processing.system.model.Application;
import eugene.com.application.processing.system.model.StatusApplication;

import java.util.List;

public interface ApplicationService {


    /**
     * @return Получение списка всех завяков
     */
    List<Application> getAllApplications ();

    Application getApplicationById(Long id);

    void updateApplications(Long id, Application application);

    List<Application> getApplicationsByStatus (StatusApplication statusApplication);

}
