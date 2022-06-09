package com.ccms.studio.mapping;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class StudioMapper implements Serializable {

    @Autowired
    // Object Mapping
    public StudioResource toResource(Studio model) {
        return mapper.map(model, StudioResource.class);
    }
    public Page<StudioResource> modelListPage(List<Studio> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, StudioResource.class), pageable, modelList.size());
    }

    public Studio toModel(CreateStudioResource resource) {
        return mapper.map(resource, Studio.class);
    }

    public Studio toModel(UpdateStudioResource resource) {
        return mapper.map(resource, Studio.class);
    }


}
