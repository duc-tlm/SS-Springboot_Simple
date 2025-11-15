package dev.duc.tlmse.database.repository.rolepermission;

import dev.duc.tlmse.database.entity.PermissionRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RolePermissionRepository extends JpaRepository<PermissionRoleEntity, UUID> {

    @Query("""
        SELECT p
        FROM PermissionRoleEntity p
             JOIN RoleEntity  r on r.id = p.roleId 
        WHERE r.code = :code            
    """)
    List<PermissionRoleEntity> findAllByRoleName(@Param("code") String role);
}
