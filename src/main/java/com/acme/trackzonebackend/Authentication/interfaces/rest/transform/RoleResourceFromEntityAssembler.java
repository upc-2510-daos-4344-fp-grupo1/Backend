package com.acme.trackzonebackend.Authentication.interfaces.rest.transform;

import com.acme.trackzonebackend.Authentication.domain.model.entities.Role;
import com.acme.trackzonebackend.Authentication.interfaces.rest.resources.RoleResource;

public class RoleResourceFromEntityAssembler {
    public static RoleResource toResourceFromEntity(Role role) {
        return new RoleResource(role.getId(), role.getStringName());
    }
}
