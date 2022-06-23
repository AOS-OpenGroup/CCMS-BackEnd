package com.ccms.user.mapping;

import com.ccms.shared.mapping.EnhancedModelMapper;
import com.ccms.user.domain.model.entity.Owner;
import com.ccms.user.resource.UpdateOwnerResource;
import com.ccms.user.resource.OwnerResource;
import com.ccms.user.resource.CreateOwnerResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;


import java.io.Serializable;
import java.util.List;

public class OwnerMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;
    // Object Mapping
    public OwnerResource toResource(Owner model) {
        return mapper.map(model, OwnerResource.class);
    }
    public Page<OwnerResource> modelListPage(List<Owner> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, OwnerResource.class), pageable, modelList.size());
    }

    public Owner toModel(CreateOwnerResource resource) {
        return mapper.map(resource, Owner.class);
    }

    public Owner toModel(UpdateOwnerResource resource) {
        return mapper.map(resource, Owner.class);
    }
}
