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


    private UUID roleId;

    private UUID serviceId;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private Map<String, Boolean> permission;
}
