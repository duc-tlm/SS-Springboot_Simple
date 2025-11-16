package dev.duc.tlmse.services.rolepermission;

import dev.duc.tlmse.domain.rolepermission.PermissionRole;
import dev.duc.tlmse.domain.rolepermission.PermissionRoleMapper;
import dev.duc.tlmse.repository.database.module.ModuleRepository;
import dev.duc.tlmse.repository.database.role.RoleRepository;
import dev.duc.tlmse.repository.database.permissions.PermissionRoleEntity;
import dev.duc.tlmse.repository.database.permissions.RolePermissionRepository;
import dev.duc.tlmse.repository.redis.permissions.PermissionRepository;
import dev.duc.tlmse.repository.redis.permissions.PermissionsEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class RolePermissionQueryService {

    private final RolePermissionRepository rolePermissionRepository;
    private final RoleRepository roleRepository;
    private final ModuleRepository moduleRepository;
    private final PermissionRoleMapper permissionRoleMapper;
    private final PermissionRepository permissionRepository;
    private final RedisTemplate<String, String> redisTemplate;

    public List<PermissionRole> getDataFromRoleCode(String role) {
        List<PermissionRoleEntity> permissions = this.rolePermissionRepository.findAllByRoleName(role);
        cacheable(permissions);
        return this.permissionRoleMapper.toDtos(permissions);
    }

    public PermissionsEntity getDateFromCache(UUID roleId) {
        String key = "permission:" + roleId.toString();
        return (PermissionsEntity) redisTemplate.opsForHash().get(key, roleId);
    }

    @Async
    public void cacheable(List<PermissionRoleEntity> permissions) {
        this.permissionRepository.saveAll(this.permissionRoleMapper.toCacheDtos(permissions));
    }

}
