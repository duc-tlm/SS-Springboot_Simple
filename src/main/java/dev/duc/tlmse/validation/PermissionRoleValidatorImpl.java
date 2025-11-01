package dev.duc.tlmse.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Map;

public class PermissionRoleValidatorImpl implements ConstraintValidator<RoleDetailValidator, Map<String, Boolean>> {

    @Override
    public boolean isValid(
            Map<String, Boolean> role,
            ConstraintValidatorContext constraintValidatorContext) {

        return false;
    }
}
