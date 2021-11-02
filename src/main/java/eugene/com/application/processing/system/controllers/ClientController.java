package eugene.com.application.processing.system.controllers;

import eugene.com.application.processing.system.dto.ApplicationDto;
import eugene.com.application.processing.system.dto.ApplicationMapper;
import eugene.com.application.processing.system.dto.UserMapper;
import eugene.com.application.processing.system.model.User;
import eugene.com.application.processing.system.service.ApplicationService;
import eugene.com.application.processing.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@PreAuthorize("hasAnyRole('CLIENT')")
@Controller
@RequestMapping("/client")
public class ClientController {

    private final UserService userService;

    private final ApplicationService applicationService;

    @Autowired
    public ClientController(UserService userService, ApplicationService applicationService) {
        this.userService = userService;
        this.applicationService = applicationService;
    }

    @GetMapping("/")
    public String getAllApplicationByAuthorityUser(Principal principal, Model model) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("userDto", UserMapper.toDto(user));
        return "client/index_page_client";
    }


    @GetMapping("/create")
    public String createApplication(Model model){
        ApplicationDto applicationDto = new ApplicationDto();
        model.addAttribute("appDto", applicationDto);
        return "client/add_application_client";
    }

    @PostMapping("/add")
    public String addApplication(@ModelAttribute("appDto") ApplicationDto applicationDto, Principal principal){
        User user = userService.findByUsername(principal.getName());
        userService.addApplicationToUser(user.getId(), ApplicationMapper.toEntity(applicationDto));
        return "redirect:/client/";
    }

    @GetMapping("/check_status/{appId}")
    public String checkStatusApplication(@PathVariable Long appId, Model model){
        ApplicationDto applicationDto = ApplicationMapper.toDto(applicationService.getApplicationById(appId));
        model.addAttribute("appDto", applicationDto);
        return "client/check_status_application";
    }


}
