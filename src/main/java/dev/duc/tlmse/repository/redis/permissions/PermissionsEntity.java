package dev.duc.tlmse.repository.redis.permissions;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.experimental.Accessors;
import org.springframework.data.redis.core.RedisHash;

import java.util.Map;
import java.util.UUID;

@Builder
@Accessors(chain = true)
@RedisHash(value = "permission", timeToLive = 60)
public record PermissionsEntity (@Id UUID id, UUID module, Map<String, Boolean> permissions) {
}
