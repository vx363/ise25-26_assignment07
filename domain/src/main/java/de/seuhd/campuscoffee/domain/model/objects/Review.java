package de.seuhd.campuscoffee.domain.model.objects;

import lombok.Builder;

import java.time.LocalDateTime;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import jakarta.validation.constraints.NotBlank;

/**
 * Domain record that stores a review for a point of sale.
 * Reviews are approved once they received a configurable number of approvals.
 */
@Builder(toBuilder = true)
public record Review(
        @Nullable Long id, // null when the review has not been created yet
        @Nullable LocalDateTime createdAt, // set on Review 
        //creation
        @Nullable LocalDateTime updatedAt, // set on Review creation and update
        @NonNull Pos pos,
        @NonNull User author,
        @NonNull @NotBlank String review,
        @NonNull Integer approvalCount, // is updated by the domain module
        @NonNull Boolean approved // is determined by the domain module
) implements DomainModel<Long> {
    @Override
    public Long getId() {
        return id;
    }
}