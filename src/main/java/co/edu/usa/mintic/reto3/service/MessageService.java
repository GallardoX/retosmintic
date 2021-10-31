package co.edu.usa.mintic.reto3.service;

import co.edu.usa.mintic.reto3.model.Game;
import co.edu.usa.mintic.reto3.model.Message;
import co.edu.usa.mintic.reto3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MessageService {

    @Autowired
    private MessageRepository repository;

    public List<Message> findAll() {

        var it = repository.findAll();
        var messages = new ArrayList<Message>();
        it.forEach(message -> messages.add(message));
        return messages;
    }

    public Optional<Message> getMessage(int id) {
        return repository.findById(id);
    }

    public Message save(Message message) {
        if(message.getIdMessage() == null) {
            return repository.save(message);
        } else {
            Optional<Message> result = repository.findById(message.getIdMessage());
            if(result.isEmpty()) {
                return repository.save(message);
            } else {
                return message;
            }
        }
    }
}
