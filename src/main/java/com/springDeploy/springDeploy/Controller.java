package com.springDeploy.springDeploy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@CrossOrigin(origins = "*") // Anpassa efter behov
public class Controller {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping
    public List<Todo> getTodos() {
        try {
            List<Todo> todos = todoRepository.findAll();
            System.out.println("✅ Antal todos i databasen: " + todos.size());
            return todos;
        } catch (Exception e) {
            System.err.println("🔥 FEL vid hämtning av todos:");
            e.printStackTrace(); // <-- detta kommer visa exakt vad som går fel
            return List.of(); // returnera tom lista för att frontend inte ska krascha
        }
    }

    @PostMapping
    public Todo create(@RequestBody Todo todo) {
        return todoRepository.save(todo);
    }

    @PutMapping("/{id}")
    public Todo update(@PathVariable String id, @RequestBody Todo todo) {
        todo.setId(id);
        return todoRepository.save(todo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        todoRepository.deleteById(id);
    }

    @GetMapping("/ping")
    public String ping() {
        System.out.println("🚀 Backend fungerar!");
        return "Backend fungerar!";
    }
}
