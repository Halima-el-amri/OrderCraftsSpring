package com.joseph.web;



import com.joseph.entity.Customer;
import com.joseph.entity.Item;
import com.joseph.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/list")
    public String listItems(Model model) {
        List<Item> items = itemService.getItems();
        model.addAttribute("items", items);
        return "list-items";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model model) {
        Item item = new Item();
        model.addAttribute("item", item);
        return "item-form";
    }

    @PostMapping("/saveItem")
    public String saveItem(@ModelAttribute("item") Item item) {
        itemService.saveItem(item);
        return "redirect:/item/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("itemId") int id, Model model) {
        Item item = itemService.getItem(id);
        model.addAttribute("item", item);
        return "item-form";
    }

    @GetMapping("/delete")
    public String deleteItem(@RequestParam("itemId") int id) {
        itemService.deleteItem(id);
        return "redirect:/item/list";
    }



    @GetMapping("/search")
    public String searchItemByName(@RequestParam("q") String name, Model theModel) {
        List<Item> searchResults = itemService.searchItemByName(name);
        theModel.addAttribute("items", searchResults);
        return "list-items";

    }

}
