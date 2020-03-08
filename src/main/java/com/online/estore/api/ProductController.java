package com.online.estore.api;

import com.online.estore.model.Product;
import com.online.estore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(produces = "application/json")
    public ResponseEntity<Page<Product>> getProducts(Pageable pageable) {
        Page<Product> products = productRepository.findAll(pageable);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

//    @GetMapping(produces = "application/json")
//    public ResponseEntity<Product> getProduct(@PathVariable Long productId) {
//        Optional product = productRepository.findById(productId);
//        if (product.isPresent()) {
//            return new ResponseEntity(product, HttpStatus.OK);
//        } else {
//            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
//        }
//    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        productRepository.save(product);

        return ResponseEntity.accepted().body(product);
    }

}
