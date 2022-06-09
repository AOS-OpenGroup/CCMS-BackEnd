package com.ccms.studio.api;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/studios")
public class StudiosController {

    private final StudioService studioService;

    private final StudioMapper mapper;

    public StudentsController(StudioService studioService, StudioMapper mapper) {
        this.studioService = studioService;
        this.mapper = mapper;
    }
}
