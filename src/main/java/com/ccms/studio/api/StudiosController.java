package com.ccms.studio.api;


import com.ccms.studio.domain.service.StudioService;
import com.ccms.studio.mapping.StudioMapper;
import com.ccms.studio.resource.CreateStudioResource;
import com.ccms.studio.resource.StudioResource;
import com.ccms.studio.resource.UpdateStudioResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Studios")
@RestController
@RequestMapping("api/v1/studios")
public class StudiosController {

    private final StudioService studioService;

    private final StudioMapper mapper;

    public StudiosController(StudioService studioService, StudioMapper mapper) {
        this.studioService = studioService;
        this.mapper = mapper;
    }

    @Operation(summary = "Get studios", description = "Get All Studios.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Studios found",
                        content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = StudioResource.class))})
    })
    @GetMapping
    public Page<StudioResource> getAllStudios(Pageable pageable) {
        return mapper.modelListPage(studioService.getAll(), pageable);
    }

    @Operation(summary = "Get Studio By Id", description = "Get Studio by Id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Studio returned",
                        content = @Content(mediaType = "application/json",
                        schema = @Schema(implementation = StudioResource.class))
            )
    })
    @GetMapping("{studioId}")
    public StudioResource getStudioById(@PathVariable Long studioId) {
        return mapper.toResource(studioService.getById(studioId));
    }

    @Operation(summary = "Create Studio", description = "Create Studio")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Studio created",
                    content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = StudioResource.class)
                    ))
    })
    @PostMapping
    public StudioResource createStudio(@Valid @RequestBody CreateStudioResource request) {
        return mapper.toResource(studioService.create(mapper.toModel(request)));
    }


    @Operation(summary = "Update Studio", description = "Update Studio")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Studio updated",
                    content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = StudioResource.class)
                    ))
    })
    @PutMapping("{studioId}")
    public StudioResource updateStudio(@PathVariable Long studioId, @Valid @RequestBody UpdateStudioResource request) {
        return mapper.toResource(studioService.update(studioId, mapper.toModel(request)));
    }

    @Operation(summary = "Delete Studio", description = "Delete Studio")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Studio deleted", content = @Content(mediaType = "application/json"))
    })
    @DeleteMapping("{studioId}")
    public ResponseEntity<?> deleteStudio(@PathVariable Long studioId) {
        return studioService.delete(studioId);
    }
}
