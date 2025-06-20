package com.acme.trackzonebackend.Incidents.domain.model.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEvidenceCommand {
    private Long id;
    private String description;
    private String image;
    private LocalDateTime createdAt;
}
