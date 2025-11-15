package dev.duc.tlmse.services.rolepermission;

import dev.duc.tlmse.database.entity.PermissionRoleEntity;
import dev.duc.tlmse.database.repository.module.ModuleRepository;
import dev.duc.tlmse.database.repository.role.RoleRepository;
import dev.duc.tlmse.database.repository.rolepermission.RolePermissionRepository;
import dev.duc.tlmse.domain.rolepermission.PermissionRole;
import dev.duc.tlmse.domain.rolepermission.PermissionRoleMapper;
import dev.duc.tlmse.domain.rolepermission.PermissionRoleUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RolePermissionServiceImpl implements PermissionRoleUseCase {

    private final RolePermissionRepository rolePermissionRepository;
    private final RoleRepository roleRepository;
    private final ModuleRepository moduleRepository;
    private final PermissionRoleMapper permissionRoleMapper;
    @Override
    public List<PermissionRole> getDataFromRoleCode(String role) {
        List<PermissionRoleEntity> permissions = this.rolePermissionRepository.findAllByRoleName(role);
        return this.permissionRoleMapper.toDtos(permissions);
    }
}
