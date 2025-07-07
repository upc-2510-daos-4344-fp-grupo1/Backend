package com.acme.trackzonebackend.Authentication.interfaces.rest.transform;

import com.acme.trackzonebackend.Authentication.domain.model.commands.SignInCommand;
import com.acme.trackzonebackend.Authentication.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource signInResource) {
        return new SignInCommand(signInResource.username(), signInResource.password(), signInResource.email(), signInResource.firstName(), signInResource.lastname(), signInResource.address());
    }
}
