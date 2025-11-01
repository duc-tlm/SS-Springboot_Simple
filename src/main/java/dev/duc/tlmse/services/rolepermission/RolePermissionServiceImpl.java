package dev.duc.tlmse.services.rolepermission;

import dev.duc.tlmse.database.repository.module.ModuleRepository;
import dev.duc.tlmse.database.repository.role.RoleRepository;
import dev.duc.tlmse.database.repository.rolepermission.RolePermissionRepository;
import dev.duc.tlmse.domain.rolepermission.PermissionRoleResultDTO;
import dev.duc.tlmse.domain.rolepermission.PermissionRoleUseCase;
import dev.duc.tlmse.domain.rolepermission.RoleRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RolePermissionServiceImpl implements PermissionRoleUseCase {

    private final RolePermissionRepository rolePermissionRepository;
    private final RoleRepository roleRepository;
    private final ModuleRepository moduleRepository;

    @Override
    public List<PermissionRoleResultDTO> getDataFromRoleCode(RoleRequestDTO role) {
        return List.of();
    }
}
