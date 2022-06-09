package com.ccms.studio.api;


import com.ccms.studio.domain.service.StudioService;
import com.ccms.studio.mapping.StudioMapper;
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

    //add http methods
}
