package co.edu.usa.mintic.reto3.repository;

import co.edu.usa.mintic.reto3.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Integer> {
}
