package com.acme.trackzonebackend.Authentication.interfaces.rest.resources;

public record SignInResource(String username, String password, String email, String firstName, String lastname, String address) {
}
