package com.ccms.security.domain.service.communication;

import com.ccms.shared.domain.service.communication.BaseResponse;

public class AuthenticateResponse extends BaseResponse<AuthenticateRequest> {
    public AuthenticateResponse(String message){
        super(message);
    }

    public AuthenticateResponse(AuthenticateRequest resource){
        super(resource);
    }
}
