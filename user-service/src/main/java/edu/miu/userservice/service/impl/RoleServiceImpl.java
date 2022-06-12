package edu.miu.userservice.service.impl;

import edu.miu.userservice.dto.request.RoleRequestDTO;
import edu.miu.userservice.dto.response.RoleResponseDTO;
import edu.miu.userservice.model.Role;
import edu.miu.userservice.repository.RoleRepository;
import edu.miu.userservice.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author bijayshrestha on 6/12/22
 * @project cs544-project
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    public RoleServiceImpl(RoleRepository roleRepository, ModelMapper modelMapper) {
        super();
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public RoleResponseDTO saveRole(RoleRequestDTO roleRequestDTO){
        Role roleRequest = modelMapper.map(roleRequestDTO, Role.class);
        Role role = roleRepository.save(roleRequest);
        //TODO: Remove this after testing.
        RoleResponseDTO roleResponse = modelMapper.map(role, RoleResponseDTO.class);

        return roleResponse;
    }
    @Override
    public List<Role> getAllRoles(){
        return roleRepository.findAllRoles(true);
    }

    @Override
    public RoleResponseDTO updateRole(Long id, RoleRequestDTO roleRequestDTO) throws Exception {
        Role roleRequest = modelMapper.map(roleRequestDTO, Role.class);
        Role role = roleRepository.findById(id)
                .orElseThrow(()-> new Exception("Throw Custom Exception here!"));
        role.setName(roleRequestDTO.getName());
        roleRepository.save(role);
        //REMOVE THIS WHEN ETH IS WORKING FINE
        RoleResponseDTO roleResponse = modelMapper.map(role, RoleResponseDTO.class);
        return roleResponse;
    }

    @Override
    public Role deleteRole(Long id) throws Exception {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new Exception("Throw Custom Exception Here."));
        role.setStatus(false);
        return roleRepository.save(role);
    }

    @Override
    public Role getRoleById(Long id) throws Exception {
        Optional<Role> role = roleRepository.findById(id);
        if (role.isPresent()) {
            return role.get();
        }else{
            throw new Exception("Throw some nice erro!");
        }
    }

}
