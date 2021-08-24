package edu.eci.ieti.APISpringBootRest.service;

import edu.eci.ieti.APISpringBootRest.data.Task;
import edu.eci.ieti.APISpringBootRest.dto.TaskDto;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class TaskServiceHashMap implements TaskService{

    private final HashMap<String, Task> tasksMap = new HashMap();

    @Override
    public Task create(Task task) {
        if (tasksMap.containsKey(task.getId())) {
            throw new RuntimeException("El Usuario Existe!");
        }
        tasksMap.put(task.getId(), task);
        return tasksMap.get(task.getId());
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
        if (!tasksMap.containsKey(id)) {
            throw new RuntimeException("El Usuario no Existe!");
        }
        tasksMap.remove(id);

    }

    @Override
    public Task update(TaskDto task, String id) {
        deleteById(id);
        return create(new Task(task, id));
    }

}
