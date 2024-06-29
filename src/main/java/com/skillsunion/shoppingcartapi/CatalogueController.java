package com.skillsunion.shoppingcartapi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillsunion.shoppingcartapi.entities.Catalogue;
import com.skillsunion.shoppingcartapi.repositories.CatalogueRepository;

@RestController
@RequestMapping("/catalogues")
public class CatalogueController {
  private CatalogueRepository catalogueRepository;

  public CatalogueController(CatalogueRepository catalogueRepository) {
    this.catalogueRepository = catalogueRepository;
  }

  @GetMapping("")
  public ArrayList<Catalogue> getAllRecords() {
    List<Catalogue> catalogueList = catalogueRepository.findAll();
    return (ArrayList<Catalogue>) catalogueList;
  }

}
