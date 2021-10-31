package co.edu.usa.mintic.reto3.service;

import co.edu.usa.mintic.reto3.model.Client;
import co.edu.usa.mintic.reto3.model.Game;
import co.edu.usa.mintic.reto3.repository.GameRepository;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class GameService {

    @Autowired
    private GameRepository repository;

    public List<Game> findAll() {

        var it = repository.findAll();
        var games = new ArrayList<Game>();
        it.forEach(game -> games.add(game));
        return games;
    }

    public Optional<Game> getGame(int id) {
        return repository.findById(id);
    }

    public Game save(Game game) {
        if(game.getId() == null) {
            return repository.save(game);
        } else {
            Optional<Game> result = repository.findById(game.getId());
            if(result.isEmpty()) {
                return repository.save(game);
            } else {
                return game;
            }
        }
    }
}
