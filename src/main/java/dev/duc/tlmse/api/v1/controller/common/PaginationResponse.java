package dev.duc.tlmse.api.v1.controller.common;

public record PaginationResponse(
        int page, int size, long totalElelemt,
        int totalPage, boolean isLast, boolean isFirst) {
}
