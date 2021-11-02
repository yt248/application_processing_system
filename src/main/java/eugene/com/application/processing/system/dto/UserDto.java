package eugene.com.application.processing.system.dto;

import java.util.ArrayList;
import java.util.List;

public class UserDto {

    private Long id;
    private String username;
    private String name;
    private String surname;
    private String password;
    private String role;
    private boolean active;
    private List<ApplicationDto> applicationDtoList = new ArrayList<>();


    public UserDto() {
    }

    public UserDto(String username, String name, String surname, String password, String role, boolean active) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.role = role;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<ApplicationDto> getApplicationDtoList() {
        return applicationDtoList;
    }

    public void setApplicationDtoList(List<ApplicationDto> applicationDtoList) {
        this.applicationDtoList = applicationDtoList;
    }
}
