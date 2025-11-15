package dev.duc.tlmse.domain.rolepermission;

import java.util.Map;

public record PermissionRoleResultDTO(String module, Map<String, Boolean> permission) {
}
