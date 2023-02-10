package com.example.rating.model.repository;

import com.example.rating.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query(value = "SELECT * FROM (" +
            " SELECT i.id, title, coalesce(avg(r.rating), 0) rating" +
            " FROM items i" +
            " LEFT JOIN reviews r ON i.id = r.item_id" +
            " GROUP BY i.id, i.title" +
            " ) it" +
            " WHERE it.rating < ?1", nativeQuery = true)
    List<Item> findItemsWithAverageRatingLowerThan(Double rating);

}
