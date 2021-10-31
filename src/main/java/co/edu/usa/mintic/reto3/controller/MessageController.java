package co.edu.usa.mintic.reto3.controller;

import co.edu.usa.mintic.reto3.model.Client;
import co.edu.usa.mintic.reto3.model.Message;
import co.edu.usa.mintic.reto3.service.ClientService;
import co.edu.usa.mintic.reto3.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/Message")
public class MessageController {

    @Autowired
    private MessageService service;

    @GetMapping("/all")
    public List<Message> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Message> getMessage(@PathVariable("id") int id) {
        return service.getMessage(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message message) {
        return service.save(message);
    }
}
