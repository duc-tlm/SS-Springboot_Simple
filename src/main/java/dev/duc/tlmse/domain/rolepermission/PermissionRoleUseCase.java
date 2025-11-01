package dev.duc.tlmse.domain.rolepermission;

import java.util.List;

public interface PermissionRoleUseCase {
    List<PermissionRoleResultDTO> getDataFromRoleCode(RoleRequestDTO role);
}
