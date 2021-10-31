package co.edu.usa.mintic.reto3.controller;

import co.edu.usa.mintic.reto3.model.Category;
import co.edu.usa.mintic.reto3.model.Client;
import co.edu.usa.mintic.reto3.service.CategoryService;
import co.edu.usa.mintic.reto3.service.ClientService;
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
@RequestMapping("/api/Client")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping("/all")
    public List<Client> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable("id") int id) {
        return service.getClient(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client client) {
        return service.save(client);
    }
}
