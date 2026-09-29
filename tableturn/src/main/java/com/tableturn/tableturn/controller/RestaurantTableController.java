package com.tableturn.tableturn.controller;

import com.tableturn.tableturn.entity.RestaurantTable;
import com.tableturn.tableturn.service.RestaurantTableService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tables")
@CrossOrigin(origins = "*")
public class RestaurantTableController {

    private final RestaurantTableService restaurantTableService;

    public RestaurantTableController(
            RestaurantTableService restaurantTableService) {

        this.restaurantTableService = restaurantTableService;
    }

    @GetMapping
    public ResponseEntity<List<RestaurantTable>> getAllTables() {
        return ResponseEntity.ok(
                restaurantTableService.getAllTables()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantTable> getTableById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                restaurantTableService.getTableById(id)
        );
    }

    @PostMapping
    public ResponseEntity<RestaurantTable> createTable(
            @RequestBody RestaurantTable table) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(restaurantTableService.createTable(table));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestaurantTable> updateTable(
            @PathVariable Long id,
            @RequestBody RestaurantTable table) {

        return ResponseEntity.ok(
                restaurantTableService.updateTable(id, table)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTable(
            @PathVariable Long id) {

        restaurantTableService.deleteTable(id);
        return ResponseEntity.noContent().build();
    }
}