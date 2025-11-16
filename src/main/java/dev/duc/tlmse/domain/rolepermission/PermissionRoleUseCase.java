package dev.duc.tlmse.domain.rolepermission;

import dev.duc.tlmse.repository.redis.permissions.PermissionsEntity;

import java.util.List;
import java.util.UUID;

public interface PermissionRoleUseCase {
    List<PermissionRole> getDataFromRoleCode(String role);

    PermissionsEntity getDateFromCache(UUID roleId);

}
