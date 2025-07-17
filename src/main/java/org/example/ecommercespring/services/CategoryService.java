package org.example.ecommercespring.services;

import org.example.ecommercespring.dto.AllProductsOfCategoryDTO;
import org.example.ecommercespring.dto.CategoryDTO;
import org.example.ecommercespring.dto.ProductDTO;
import org.example.ecommercespring.entity.Category;
import org.example.ecommercespring.mappers.CategoryMapper;
import org.example.ecommercespring.mappers.ProductMapper;
import org.example.ecommercespring.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) throws IOException {
        Category category = CategoryMapper.toEntity(categoryDTO);
        Category saved = categoryRepository.save(category);
        return CategoryMapper.toDto(saved);
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        List<CategoryDTO> dtos = new ArrayList<>();
        for (Category category : categoryRepository.findAll()) {
            dtos.add(CategoryMapper.toDto(category));
        }
        return dtos;
    }

    @Override
    public CategoryDTO getByName(String name) throws Exception {
        Category category = categoryRepository.findByName(name)
                        .orElseThrow(() -> new Exception("Category not found with name :" + name));
        return CategoryMapper.toDto(category);
    }

    public AllProductsOfCategoryDTO getAllProductsOfCategory(long id) throws Exception {
        Category category =categoryRepository.findById(id)
                .orElseThrow(() -> new Exception("Category not found with id :" + id));

        List<ProductDTO> productsDTOs = category.getProducts()
                .stream()
                .map(product -> ProductMapper.toDto(product))
                .collect(Collectors.toList());

        return AllProductsOfCategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .product(productsDTOs)
                .build();
    }
}
