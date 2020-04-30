package com.sales.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.sales.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
