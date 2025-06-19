/**
 * CreateFavoriteSourceCommand
 * @summary
 * CreateFavoriteSourceCommand is a record class that represents the command to create a favorite news source.
 */
package com.acme.trackzonebackend.Payments.domain.model.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentCommand {
    private Integer amount;
    private String paymentTy;
}

