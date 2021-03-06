package edu.eci.ieti.APISpringBootRest.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import edu.eci.ieti.APISpringBootRest.Status.Status;
import edu.eci.ieti.APISpringBootRest.dto.TaskDto;
import java.util.Date;
import java.util.UUID;

public class Task {

    private String id;
    private String name;
    private String description;
    private String assignedTo;
    @JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dueDate;
    @JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd")
    private Date created;
    private Status status;

    public Task(String id, String name, String description, String assignedTo, Date dueDate, Date created, Status status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.assignedTo = assignedTo;
        this.dueDate = dueDate;
        this.created = created;
        this.status = status;
    }

    public Task(TaskDto taskDto) {
        this.id = UUID.randomUUID().toString();
        this.name = taskDto.getName();
        this.description = taskDto.getDescription();
        this.status = taskDto.getStatus();
        this.assignedTo = taskDto.getAssignedTo();
        this.dueDate = taskDto.getDueDate();
        this.created = new Date();
    }

    public Task(TaskDto taskDto, String id) {
        this.id =  id;
        this.name = taskDto.getName();
        this.description = taskDto.getDescription();
        this.status = taskDto.getStatus();
        this.assignedTo = taskDto.getAssignedTo();
        this.dueDate = taskDto.getDueDate();
        this.created = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}