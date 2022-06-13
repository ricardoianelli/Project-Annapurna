package edu.miu.userservice.service;

import edu.miu.userservice.dto.request.RoleRequestDTO;
import edu.miu.userservice.dto.request.RoleRequestUpdateDTO;
import edu.miu.userservice.dto.response.RoleResponseDTO;
import edu.miu.userservice.model.Role;

import java.util.List;

/**
 * @author bijayshrestha on 6/12/22
 * @project cs544-project
 */
public interface RoleService {

    List<Role> getAllRoles();

    RoleResponseDTO saveRole(RoleRequestDTO roleRequestDTO);


    Role getRoleById(Long id) throws Exception;

    Role deleteRole(Long id) throws Exception;

    RoleResponseDTO updateRole(Long id, RoleRequestUpdateDTO roleRequestUpdateDTO) throws Exception;
}
