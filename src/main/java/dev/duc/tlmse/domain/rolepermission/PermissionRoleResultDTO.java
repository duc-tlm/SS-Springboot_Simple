package dev.duc.tlmse.domain.rolepermission;

import java.util.Map;
import java.util.UUID;

public record PermissionRoleResultDTO(UUID module, Map<String, Boolean> permission) {
}
