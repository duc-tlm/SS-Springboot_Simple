package dev.duc.tlmse.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "module")
public class ModuleEntity {

    @Id
    private UUID id;

    private String name;

}
