package com.tableturn.tableturn.service;

import com.tableturn.tableturn.entity.RestaurantTable;
import com.tableturn.tableturn.repository.RestaurantTableRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantTableService {

    private final RestaurantTableRepository restaurantTableRepository;

    public RestaurantTableService(
            RestaurantTableRepository restaurantTableRepository) {

        this.restaurantTableRepository =
                restaurantTableRepository;
    }

    // Get all restaurant tables
    public List<RestaurantTable> getAllTables() {

        return restaurantTableRepository.findAll();
    }

    // Get table by ID
    public RestaurantTable getTableById(Long id) {

        return restaurantTableRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Restaurant table not found with id: " + id
                        )
                );
    }

    // Create new table
    public RestaurantTable createTable(
            RestaurantTable table) {

        if (restaurantTableRepository
                .existsByTableNumber(
                        table.getTableNumber()
                )) {

            throw new RuntimeException(
                    "Table already exists: "
                            + table.getTableNumber()
            );
        }

        return restaurantTableRepository.save(table);
    }

    // Update existing table
    public RestaurantTable updateTable(
            Long id,
            RestaurantTable tableDetails) {

        RestaurantTable existingTable =
                restaurantTableRepository
                        .findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Restaurant table not found with id: "
                                                + id
                                )
                        );

        // Update table number
        existingTable.setTableNumber(
                tableDetails.getTableNumber()
        );

        // Update capacity
        existingTable.setCapacity(
                tableDetails.getCapacity()
        );

        // Update status
        existingTable.setStatus(
                tableDetails.getStatus()
        );

        return restaurantTableRepository.save(
                existingTable
        );
    }

    // Delete table
    public void deleteTable(Long id) {

        RestaurantTable existingTable =
                restaurantTableRepository
                        .findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Restaurant table not found with id: "
                                                + id
                                )
                        );

        restaurantTableRepository.delete(
                existingTable
        );
    }
}