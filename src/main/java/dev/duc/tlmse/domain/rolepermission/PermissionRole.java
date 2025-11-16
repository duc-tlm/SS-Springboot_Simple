package dev.duc.tlmse.domain.rolepermission;

import java.io.Serializable;
import java.util.Map;
import java.util.UUID;

public record PermissionRole(UUID roleId, String serviceCode,
                             Map<UUID, Map<String, Boolean>> permission) implements Serializable {
}