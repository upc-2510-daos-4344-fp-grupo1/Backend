package com.acme.trackzonebackend.Authentication.domain.model.queries;

import com.acme.trackzonebackend.Authentication.domain.model.valueobjects.Roles;

/**
 * Get role by name query
 * <p>
 *     This class represents the query to get a role by its name.
 * </p>
 * @param name the name of the role
 * @see com.acme.trackzonebackend.Authentication.domain.model.valueobjects.Roles
 */
public record GetRoleByNameQuery(Roles name) {
}
