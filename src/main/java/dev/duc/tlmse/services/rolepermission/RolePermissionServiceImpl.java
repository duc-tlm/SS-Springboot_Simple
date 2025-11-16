package dev.duc.tlmse.services.rolepermission;

import dev.duc.tlmse.domain.rolepermission.PermissionRole;
import dev.duc.tlmse.domain.rolepermission.PermissionRoleMapper;
import dev.duc.tlmse.domain.rolepermission.PermissionRoleUseCase;
import dev.duc.tlmse.repository.redis.permissions.PermissionsEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RolePermissionServiceImpl implements PermissionRoleUseCase {

    private final RolePermissionCommandService command;
    private final RolePermissionQueryService query;

    private final PermissionRoleMapper permissionRoleMapper;

    @Override
    public List<PermissionRole> getDataFromRoleCode(String role) {
        return query.getDataFromRoleCode(role);
    }

    @Override
    public PermissionsEntity getDateFromCache(UUID roleId) {
        return query.getDateFromCache(roleId);
    }
}
