package de.seuhd.campuscoffee.api.dtos;

import lombok.Builder;

import java.time.LocalDateTime;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import jakarta.validation.constraints.NotBlank;

/**
 * DTO record for POS metadata.
 */
@Builder(toBuilder = true)
public record ReviewDto (
    @Nullable Long id,
    @Nullable LocalDateTime createdAt, // is null when using DTO to create a new POS
    @Nullable LocalDateTime updatedAt, // is set when creating or updating a POS
    @NonNull Long posId,
    @NonNull Long authorId,
    @NonNull @NotBlank String review
) implements Dto<Long> {
    @Override
    public @Nullable Long getId() {
        return id;
    }
}
