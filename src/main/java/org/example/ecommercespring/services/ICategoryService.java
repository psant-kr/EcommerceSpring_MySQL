package org.example.ecommercespring.services;

import org.example.ecommercespring.dto.AllProductsOfCategoryDTO;
import org.example.ecommercespring.dto.CategoryDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryService {

    List<CategoryDTO> getAllCategories() throws IOException;

    CategoryDTO createCategory(CategoryDTO categoryDTO) throws IOException;

    CategoryDTO getByName(String name) throws Exception;

    AllProductsOfCategoryDTO getAllProductsOfCategory(long id) throws Exception;

}
