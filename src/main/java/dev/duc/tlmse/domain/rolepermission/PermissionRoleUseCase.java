package dev.duc.tlmse.domain.rolepermission;

import java.util.List;

public interface PermissionRoleUseCase {
    List<PermissionRole> getDataFromRoleCode(String role);
}
