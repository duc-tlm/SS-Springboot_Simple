package dev.duc.tlmse.repository.database.module;

import dev.duc.tlmse.repository.database.common.ModuleStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.SQLRestriction;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "modules")
@SQLRestriction("status <> Active")
@FilterDef(name = "isActive", defaultCondition = "")
public class ModuleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @Filter(name = "isActive")
    @Enumerated(EnumType.STRING)
    private ModuleStatus status;

}
