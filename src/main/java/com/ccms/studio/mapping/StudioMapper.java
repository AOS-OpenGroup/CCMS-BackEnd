package com.ccms.studio.mapping;

import com.ccms.shared.mapping.EnhancedModelMapper;
import com.ccms.studio.domain.model.entity.Studio;
import com.ccms.studio.resource.CreateStudioResource;
import com.ccms.studio.resource.StudioResource;
import com.ccms.studio.resource.UpdateStudioResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class StudioMapper implements Serializable {

    @Autowired
    private EnhancedModelMapper mapper;
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
