package com.example.demotest.converter;

import com.example.demotest.dto.DepartmentDTO;
import com.example.demotest.entity.DepartmentEntity;
import org.springframework.stereotype.Component;

@Component
public class DeConverter {
    public DepartmentEntity toEntity(DepartmentDTO dto) {
        DepartmentEntity entity = new DepartmentEntity();
        entity.setDisplayName(dto.getDisplayName());
        return entity;
    }

    public DepartmentEntity toEntity(DepartmentDTO dto, DepartmentEntity entity) {
        entity.setDisplayName(dto.getDisplayName());
        return entity;
    }

    public DepartmentDTO toDTO(DepartmentEntity entity) {
        DepartmentDTO departmentDTO = new DepartmentDTO();
        if (entity.getId() != null) {
            departmentDTO.setId(entity.getId());
        }
        departmentDTO.setDisplayName(entity.getDisplayName());
        return departmentDTO;
    }

}
