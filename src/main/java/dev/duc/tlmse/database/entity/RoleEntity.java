package dev.duc.tlmse.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.util.UUID;

@Accessors(chain = true)
@Data
@Entity
@Table(name = "roles")
@RequiredArgsConstructor
//@NoArgsConstructor
public class RoleEntity {

    @Id
    private UUID id;
    private String code;

}
