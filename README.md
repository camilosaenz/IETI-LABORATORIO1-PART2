## Spring Boot Rest API

**Rubian Camilo Saenz Rodriguez**
**IETI - 2021-2**

**Learning Objectives**

- Explain what needs to be donde to achieve the Level 2 on a  RESTFUL API on the Richardson Maturity Model.
- Implement a Level 2 Users RESTFUL API Microservice.
- Implement a Level 2 Tasks RESTFUL API Microservice.
-  User dependencies injections to create a decoupled architecture.


## Growth Mindset 🤹🏽

"Individuals who believe their talents can be developed (through hard work, good strategies, and input from others) have a growth mindset. They tend to achieve more than those with a more fixed mindset (those who believe their talents are innate gifts)" [What Having a "Growth Mindset" Actually means - Harvard Business Review](https://hbr.org/2016/01/what-having-a-growth-mindset-actually-means)  


**Main Topics**
 * Microservices.
 * RESTFUL API.
 * Richardson Maturity Model.
 * Dependencies Injection.

## Codelab 🧪

🗣️ "I hear and I forget I see and I remember I do and I understand." Confucius

### Part 2: Implementing the Tasks Microservice RESTFUL API

1. Create a new project using the [Spring Initializr](https://start.spring.io/)
  * Use either *Java* or *Kotlin* as programming language.
  * Use Gradle as project option(if your computer is slow then use  Maven)
  * Add Spring Web dependency before generating the project.

<img src="https://github.com/camilosaenz/IETI-LABORATORIO1-PART2/blob/main/images/Spring%20initializr.png?raw=true">

2. Create a new repository on Github and commit the files generated in 1.
3. Create a new package called *dto* and inside define your *TaskDto* object with at least the following fields:
    * name.
    * description.
    * status [TODO, DOING, REVIEW and DONE].
    * assignedTo.
    * dueDate.
    * created.
4. Create a new package called *data* and inside define your *Task* data object with at least the following fields:
    * id.
    * name.
    * description.
    * status [TODO, DOING, REVIEW and DONE].
    * assignedTo.
    * dueDate.
    * created.
5. Create a new package called *service* an inside create the following interface:

**Java:**
 ```java
     public interface TaskService
     {
         Task create( Task task );

         Task findById( String id );
         
         List<Task> all();

         void deleteById( String id );

         Task update( Task task, String id );
     }
  ```
  **Kotlin:**
  ```kotlin
      interface TaskService {

         fun create( task: Task): Task

         fun findById( String id ): Task?
         
         fun  all(): List<Task>

         fun deleteById( String id )

         fun update( Task task, String id ): Task

      }
  ```
6. Create an implementation of the TaskService using a HashMap data structure inside.
7. Make your service implementation *TaskServiceHashMap* injectable using the *@Service* annotation.
8. Implement you *TaskController* (try to avoid copy paste, use the User Microservice as reference but try doing it consciously).
9. Test ALL the endpoints of your API using PostMan or any other tool of your preference.

Toda la información sobre las pruebas realizadas en Postman estan en el siguiente enlace: [Postman](https://github.com/camilosaenz/IETI-LABORATORIO1-PART2/blob/main/IETI%20-%20LABORATORIO%201%20-%20PART%202.postman_collection.json)

Se verifica la lista de tareas mediante una solicitud GET.

<img src="https://github.com/camilosaenz/IETI-LABORATORIO1-PART2/blob/main/images/getTask.png?raw=true">

Se crea una tarea mediante el metodo create y una solicitud POST.

<img src="https://github.com/camilosaenz/IETI-LABORATORIO1-PART2/blob/main/images/create.png?raw=true">

Se verifica la creación de la tarea mediante una solicitud GET.

<img src="https://github.com/camilosaenz/IETI-LABORATORIO1-PART2/blob/main/images/getTask-1.png?raw=true">

Se actualiza la información de la tarea mnediante el metodo update y una solicitud PUT.

<img src="https://github.com/camilosaenz/IETI-LABORATORIO1-PART2/blob/main/images/update.png?raw=true">

Se vefica el cambio de la información de la tarea 101 mediante una solicitud GET.

<img src="https://github.com/camilosaenz/IETI-LABORATORIO1-PART2/blob/main/images/getTask-2.png?raw=true">

Se elimina una tarea mediante el metodo delete y una solicitud DELETE.

<img src="https://github.com/camilosaenz/IETI-LABORATORIO1-PART2/blob/main/images/delete.png?raw=true">

Se verifica que la tarea ha sido eliminada mediante una solicitud GET.

<img src="https://github.com/camilosaenz/IETI-LABORATORIO1-PART2/blob/main/images/getTask-3.png?raw=true">
