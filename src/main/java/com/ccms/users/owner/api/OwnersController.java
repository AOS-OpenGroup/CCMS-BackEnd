package com.ccms.users.owner.api;
import com.ccms.users.owner.domain.service.OwnerService;
import com.ccms.users.owner.mapping.OwnerMapper;
import com.ccms.users.owner.resource.CreateOwnerResource;
import com.ccms.users.owner.resource.OwnerResource;
import com.ccms.users.owner.resource.UpdateOwnerResource;
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
@Tag(name = "Owners", description = "Create, read, update and delete owners")
@RestController
@RequestMapping("api/v1/owners")
public class OwnersController {

    private final OwnerService ownerService;
    private final OwnerMapper mapper;

    public OwnersController(OwnerService ownerService, OwnerMapper mapper) {
        this.ownerService = ownerService;
        this.mapper = mapper;
    }

    @PreAuthorize("hasRole('USER') or hasRole('OWNER') or hasRole('MUSICIAN')")
    @Operation(summary = "Get owners", description = "Get All Owners")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Owner found",
            content = {@Content(mediaType = "application/json",
            schema = @Schema(implementation = OwnerResource.class))})
    })
    @GetMapping
    public Page<OwnerResource> getAllOwners(Pageable pageable){
        return mapper.modelListPage(ownerService.getAll(), pageable);
    }

    @PreAuthorize("hasRole('USER') or hasRole('OWNER') or hasRole('MUSICIAN')")
    @Operation(summary = "Get Owner By Id", description = "Get Owner by Id")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Owner returned",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = OwnerResource.class))
            )
    })
    @GetMapping("{ownerId}")
    public OwnerResource getOwnerById(@PathVariable Long ownerId){
        return mapper.toResource(ownerService.getById(ownerId));
    }

    @PreAuthorize("hasRole('USER') or hasRole('OWNER') or hasRole('MUSICIAN')")
    @Operation(summary = "Create Owner", description = "Create Owner")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Owner created",
                    content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = OwnerResource.class)
            ))
    })
    @PostMapping
    public OwnerResource createOwner(@Valid @RequestBody CreateOwnerResource request) {
        return mapper.toResource(ownerService.create(mapper.toModel(request)));
    }

    @PreAuthorize("hasRole('USER') or hasRole('OWNER') or hasRole('MUSICIAN')")
    @Operation(summary = "Update Owner", description = "Update Owner")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Owner updated",
                    content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = OwnerResource.class)
            ))
    })
    @PutMapping("{ownerId}")
    public OwnerResource updateOwner(@PathVariable Long ownerId, @Valid @RequestBody UpdateOwnerResource request) {
        return  mapper.toResource(ownerService.update(ownerId, mapper.toModel(request)));
    }

    @PreAuthorize("hasRole('USER') or hasRole('OWNER') or hasRole('MUSICIAN')")
    @Operation(summary = "Delete Owner", description = "Delete Owner")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Owner deleted", content = @Content(mediaType = "application/json"))
    })
    @DeleteMapping("{ownerId}")
    public ResponseEntity<?> deleteOwner(@PathVariable Long ownerId) {
        return ownerService.delete(ownerId);
    }

}
