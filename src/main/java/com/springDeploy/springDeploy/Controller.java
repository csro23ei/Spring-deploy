package com.springDeploy.springDeploy;

import com.springDeploy.Todo;

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
    public List<Todo> getAll() {
        return todoRepository.findAll();
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

}
