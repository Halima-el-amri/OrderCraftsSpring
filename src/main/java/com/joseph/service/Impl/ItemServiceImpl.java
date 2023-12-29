package com.joseph.service.Impl;

import com.joseph.service.ItemService;




import com.joseph.entity.Item;
import com.joseph.repository.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService  {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    @Transactional
    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    @Override
    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    @Override
    @Transactional
    public Item getItem(int id) {
        Optional<Item> result = itemRepository.findById((long) id);
        return result.orElse(null);
    }

    @Override
    @Transactional
    public void deleteItem(int id) {
        itemRepository.deleteById((long) id);
    }



    @Override
    @Transactional
    public List<Item> searchItemByName(String name) {
        return itemRepository.searchItemByName(name);
    }


}
