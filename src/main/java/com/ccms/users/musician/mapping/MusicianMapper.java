package com.ccms.users.musician.mapping;

import com.ccms.users.musician.domain.model.entity.Musician;
import com.ccms.users.musician.resource.CreateMusicianResource;
import com.ccms.users.musician.resource.MusicianResource;
import com.ccms.users.musician.resource.UpdateMusicianResource;
import com.ccms.shared.mapping.EnhancedModelMapper;
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
    public MusicianResource toResource(Musician model) {
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
