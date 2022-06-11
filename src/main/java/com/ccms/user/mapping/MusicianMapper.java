package com.ccms.user.mapping;

import com.ccms.user.domain.model.entity.Musician;
import com.ccms.user.resource.CreateMusicianResource;
import com.ccms.user.resource.MusicianResource;
import com.ccms.user.resource.UpdateMusicianResource;
import com.ccms.shared.mapping.EnhancedModelMapper;
import com.ccms.studio.domain.model.entity.Studio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class MusicianMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;
    // Object Mapping
    public MusicianResource toResource(Studio model) {
        return mapper.map(model, MusicianResource.class);
    }
    public Page<MusicianResource> modelListPage(List<Musician> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, MusicianResource.class), pageable, modelList.size());
    }

    public Musician toModel(CreateMusicianResource resource) {
        return mapper.map(resource, Musician.class);
    }

    public Musician toModel(UpdateMusicianResource resource) {
        return mapper.map(resource, Musician.class);
    }
}
