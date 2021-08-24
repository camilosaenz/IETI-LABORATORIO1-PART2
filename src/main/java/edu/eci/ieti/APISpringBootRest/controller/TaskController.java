package edu.eci.ieti.APISpringBootRest.controller;

import edu.eci.ieti.APISpringBootRest.data.Task;
import edu.eci.ieti.APISpringBootRest.dto.TaskDto;
import edu.eci.ieti.APISpringBootRest.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/v1/task" )
public class TaskController {

    private final TaskService taskService;

    public TaskController(@Autowired TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> all() {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.all());
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<Task> findById( @PathVariable String id ) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Task> create( @RequestBody TaskDto taskDto ) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(taskService.create(new Task(taskDto)));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@RequestBody TaskDto taskDto, @PathVariable String id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(taskService.update(taskDto, id));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete(@PathVariable String id ) {
        try{
            taskService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body((true));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.ordinal()).body((false));
        }
    }

}
