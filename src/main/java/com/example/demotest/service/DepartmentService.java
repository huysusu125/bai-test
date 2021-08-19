package com.example.demotest.service;

import com.example.demotest.converter.DeConverter;
import com.example.demotest.dto.DepartmentDTO;
import com.example.demotest.entity.DepartmentEntity;
import com.example.demotest.repositpry.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DeConverter deConverter;

    public List<DepartmentDTO> findAll() {
        List<DepartmentEntity> entities = departmentRepository.findAll();
        List<DepartmentDTO> dtos = new ArrayList<>();
        entities.forEach(entity -> {
            dtos.add(mapper.map(entity, DepartmentDTO.class));
        });
        return dtos;
    }

    public DepartmentDTO save(DepartmentDTO dto) {
        DepartmentEntity entity = new DepartmentEntity();
        if (dto.getId() != null) {
            DepartmentEntity old = departmentRepository.findById(dto.getId()).orElse(null);
            old = mapper.map(dto,DepartmentEntity.class);
            entity = old;
        } else {
            entity = mapper.map(dto, DepartmentEntity.class);
        }
        departmentRepository.save(entity);
        dto = mapper.map(entity, DepartmentDTO.class);
        dto.setId(entity.getId());
        return dto;
    }


    public void delete(long id) {
        departmentRepository.deleteById(id);
    }

}
