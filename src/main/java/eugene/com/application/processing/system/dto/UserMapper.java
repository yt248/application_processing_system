package eugene.com.application.processing.system.dto;

import eugene.com.application.processing.system.model.User;

public class UserMapper {

    public static User toEntity(UserDto dto) {
        User entity = new User();
        entity.setId(dto.getId());
        entity.setUsername(dto.getUsername());
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setPassword(dto.getPassword());
        entity.setActive(dto.isActive());
        entity.setRole(dto.getRole());

        dto.getApplicationDtoList().forEach((appDto) -> entity.getApplicationList().add(ApplicationMapper.toEntity(appDto)));

        return entity;
    }

    public static UserDto toDto(User entity) {
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setName(entity.getName());
        dto.setPassword(entity.getPassword());
        dto.setActive(entity.isActive());
        dto.setRole(entity.getRole());

        entity.getApplicationList().forEach((app)-> dto.getApplicationDtoList().add(ApplicationMapper.toDto(app)));

        return dto;
    }
}
