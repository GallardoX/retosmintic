package co.edu.usa.mintic.reto3.service;

import co.edu.usa.mintic.reto3.model.Message;
import co.edu.usa.mintic.reto3.model.Reservation;
import co.edu.usa.mintic.reto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository repository;

    public List<Reservation> findAll() {

        var it = repository.findAll();
        var reservations = new ArrayList<Reservation>();
        it.forEach(reservation -> reservations.add(reservation));
        return reservations;
    }

    public Optional<Reservation> getReservation(int id) {
        return repository.findById(id);
    }

    public Reservation save(Reservation reservation) {

        reservation.setStatus("created");

        if(reservation.getIdReservation() == null) {
            return repository.save(reservation);
        } else {
            Optional<Reservation> result = repository.findById(reservation.getIdReservation());
            if(result.isEmpty()) {
                return repository.save(reservation);
            } else {
                return reservation;
            }
        }
    }
}
