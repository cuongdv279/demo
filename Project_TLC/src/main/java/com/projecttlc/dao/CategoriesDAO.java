package com.projecttlc.dao;

import com.projecttlc.model.Categories;

import java.util.List;

/**
 * Created by CHIP_IT_DVC on 19/02/2016.
 */
public interface CategoriesDAO {

    List<Categories> getAllCategories();
    List<Categories> getAllCategories(int numPage, int pageOne);

    Categories getCategories(int cate_ID);

    void saveAndUpdate(Categories categories);

    void deleteCategories(int cate_ID);
}
