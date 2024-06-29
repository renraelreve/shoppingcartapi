package com.skillsunion.shoppingcartapi;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import com.skillsunion.shoppingcartapi.entities.Catalogue;
import com.skillsunion.shoppingcartapi.repositories.CatalogueRepository;

@Component
public class Dataloader {

  private CatalogueRepository catalogueRepository;

  public Dataloader(CatalogueRepository catalogueRepository) {
    this.catalogueRepository = catalogueRepository;
  }

  @PostConstruct
  public void loadData() {
    catalogueRepository.deleteAll();
    System.out.println("Loading data...");
    catalogueRepository.save(new Catalogue("Apple"));
    System.err.println("Done loading data...");
    catalogueRepository.save(new Catalogue("Banana"));
    catalogueRepository.save(new Catalogue("Orange"));
  }
}
