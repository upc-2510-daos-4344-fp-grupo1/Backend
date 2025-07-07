package com.acme.trackzonebackend.Authentication.domain.model.commands;

import com.acme.trackzonebackend.Authentication.domain.model.entities.Role;

import java.util.List;

/**
 * Sign up command
 * <p>
 *     This class represents the command to sign up a user.
 * </p>
 * @param username the username of the user
 * @param password the password of the user
 * @param roles the roles of the user
 *
 * @see com.acme.trackzonebackend.Authentication.domain.model.aggregates.User
 */
public record SignUpCommand(String username, String password ,List<Role> roles) {
}
