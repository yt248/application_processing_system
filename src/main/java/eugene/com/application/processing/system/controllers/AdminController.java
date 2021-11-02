package eugene.com.application.processing.system.controllers;

import eugene.com.application.processing.system.dto.ApplicationDto;
import eugene.com.application.processing.system.dto.ApplicationMapper;
import eugene.com.application.processing.system.model.Application;
import eugene.com.application.processing.system.model.StatusApplication;
import eugene.com.application.processing.system.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@PreAuthorize("hasAnyRole('ADMIN')")
@RequestMapping("/admin")
public class AdminController {


    private final ApplicationService applicationService;

    @Autowired
    public AdminController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/")
    public String getAllApplications(Model model) {
        List<ApplicationDto> applicationDtoList = applicationService.getAllApplications().stream()
                .map(ApplicationMapper::toDto).collect(Collectors.toList());

        List<StatusApplication> statusApplicationList = new ArrayList<>(Arrays.asList(StatusApplication.values()));

        model.addAttribute("applications", applicationDtoList);
        model.addAttribute("statusList", statusApplicationList);
        return "admin/welcome_page_admin";
    }

    @GetMapping("/application/{appId}/edit")
    public String showEditStatusApplication(@PathVariable Long appId, Model model) {
        ApplicationDto applicationDto = ApplicationMapper.toDto(applicationService.getApplicationById(appId));
        model.addAttribute("appDto", applicationDto);
        return "admin/edit_status_application";
    }

    @PostMapping("/application/edit")
    public String editStatusApplication(@ModelAttribute("appDto") ApplicationDto applicationDto) {
        applicationService.updateApplications(applicationDto.getId(), ApplicationMapper.toEntity(applicationDto));
        return "redirect:/admin/";
    }

    @GetMapping("/statistic/application")
    public String getApplicationStatistic(Model model) {
        List<Application> applicationListDone = applicationService.getApplicationsByStatus(StatusApplication.Done);
        List<ApplicationDto> applicationListDoneDto = applicationListDone
                .stream().
                map(ApplicationMapper::toDto).collect(Collectors.toList());

        model.addAttribute("applicationListDone", applicationListDoneDto);
        model.addAttribute("applicationListDoneSize",applicationListDoneDto.size());

        List<Application> applicationListClosed = applicationService.getApplicationsByStatus(StatusApplication.Closed);
        List<ApplicationDto> applicationListClosedDto = applicationListClosed
                .stream().
                map(ApplicationMapper::toDto).collect(Collectors.toList());

        model.addAttribute("applicationListClosed", applicationListClosedDto);
        model.addAttribute("applicationListClosedSize",applicationListClosedDto.size());

        return "admin/statistic_application";
    }

}
