package dev.duc.tlmse.api.v1.controller.permissionrole.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record PermissionRoleResponse(String permission, String description) implements Serializable {
}
