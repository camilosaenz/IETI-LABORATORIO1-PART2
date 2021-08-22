package edu.eci.ieti.APISpringBootRest.service;

import edu.eci.ieti.APISpringBootRest.data.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class TaskServiceHashMap implements TaskService{

    private final HashMap<String, Task> tasksMap = new HashMap();

    @Override
    public Task create(Task task) {
        return tasksMap.put(task.getId(), task);
    }

    @Override
    public Task findById(String id) {
        Task task = tasksMap.get(id);
        return task;
    }

    @Override
    public List<Task> all() {
        return new ArrayList<>(tasksMap.values());
    }

    @Override
    public void deleteById(String id) {
        tasksMap.remove(id);
    }

    @Override
    public Task update(Task task, String id) {
        return tasksMap.put(id, task);
    }
}
