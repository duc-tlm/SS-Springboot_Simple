package dev.duc.tlmse.api.v1.controller.permissionrole;


import dev.duc.tlmse.api.v1.controller.common.ApiResponse;
import dev.duc.tlmse.domain.rolepermission.PermissionRoleResultDTO;
import dev.duc.tlmse.domain.rolepermission.PermissionRoleUseCase;
import dev.duc.tlmse.domain.rolepermission.RoleRequestDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/permissionrole")
@RequiredArgsConstructor
public class PermissionRoleV1Controller {

    private final PermissionRoleUseCase permissionRoleUseCase;

    @GetMapping("/list")
    public ApiResponse<?> listRoles(@RequestBody @Valid RoleRequestDTO requestDTO) {

        List<PermissionRoleResultDTO> res = permissionRoleUseCase.getDataFromRoleCode(requestDTO);
        return ApiResponse.success("Success with data",res);
    }


}
