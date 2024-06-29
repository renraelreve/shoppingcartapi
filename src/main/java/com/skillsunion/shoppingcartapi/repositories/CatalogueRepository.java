package com.skillsunion.shoppingcartapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillsunion.shoppingcartapi.entities.Catalogue;

public interface CatalogueRepository extends JpaRepository<Catalogue, Integer> {

}
