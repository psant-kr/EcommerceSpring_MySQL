package org.example.ecommercespring.services;


import org.example.ecommercespring.dto.AllProductsOfCategoryDTO;
import org.example.ecommercespring.dto.CategoryDTO;
import org.example.ecommercespring.gateway.ICategoryGateway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeStoreCategoryService implements ICategoryService {


    private final ICategoryGateway categoryGateway;

    public FakeStoreCategoryService(
            @Qualifier("fakeStoreRestTemplateGateway") ICategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        return this.categoryGateway.getAllCategories();
    }

    public CategoryDTO createCategory(CategoryDTO categoryDTO) throws IOException{
        return null;
    }

    public CategoryDTO getByName(String name) throws IOException {
        return null;
    }

    public AllProductsOfCategoryDTO getAllProductsOfCategory(long id) throws IOException {
        return null;
    }
}
