package com.skillsunion.shoppingcartapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillsunion.shoppingcartapi.entities.Cart;
import com.skillsunion.shoppingcartapi.entities.Catalogue;
import com.skillsunion.shoppingcartapi.repositories.CartRepository;
import com.skillsunion.shoppingcartapi.repositories.CatalogueRepository;

@RestController
@RequestMapping("/carts")
public class CartController {

  private CartRepository cartRepository;
  private CatalogueRepository catalogueRepository;

  public CartController(CartRepository cartRepository, CatalogueRepository catalogueRepository) {
    this.cartRepository = cartRepository;
    this.catalogueRepository = catalogueRepository;
  }

  // ArrayList<Cart> carts = new ArrayList<>();

  @GetMapping("")
  public ArrayList<Cart> getAllRecords() {
    List<Cart> cartList = cartRepository.findAll();
    return (ArrayList<Cart>) cartList;

  }

  @GetMapping("/{id}")
  public Cart getRecord(@PathVariable Integer id) {
    Cart cart = cartRepository.findById(id).get();
    return cart;
  }

  @PostMapping("")
  public Cart createRecord(@RequestBody Map<String, Object> requestBody) {
    // Extract values from the map
    int itemId = (Integer) requestBody.get("itemId");
    int quantity = (Integer) requestBody.get("quantity");

    // Retrieve the Catalogue item from the database
    Catalogue item = catalogueRepository.findById(itemId)
        .orElseThrow(() -> new IllegalArgumentException("Item not found"));

    // Create a new Cart object and set its properties
    Cart cart = new Cart();
    cart.setItem(item);
    cart.setQuantity(quantity);

    // Save the Cart object to the database and return it
    return cartRepository.save(cart);
  }

}
