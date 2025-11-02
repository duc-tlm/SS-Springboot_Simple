package dev.duc.tlmse.database.repository;

import dev.duc.tlmse.database.entity.RoleEntity;
import dev.duc.tlmse.database.repository.role.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@DataJpaTest
@Transactional
@AutoConfigureTestDatabase(
        replace = AutoConfigureTestDatabase.Replace.NONE)
public class PermissionRoleRepositoryTest {

    @Autowired
    RoleRepository roleRepository;

    @Test
    void v1() {
        System.out.println("=======RoleRepository==============");
        roleRepository.findAll()
                .forEach(System.out::println);
        System.out.println("=======RoleRepository==============");
    }
}
