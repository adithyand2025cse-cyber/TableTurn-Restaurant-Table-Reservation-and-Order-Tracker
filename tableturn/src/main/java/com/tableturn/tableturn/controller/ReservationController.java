package com.tableturn.tableturn.controller;

import com.tableturn.tableturn.entity.Reservation;
import com.tableturn.tableturn.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@CrossOrigin(origins = "*")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        return ResponseEntity.ok(
                reservationService.getAllReservations()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                reservationService.getReservationById(id)
        );
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<Reservation>> getReservationsByDate(
            @PathVariable String date) {

        LocalDate reservationDate = LocalDate.parse(date);

        return ResponseEntity.ok(
                reservationService.getReservationsByDate(reservationDate)
        );
    }

    @GetMapping("/table/{tableId}")
    public ResponseEntity<List<Reservation>> getReservationsByTable(
            @PathVariable Long tableId) {

        return ResponseEntity.ok(
                reservationService.getReservationsByTable(tableId)
        );
    }

    @PostMapping
    public ResponseEntity<Reservation> createReservation(
            @RequestBody Reservation reservation) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(reservationService.createReservation(reservation));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(
            @PathVariable Long id,
            @RequestBody Reservation reservation) {

        return ResponseEntity.ok(
                reservationService.updateReservation(id, reservation)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(
            @PathVariable Long id) {

        reservationService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }
}