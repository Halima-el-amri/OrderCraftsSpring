package com.joseph.repository;


import com.joseph.entity.Customer;
import com.joseph.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("itemRepository")
public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query("SELECT i FROM Item i WHERE LOWER(i.libelle) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Item> searchItemByName(@Param("name") String name);

}
