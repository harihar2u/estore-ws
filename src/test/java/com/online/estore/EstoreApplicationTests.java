package com.online.estore;

import com.online.estore.model.*;
import com.online.estore.repository.ProductDetailRepository;
import com.online.estore.repository.ProductRepository;
import com.online.estore.repository.ProductTypeRepository;
import com.online.estore.repository.SupplierRepository;
import org.h2.util.New;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.image.BufferedImage;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class EstoreApplicationTests {

    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    ProductTypeRepository productTypeRepository;

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductDetailRepository productDetailRepository;


    @Test
    public void contextLoads() {

    }

    @Before
    @Ignore
    public void setup() {

        //Product category
        ProductType productType = new ProductType("Product Type1", true);
        //Product sub Type
        ProductSubType subType1 = new ProductSubType(productType, "SubType1", true);
        ProductSubType subType2 = new ProductSubType(productType, "SubType2", true);
        Collection<ProductSubType> category = new HashSet<ProductSubType>();
        category.add(subType1);
        category.add(subType2);
        //persist
        productType.setSubType(category);
        productTypeRepository.save(productType);

        //Product
        Product product = new Product("Product 1", "description", subType1, true);
        //Product Detail
        Collection<ProductDetail> productDetailList = new ArrayList<ProductDetail>();
        ProductDetail productDetail_1 = new ProductDetail(product, 100f, 10f);
        ProductDetail productDetail_2 = new ProductDetail(product, 200f, 20f);
        productDetailList.add(productDetail_1);
        productDetailList.add(productDetail_2);
        //persist
        product.setProductDetails(productDetailList);
        productRepository.save(product);


        Address address = new Address("Street", "Delhi", "815353");
        Address address1 = new Address("Street1", "Delhi", "815353");
        //Supplier 1
        Supplier supplier = new Supplier("Supplier1", address, true);
        supplierRepository.save(supplier);
        //Supplier 1
        Supplier supplier_2 = new Supplier("Supplier2", address1, true);
        supplierRepository.save(supplier_2);

        //Supplier1 product
        Collection<SupplierProduct> supplierProducts = new ArrayList<>();
        supplierProducts.add(new SupplierProduct(supplier, productDetail_1, 90f, true));
        supplierProducts.add(new SupplierProduct(supplier, productDetail_2, 190f, true));
        supplier.setSupplierProducts(supplierProducts);
        supplierRepository.save(supplier);

        //Supplier2 product
        supplierProducts = new ArrayList<>();
        supplierProducts.add(new SupplierProduct(supplier_2, productDetail_1, 80f, true));
        supplierProducts.add(new SupplierProduct(supplier_2, productDetail_2, 180f, true));
        supplier_2.setSupplierProducts(supplierProducts);
        //add product offer
        ProductOffer offer_1 = new ProductOffer("festival offer", 75f, true);
        //offer_1.setSupplierProduct(((ArrayList<SupplierProduct>) supplierProducts).get(0));
        ((ArrayList<SupplierProduct>) supplierProducts).get(0).setProductOffer(offer_1);

        supplierRepository.save(supplier_2);


    }

    @Test
    @Ignore
    public void testImage(){
        //images
        String imagePath ="D:\\Harihar-Temp\\Project\\estore\\src\\main\\resources\\static\\images\\a1.jpg";
        Image image = new Image(imagePath);
       //Write image
        String encodeBase64String = image.encodeBase64String();
    }


}

