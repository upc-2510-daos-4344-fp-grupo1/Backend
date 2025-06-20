package com.acme.trackzonebackend.Incidents.interfaces;

import com.acme.trackzonebackend.Incidents.domain.model.aggregates.Evidence;
import com.acme.trackzonebackend.Incidents.domain.model.commands.CreateEvidenceCommand;
import com.acme.trackzonebackend.Incidents.domain.model.commands.UpdateEvidenceCommand;
import com.acme.trackzonebackend.Incidents.domain.model.queries.GetEvidenceByIdQuery;
import com.acme.trackzonebackend.Incidents.domain.services.EvidenceCommandService;
import com.acme.trackzonebackend.Incidents.domain.services.EvidenceQueryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/evidences")
public class EvidenceController {
    private final EvidenceCommandService commandService;
    private final EvidenceQueryService queryService;

    public EvidenceController(EvidenceCommandService commandService, EvidenceQueryService queryService) {
        this.commandService = commandService;
        this.queryService = queryService;
    }

    @PostMapping
    public Evidence create(@RequestBody CreateEvidenceCommand command) {
        return commandService.createEvidence(command);
    }

    @PutMapping("/{id}")
    public Evidence update(@PathVariable Long id, @RequestBody UpdateEvidenceCommand command) {
        command.setId(id);
        return commandService.updateEvidence(command);
    }

    @GetMapping("/{id}")
    public Evidence getById(@PathVariable long id) {
        return queryService.getEvidenceById(new GetEvidenceByIdQuery(id));
    }

    @GetMapping
    public List<Evidence> getAllEvidences() {
        return queryService.getAllEvidences();
    }
}
