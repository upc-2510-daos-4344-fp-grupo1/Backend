package com.acme.trackzonebackend.Authentication.domain.model.commands;

/**
 * Sign in command
 * <p>
 *     This class represents the command to sign in a user.
 * </p>
 * @param username the username of the user
 * @param password the password of the user
 *
 * @see com.acme.trackzonebackend.Authentication.domain.model.aggregates.User
 */
public record SignInCommand(String username, String password, String email, String firstName, String lastname, String address) {
}
