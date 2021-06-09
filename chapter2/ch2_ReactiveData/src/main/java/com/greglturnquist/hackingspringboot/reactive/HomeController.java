package com.greglturnquist.hackingspringboot.reactive;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.result.view.Rendering;
import reactor.core.publisher.Mono;

@Controller
public class HomeController {
    private ItemRepository itemRepository;
    private CartRepository cartRepository;
    private CartService cartService;
    private InventoryService inventoryService;

    public HomeController(ItemRepository itemRepository, CartRepository cartRepository, CartService cartService, InventoryService inventoryService) {
        this.itemRepository = itemRepository;
        this.cartRepository = cartRepository;
        this.cartService = cartService;
        this.inventoryService = inventoryService;
    }

    @GetMapping
    Mono<Rendering> home() {
        System.out.println(this.itemRepository.findAll());
        return Mono.just(Rendering.view("home")
                .modelAttribute("items",
                        this.itemRepository.findAll())
                .modelAttribute("cart",
                        this.cartRepository.findById("My Cart")
                                .defaultIfEmpty(new Cart("My Cart")))
                .build());
    }

    @PostMapping("/add/{id}")
    Mono<String> addToCart(@PathVariable String id) {
        return this.cartService.addToCart("My Cart", id)
                .thenReturn("redirect:/");
    }

    @PostMapping("/create")
    Mono<String> createItem(@ModelAttribute Item newItem) {
        return this.itemRepository.save(newItem).thenReturn("redirect:/");
    }

    @DeleteMapping("/delete/{id}")
    Mono<String> deleteItem(@PathVariable String id) {
        return this.itemRepository.deleteById(id).thenReturn("redirect:/");
    }

    @GetMapping("/search")
    Mono<Rendering> search(@RequestParam(required = false) String name, @RequestParam(required = false) String description, @RequestParam(defaultValue = "false") boolean useAnd) {
        System.out.println(name);
        System.out.println(this.inventoryService.searchByExample(name, description, useAnd));
        return Mono.just(Rendering.view("home")
                .modelAttribute("items", this.inventoryService.searchByExample(name, description, useAnd))
                .build());
    }
}
