package edu.miu.userservice.controller;

import edu.miu.userservice.dto.request.RoleRequestDTO;
import edu.miu.userservice.dto.response.ApiResponse;
import edu.miu.userservice.dto.response.RoleResponseDTO;
import edu.miu.userservice.model.Role;
import edu.miu.userservice.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static edu.miu.userservice.constant.WebResourceKeyConstant.API_V1;
import static edu.miu.userservice.constant.WebResourceKeyConstant.RoleConstants.ROLE_ID;
import static edu.miu.userservice.constant.WebResourceKeyConstant.RoleConstants.ROLE_BASE;

/**
 * @author bijayshrestha on 6/12/22
 * @project cs544-project
 */
@RestController
@RequestMapping(value = API_V1 + ROLE_BASE)
public class RoleController {

    private final RoleService roleService;
    private final ModelMapper modelMapper;

    public RoleController(RoleService roleService, ModelMapper modelMapper) {
        super();
        this.roleService = roleService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<RoleResponseDTO> getAllRoles() {
        return roleService.getAllRoles().stream().map(role ->
                        modelMapper.map(role, RoleResponseDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping(ROLE_ID)
    public ResponseEntity<RoleResponseDTO> getRoleById(@PathVariable(name = "id") Long id) throws Exception {
        Role role = roleService.getRoleById(id);
        RoleResponseDTO roleResponse = modelMapper.map(role, RoleResponseDTO.class);
        return ResponseEntity.ok().body(roleResponse);
    }

    @PostMapping
    public ResponseEntity<?> createRole(@RequestBody RoleRequestDTO roleRequestDTO){
       RoleResponseDTO roleResponseDTO =  roleService.saveRole(roleRequestDTO);
        return new ResponseEntity<>(roleResponseDTO, HttpStatus.CREATED);
    }

    @PutMapping(ROLE_ID)
    public ResponseEntity<?> updateRole(@PathVariable Long id, @RequestBody RoleRequestDTO roleRequestDTO) throws Exception {
        RoleResponseDTO roleResponse = roleService.updateRole(id, roleRequestDTO);
        return ResponseEntity.ok().body(roleResponse);
    }

    @DeleteMapping(ROLE_ID)
    public ResponseEntity<ApiResponse> deletePost(@PathVariable(name = "id") Long id) throws Exception {
        roleService.deleteRole(id);
        ApiResponse apiResponse = new ApiResponse(
                Boolean.TRUE,
                "Role deleted successfully",
                HttpStatus.OK);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }
}
