package com.tableturn.tableturn.repository;

import com.tableturn.tableturn.entity.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantTableRepository
        extends JpaRepository<RestaurantTable, Long> {

    boolean existsByTableNumber(int tableNumber);
}