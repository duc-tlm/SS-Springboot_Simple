package dev.duc.tlmse.database.repository.rolepermission;

import dev.duc.tlmse.database.entity.PermissionRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RolePermissionRepository extends JpaRepository<PermissionRoleEntity, UUID> {
}
