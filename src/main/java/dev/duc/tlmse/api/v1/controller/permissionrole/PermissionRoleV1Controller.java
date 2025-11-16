package dev.duc.tlmse.api.v1.controller.permissionrole;


import dev.duc.tlmse.api.v1.controller.common.ApiResponse;
import dev.duc.tlmse.domain.rolepermission.PermissionRole;
import dev.duc.tlmse.domain.rolepermission.PermissionRoleMapper;
import dev.duc.tlmse.domain.rolepermission.PermissionRoleResultDTO;
import dev.duc.tlmse.domain.rolepermission.PermissionRoleUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/permissionrole")
@RequiredArgsConstructor
public class PermissionRoleV1Controller {

    private final PermissionRoleUseCase permissionRoleUseCase;
    private final PermissionRoleMapper permissionRoleMapper;

    @GetMapping("/list")
    public ApiResponse<?> permissions(@RequestParam("role") String roleName) {

        List<PermissionRole> res = permissionRoleUseCase.getDataFromRoleCode(roleName);
        List<PermissionRoleResultDTO> responses = this.permissionRoleMapper.toResponses(res);

        return ApiResponse.success("Success with data",responses);
    }

    @GetMapping("/search")
    public ApiResponse<?> permissions(@RequestParam("role") UUID roleId) {
        return ApiResponse.success("Success with data", permissionRoleUseCase.getDateFromCache(roleId));
    }


}
