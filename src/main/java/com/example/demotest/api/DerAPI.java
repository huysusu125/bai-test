package com.example.demotest.api;


import com.example.demotest.dto.DepartmentDTO;
import com.example.demotest.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class DerAPI {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping(value = "/department")
    public List<DepartmentDTO> showAll() {
        return departmentService.findAll();
    }

    @PostMapping(value = "/department")
    public DepartmentDTO addOne(@RequestBody DepartmentDTO departmentDTO) {
        return departmentService.save(departmentDTO);
    }

    @PutMapping(value = "/department/{id}")
    public DepartmentDTO update(@RequestBody DepartmentDTO departmentDTO, @PathVariable("id") long id  ) {
        departmentDTO.setId(id);
        return departmentService.save(departmentDTO);
    }

    @DeleteMapping(value = "/department/{id}")
    public void deleteNew(@RequestBody @PathVariable("id") long id) {
        departmentService.delete(id);
    }
}
