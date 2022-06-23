package com.ccms.security.domain.service.communication;

import com.ccms.security.resource.AuthenticateResource;
import com.ccms.shared.domain.service.communication.BaseResponse;

public class AuthenticateResponse extends BaseResponse<AuthenticateResource> {
    public AuthenticateResponse(String message){
        super(message);
    }

    public AuthenticateResponse(AuthenticateResource resource){
        super(resource);
    }
}
