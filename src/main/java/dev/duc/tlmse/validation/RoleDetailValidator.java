package dev.duc.tlmse.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
@Constraint(validatedBy = PermissionRoleValidatorImpl.class)
public @interface RoleDetailValidator {
    String message() default "{dev.duc.tlmse.validation.RoleDetailValidator.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
