package com.acme.trackzonebackend.Authentication.interfaces.rest.transform;

import com.acme.trackzonebackend.Authentication.domain.model.aggregates.User;
import com.acme.trackzonebackend.Authentication.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {
    public static AuthenticatedUserResource toResourceFromEntity(User user, String token) {
        return new AuthenticatedUserResource(user.getId(), user.getUsername(), token);
    }
}
