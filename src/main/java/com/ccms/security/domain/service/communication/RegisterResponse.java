package com.ccms.security.domain.service.communication;

import com.ccms.security.resource.UserResource;
import com.ccms.shared.domain.service.communication.BaseResponse;

public class RegisterResponse extends BaseResponse<UserResource> {
    public RegisterResponse(String message){
        super(message);
    }

    public RegisterResponse(UserResource resource){
        super(resource);
    }
}
