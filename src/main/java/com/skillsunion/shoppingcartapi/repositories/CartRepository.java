package com.skillsunion.shoppingcartapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillsunion.shoppingcartapi.entities.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
