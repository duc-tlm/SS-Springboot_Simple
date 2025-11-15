package dev.duc.tlmse.domain.rolepermission;

import dev.duc.tlmse.database.entity.PermissionRoleEntity;
import org.mapstruct.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING)
public interface PermissionRoleMapper {
    PermissionRoleEntity toEntity(PermissionRole permissionRole);


    PermissionRole toDto(PermissionRoleEntity permissionRoleEntity);

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