package org.example.ecommercespring.services;

import org.example.ecommercespring.dto.ProductDTO;
import org.example.ecommercespring.dto.ProductWithCategoryDTO;
import org.example.ecommercespring.entity.Category;
import org.example.ecommercespring.entity.Product;
import org.example.ecommercespring.mappers.ProductMapper;
import org.example.ecommercespring.repository.CategoryRepository;
import org.example.ecommercespring.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ProductDTO createProduct(ProductDTO dto) throws Exception {

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new Exception("Category not found"));

        Product response =  productRepository.save(ProductMapper.toEntity(dto, category));
        return ProductMapper.toDto(response);

    }

    public ProductDTO getProductById(Long id) throws Exception{
//        return productRepository.findById(id)
//                .map(ProductMapper::toDto)
//                .orElseThrow(() -> new Exception("Product not found"));

        Product response = productRepository.findById(id)
                .orElseThrow(() -> new Exception("Product not found"));
        return ProductMapper.toDto(response);
    }
    @Override
    public ProductWithCategoryDTO getProductWithCategory(Long id) throws Exception{
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new Exception("Product not found"));
        return ProductMapper.toProductWithCategoryDTO(product);
    }
}
