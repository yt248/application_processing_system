package eugene.com.application.processing.system.service;

import eugene.com.application.processing.system.model.Application;
import eugene.com.application.processing.system.model.StatusApplication;
import eugene.com.application.processing.system.repository.ApplicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepo applicationRepo;

    @Autowired
    public ApplicationServiceImpl(ApplicationRepo applicationRepo) {
        this.applicationRepo = applicationRepo;
    }

    @Override
    public List<Application> getAllApplications() {
        return applicationRepo.findAll();
    }

    @Override
    public Application getApplicationById(Long id) {
        return applicationRepo.getById(id);
    }

    @Override
    @Transactional
    public void updateApplications(Long id, Application application) {
        Application updateApp = getApplicationById(id);
        updateApp.setRequest(application.getRequest());
        updateApp.setBid(application.getBid());
        updateApp.setDue_date(application.getDue_date());
        updateApp.setStatus(application.getStatus());
        applicationRepo.save(updateApp);
    }

    @Override
    public List<Application> getApplicationsByStatus(StatusApplication statusApplication) {
        return applicationRepo.findApplicationByStatus(statusApplication);
    }


}
