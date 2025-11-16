package dev.duc.tlmse.domain.rolepermission;

import dev.duc.tlmse.repository.database.entity.PermissionRoleEntity;
import org.mapstruct.*;

import java.util.*;
import java.util.stream.Collectors;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING)
public interface PermissionRoleMapper {
    PermissionRoleEntity toEntity(PermissionRole permissionRole);


    default PermissionRole toDto(PermissionRoleEntity permissionRoleEntity) {
        PermissionRole permissionRole = new PermissionRole(permissionRoleEntity.getRoleId(),
                permissionRoleEntity.getServiceCode(), new HashMap<>());
        Map<UUID, Map<String, Boolean>> permission = permissionRole.permission();

        for (Map.Entry<String, Boolean> roleModule : permissionRoleEntity.getPermission().entrySet()) {
            Map<String, Boolean> detailRole = permission.computeIfAbsent(permissionRoleEntity.getModuleCode(), k -> new HashMap<>());
            detailRole.put(roleModule.getKey(), roleModule.getValue());
        }
        return permissionRole;
    }

    List<PermissionRole> toDtos(List<PermissionRoleEntity> permissionRoleEntity);


    default List<PermissionRoleResultDTO> toResponses(List<PermissionRole> res) {
        return res.stream().map(this::toResponse)
                .flatMap(Collection::stream)
                .toList();
    }

    default List<PermissionRoleResultDTO> toResponse(PermissionRole res) {
        return res.permission()
                .entrySet()
                .stream().map(it -> new PermissionRoleResultDTO(it.getKey(), it.getValue()))
                .collect(Collectors.toList());

    }

}