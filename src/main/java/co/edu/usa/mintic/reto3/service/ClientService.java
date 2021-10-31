package co.edu.usa.mintic.reto3.service;

import co.edu.usa.mintic.reto3.model.Category;
import co.edu.usa.mintic.reto3.model.Client;
import co.edu.usa.mintic.reto3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public List<Client> findAll() {

        var it = repository.findAll();
        var clients = new ArrayList<Client>();
        it.forEach(client -> clients.add(client));
        return clients;
    }

    public Optional<Client> getClient(int id) {
        return repository.findById(id);
    }

    public Client save(Client client) {
        if(client.getIdClient() == null) {
            return repository.save(client);
        } else {
            Optional<Client> result = repository.findById(client.getIdClient());
            if(result.isEmpty()) {
                return repository.save(client);
            } else {
                return client;
            }
        }
    }
}
