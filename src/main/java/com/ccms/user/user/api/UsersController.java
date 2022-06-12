package com.ccms.user.user.api;


import com.ccms.user.user.domain.service.UserService;
import com.ccms.user.user.mapping.UserMapper;
import com.ccms.user.user.resource.CreateUserResource;
import com.ccms.user.user.resource.UpdateUserResource;
import com.ccms.user.user.resource.UserResource;
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

@Tag(name = "Users")
@RestController
@RequestMapping("api/v1/users")
public class UsersController {
    private final UserService userService;
    private final UserMapper mapper;

    public UsersController(UserService userService,UserMapper mapper){
        this.userService=userService;
        this.mapper=mapper;
    }
    @Operation(summary = "Get users", description = "Get All Users")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "User found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResource.class))})
    })
    @GetMapping
    public Page<UserResource> getAllUsers(Pageable pageable){
        return mapper.modelListPage(userService.getAll(), pageable);
    }
    @Operation(summary = "Get User By Id", description = "Get User by Id.")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "User returned",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResource.class))
            )
    })

    @GetMapping("{userId}")
    public UserResource getUserById(@PathVariable Long userId){
        return mapper.toResource(userService.getById(userId));
    }

    @Operation(summary = "Create User", description = "Create User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User created",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResource.class)
                    ))
    })

    @PostMapping
    public UserResource createUser(@Valid @RequestBody CreateUserResource request) {
        return mapper.toResource(userService.create(mapper.toModel(request)));
    }

    @Operation(summary = "Update User", description = "Update User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User updated",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResource.class)
                    ))
    })
    @PutMapping("{userId}")
    public UserResource updateUser(@PathVariable Long userId, @Valid @RequestBody UpdateUserResource request) {
        return mapper.toResource(userService.update(userId, mapper.toModel(request)));
    }

    @Operation(summary = "Delete User", description = "Delete User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User deleted", content = @Content(mediaType = "application/json"))
    })
    @DeleteMapping("{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        return userService.delete(userId);
    }
}
