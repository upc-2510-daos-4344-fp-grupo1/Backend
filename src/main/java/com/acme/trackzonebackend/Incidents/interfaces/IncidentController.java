package com.acme.trackzonebackend.Incidents.interfaces;

import com.acme.trackzonebackend.Incidents.domain.model.aggregates.Incident;
import com.acme.trackzonebackend.Incidents.domain.model.commands.CreateIncidentCommand;
import com.acme.trackzonebackend.Incidents.domain.model.commands.UpdateIncidentCommand;
import com.acme.trackzonebackend.Incidents.domain.model.queries.GetIncidentByIdQuery;
import com.acme.trackzonebackend.Incidents.domain.services.IncidentCommandService;
import com.acme.trackzonebackend.Incidents.domain.services.IncidentQueryService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/incidents")
public class IncidentController {
    private final IncidentQueryService queryService;
    private final IncidentCommandService commandService;

    public IncidentController(IncidentQueryService queryService, IncidentCommandService commandService) {
        this.queryService = queryService;
        this.commandService = commandService;
    }

    @PostMapping
    public Incident create(@RequestBody CreateIncidentCommand command) {
        return commandService.createIncident(command);
    }

    @PutMapping("/{id}")
    public Incident update(@PathVariable long id, @RequestBody UpdateIncidentCommand command) {
        command.setId(id);
        return commandService.updateIncident(command);
    }

    @GetMapping("/{id}")
    public Incident getById(@PathVariable long id) {
        return queryService.getById(new GetIncidentByIdQuery(id));
    }

    @GetMapping("/all")
    public List<Incident> getAllIncidents() {
        return queryService.getAllIncidents();
    }

    @GetMapping("/filter/date")
    public List<Incident> filterByDate(@RequestParam @DateTimeFormat LocalDateTime start, @RequestParam @DateTimeFormat LocalDateTime end) {
        return queryService.filterByStartDateBetween(start, end);
    }

    @GetMapping("/filter/group")
    public List<Incident> filterByWorkingGroupId(@RequestParam long groupId) {
        return queryService.filterByWorkingGroupId(groupId);
    }

    @GetMapping("/filter/status")
    public List<Incident> filterByResolved(@RequestParam boolean resolved) {
        return queryService.filterByResolved(resolved);
    }

}
