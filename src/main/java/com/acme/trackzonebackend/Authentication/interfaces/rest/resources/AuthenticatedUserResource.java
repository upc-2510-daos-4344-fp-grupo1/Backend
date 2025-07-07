package com.acme.trackzonebackend.Authentication.interfaces.rest.resources;

public record AuthenticatedUserResource(Long id, String username, String token) {

}
