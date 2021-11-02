package eugene.com.application.processing.system.dto;

import eugene.com.application.processing.system.model.Application;

public class ApplicationMapper {

    public static Application toEntity(ApplicationDto dto) {
        Application entity = new Application();
        entity.setId(dto.getId());
        entity.setRequest(dto.getRequest());
        entity.setBid(dto.getBid());
        entity.setDue_date(dto.getDue_date());
        entity.setStatus(dto.getStatus());
        return entity;
    }


    public static ApplicationDto toDto(Application entity) {
        ApplicationDto dto = new ApplicationDto();
        dto.setId(entity.getId());
        dto.setRequest(entity.getRequest());
        dto.setBid(entity.getBid());
        dto.setDue_date(entity.getDue_date());
        dto.setStatus(entity.getStatus());
        return dto;
    }

}
