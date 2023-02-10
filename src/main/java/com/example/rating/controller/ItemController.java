package com.example.rating.controller;

import com.example.rating.model.Item;
import com.example.rating.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping(value = "/titles", produces = MediaType.APPLICATION_JSON_UTF8_VALUE) //APPLICATION_JSON_UTF8_VALUE deprecado, ya no es necesario
    public ResponseEntity<List<String>> findItemTitle(){
        return itemService.findItemTitle();
    }

    @GetMapping(value = "/items", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Item>> findItemsWithAverageRatingLowerThan(
            @RequestParam("rating") Double rating
    ){
        return itemService.findItemsWithAverageRatingLowerThan(rating);
    }
}
