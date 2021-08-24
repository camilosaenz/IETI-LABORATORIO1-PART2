package edu.eci.ieti.APISpringBootRest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import edu.eci.ieti.APISpringBootRest.Status.Status;
import java.util.Date;

public class TaskDto {

    private String name;
    private String description;
    private String assignedTo;
    @JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dueDate;
    @JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
    private Date created;
    private Status statusTaskDto;

    public TaskDto(String name, String description, String assignedTo, Date dueDate, Date created, Status status) {
        this.name = name;
        this.description = description;
        this.assignedTo = assignedTo;
        this.dueDate = dueDate;
        this.created = created;
        this.statusTaskDto = status;
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
        return statusTaskDto;
    }

    public void setStatus(Status status) {
        this.statusTaskDto = status;
    }
}
