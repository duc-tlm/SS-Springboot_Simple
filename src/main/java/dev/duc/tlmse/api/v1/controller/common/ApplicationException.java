package dev.duc.tlmse.api.v1.controller.common;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.ErrorResponse;

@Data
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ApplicationException extends RuntimeException {
    private final ErrorResponse err;
    private final String message;
}
