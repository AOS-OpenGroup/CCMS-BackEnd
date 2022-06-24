package com.ccms.users.musician.api;
import com.ccms.users.musician.domain.service.MusicianService;
import com.ccms.users.musician.mapping.MusicianMapper;
import com.ccms.users.musician.resource.CreateMusicianResource;
import com.ccms.users.musician.resource.MusicianResource;
import com.ccms.users.musician.resource.UpdateMusicianResource;
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

@Tag(name = "Musicians")
@RestController
@RequestMapping("api/v1/musicians")
public class MusiciansController {
    private final MusicianService musicianService;
    private final MusicianMapper mapper;

    public MusiciansController(MusicianService musicianService, MusicianMapper mapper){
        this.musicianService=musicianService;
        this.mapper=mapper;
    }

    @Operation(summary = "Get musicians", description = "Get All Musicians")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Musician found",
                        content = {@Content(mediaType = "application/json",
                        schema = @Schema(implementation = MusicianResource.class))})
    })
    @GetMapping
    public Page<MusicianResource> getAllMusicians(Pageable pageable){
        return mapper.modelListPage(musicianService.getAll(), pageable);
    }

    @Operation(summary = "Get Musician By Id", description = "Get Musician by Id.")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Musician returned",
                        content = @Content(mediaType = "application/json",
                        schema = @Schema(implementation = MusicianResource.class))
            )
    })

    @GetMapping("{musicianId}")
    public MusicianResource getMusicianById(@PathVariable Long musicianId){
        return mapper.toResource(musicianService.getById(musicianId));
    }

    @Operation(summary = "Create Musician", description = "Create Musician")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Musician created",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MusicianResource.class)
                    ))
    })

    @PostMapping
    public MusicianResource createMusician(@Valid @RequestBody CreateMusicianResource request) {
        return mapper.toResource(musicianService.create(mapper.toModel(request)));
    }

    @Operation(summary = "Update Musician", description = "Update Musician")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Musician updated",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MusicianResource.class)
                    ))
    })
    @PutMapping("{musicianId}")
    public MusicianResource updateMusician(@PathVariable Long musicianId, @Valid @RequestBody UpdateMusicianResource request) {
        return mapper.toResource(musicianService.update(musicianId, mapper.toModel(request)));
    }

    @Operation(summary = "Delete Musician", description = "Delete Musician")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Musician deleted", content = @Content(mediaType = "application/json"))
    })
    @DeleteMapping("{musicianId}")
    public ResponseEntity<?> deleteMusician(@PathVariable Long musicianId) {
        return musicianService.delete(musicianId);
    }
}
