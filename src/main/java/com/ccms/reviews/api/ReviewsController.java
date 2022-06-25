package com.ccms.reviews.api;
import com.ccms.reviews.domain.service.ReviewService;
import com.ccms.reviews.mapping.ReviewMapper;
import com.ccms.reviews.resource.CreateReviewResource;
import com.ccms.reviews.resource.ReviewResource;
import com.ccms.reviews.resource.UpdateReviewResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@SecurityRequirement(name = "ccms")
@Tag(name = "Reviews", description = "Create, read, update and delete reviews")
@RestController
@RequestMapping("api/v1/reviews")
public class ReviewsController {
    private final ReviewService reviewService;

    private final ReviewMapper mapper;

    public ReviewsController(ReviewService reviewService, ReviewMapper mapper){
        this.reviewService=reviewService;
        this.mapper=mapper;
    }

    @PreAuthorize("hasRole('USER') or hasRole('OWNER') or hasRole('MUSICIAN')")
    @Operation(summary = "Get reviews", description = "Get All Reviews.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reviews found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ReviewResource.class))})
    })
    @GetMapping
    public Page<ReviewResource> getAllReviews(Pageable pageable) {
        return mapper.modelListPage(reviewService.getAll(), pageable);
    }

    @PreAuthorize("hasRole('USER') or hasRole('OWNER') or hasRole('MUSICIAN')")
    @Operation(summary = "Get Review By Id", description = "Get Review by Id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Review returned",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ReviewResource.class))
            )
    })
    @GetMapping("{reviewId}")
    public ReviewResource getReviewById(@PathVariable Long reviewId) {
        return mapper.toResource(reviewService.getById(reviewId));
    }

    @PreAuthorize("hasRole('USER') or hasRole('OWNER') or hasRole('MUSICIAN')")
    @Operation(summary = "Create Review", description = "Create Review")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Review created",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ReviewResource.class)
                    ))
    })
    @PostMapping
    public ReviewResource createReview(@Valid @RequestBody CreateReviewResource request) {
        return mapper.toResource(reviewService.create(mapper.toModel(request)));
    }


    @PreAuthorize("hasRole('USER') or hasRole('OWNER') or hasRole('MUSICIAN')")
    @Operation(summary = "Update Review", description = "Update Review")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Review updated",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ReviewResource.class)
                    ))
    })
    @PutMapping("{reviewId}")
    public ReviewResource updateReview(@PathVariable Long reviewId, @Valid @RequestBody UpdateReviewResource request) {
        return mapper.toResource(reviewService.update(reviewId, mapper.toModel(request)));
    }

    @PreAuthorize("hasRole('USER') or hasRole('OWNER') or hasRole('MUSICIAN')")
    @Operation(summary = "Delete Review", description = "Delete Review")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Review deleted", content = @Content(mediaType = "application/json"))
    })
    @DeleteMapping("{reviewId}")
    public ResponseEntity<?> deleteReview(@PathVariable Long reviewId) {
        return reviewService.delete(reviewId);
    }
}
