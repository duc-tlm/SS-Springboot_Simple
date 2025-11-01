package dev.duc.tlmse.api.v1.controller.permissionrole.resquest;

import com.fasterxml.jackson.annotation.JsonInclude;
import dev.duc.tlmse.validation.RoleDetailValidator;
import org.springframework.lang.NonNull;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record PermissionRoleRequest(
        @RoleDetailValidator String permission,
        @NonNull String description) implements Serializable {
}
