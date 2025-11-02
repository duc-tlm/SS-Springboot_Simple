package dev.duc.tlmse.database.entity;


import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Type;

import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "role_permission")
public class PermissionRoleEntity {
    @Id
    private UUID id;

    @Column(name = "roles_id")
    private UUID roleId;

    @Column(name = "module_code")
    private UUID moduleCode;

    @Column(name = "service_code", length = 50)
    private String serviceCode;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private Map<String, Boolean> permission;
}
