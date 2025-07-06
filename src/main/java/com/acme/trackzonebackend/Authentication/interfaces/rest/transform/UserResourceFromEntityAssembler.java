package com.acme.trackzonebackend.Authentication.interfaces.rest.transform;

import com.acme.trackzonebackend.Authentication.domain.model.aggregates.User;
import com.acme.trackzonebackend.Authentication.domain.model.entities.Role;
import com.acme.trackzonebackend.Authentication.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User user) {
        var roles = user.getRoles().stream().map(Role::getStringName).toList();
        return new UserResource(user.getId(), user.getUsername(), roles);
    }
}
