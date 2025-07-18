package com.acme.trackzonebackend.Authentication.domain.services;

import com.acme.trackzonebackend.Authentication.domain.model.aggregates.User;
import com.acme.trackzonebackend.Authentication.domain.model.queries.GetAllUsersQuery;
import com.acme.trackzonebackend.Authentication.domain.model.queries.GetUserByIdQuery;
import com.acme.trackzonebackend.Authentication.domain.model.queries.GetUserByUsernameQuery;

import java.util.List;
import java.util.Optional;

/**
 * User query service
 * <p>
 *     This interface represents the service to handle user queries.
 * </p>
 */
public interface UserQueryService {
    /**
     * Handle get all users query
     * @param query the {@link GetAllUsersQuery} query
     * @return a list of {@link User} entities
     */
    List<User> handle(GetAllUsersQuery query);

    /**
     * Handle get user by id query
     * @param query the {@link GetUserByIdQuery} query
     * @return an {@link Optional} of {@link User} entity
     */
    Optional<User> handle(GetUserByIdQuery query);

    /**
     * Handle get user by username query
     * @param query the {@link GetUserByUsernameQuery} query
     * @return an {@link Optional} of {@link User} entity
     */
    Optional<User> handle(GetUserByUsernameQuery query);

}
