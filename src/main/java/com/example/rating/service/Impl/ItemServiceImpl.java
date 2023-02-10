package com.example.rating.service.Impl;

import com.example.rating.model.Item;
import com.example.rating.model.repository.ItemRepository;
import com.example.rating.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public ResponseEntity<List<Item>> findItemsWithAverageRatingLowerThan(Double rating) {
        return ResponseEntity.ok(itemRepository.findItemsWithAverageRatingLowerThan(rating));
    }

    @Override
    public ResponseEntity<List<String>> findItemTitle() {
        List<String> res = itemRepository.findAll()
                .stream()
                .map(item -> item.getTitle())
                .collect(Collectors.toList());
        return ResponseEntity.ok(res);
    }
}
