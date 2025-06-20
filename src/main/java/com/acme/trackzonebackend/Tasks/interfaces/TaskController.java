package com.acme.trackzonebackend.Tasks.interfaces;

import com.acme.trackzonebackend.Tasks.domain.models.aggregates.Task;
import com.acme.trackzonebackend.Tasks.domain.models.commands.CreateTaskCommand;
import com.acme.trackzonebackend.Tasks.domain.models.commands.UpdateTaskCommand;
import com.acme.trackzonebackend.Tasks.domain.models.queries.GetTaskByIdQuery;
import com.acme.trackzonebackend.Tasks.domain.services.TaskCommandService;
import com.acme.trackzonebackend.Tasks.domain.services.TaskQueryService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/tasks")
public class TaskController {
    private final TaskQueryService queryService;
    private final TaskCommandService commandService;

    public TaskController(TaskQueryService queryService, TaskCommandService commandService) {
        this.queryService = queryService;
        this.commandService = commandService;
    }

    @PostMapping
    public Task createTask (@RequestBody CreateTaskCommand command) {
        return commandService.createTask(command);
    }

    @PutMapping("/{id}")
    public Task updateTask (@PathVariable Long id, @RequestBody UpdateTaskCommand command) {
        command.setId(id);
        return commandService.updateTask(command);
    }

    @GetMapping("/{id}")
    public Task findTaskById (@PathVariable Long id) {
        return queryService.findTaskById(new GetTaskByIdQuery(id));
    }

    @GetMapping
    public List<Task> findAllTasks () {
        return queryService.findAllTasks();
    }

    @GetMapping("/filter/workerId")
    public List<Task> findByWorkerId(@RequestParam int workerId) {
        return queryService.findByWorkerId(workerId);
    }

    @GetMapping("/filter/groupID")
    public List<Task> findByWorkingGroupId(@RequestParam int workingGroupId) {
        return queryService.findByWorkingGroupId(workingGroupId);
    }

    @GetMapping("/filter/status")
    public List<Task> findByStatus(@RequestParam int status) {
        return queryService.findByStatus(status);
    }

    @GetMapping("/filter/createdDate")
    public List<Task> findByCreatedAt(@RequestParam LocalDateTime createdAt) {
        return queryService.findByCreatedAt(createdAt);
    }

}
