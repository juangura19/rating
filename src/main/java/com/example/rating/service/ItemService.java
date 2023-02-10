package com.example.rating.service;

import com.example.rating.model.Item;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ItemService {

    ResponseEntity<List<Item>> findItemsWithAverageRatingLowerThan(Double rating);

    ResponseEntity<List<String>> findItemTitle();

}
