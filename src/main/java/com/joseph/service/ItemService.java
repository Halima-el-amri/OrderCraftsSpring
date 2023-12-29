package com.joseph.service;

import com.joseph.entity.Customer;
import com.joseph.entity.Item;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ItemService {
    @Transactional
    List<Item> getItems();

    @Transactional
    void saveItem(Item item);

    @Transactional
    Item getItem(int id);

    @Transactional
    void deleteItem(int id);


    @Transactional
    List<Item> searchItemByName(String name);
}
