package com.skillsunion.shoppingcartapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

  @GetMapping("/carts")
  public String list() {
    return "GET /carts ok";
  }

  @GetMapping("/carts/{id}")
  public String get(@PathVariable int id) {
    return "GET /carts/" + id + " ok";
  }

  @PostMapping("/carts")
  public String create() {
    return "POST /carts ok";
  }

}
