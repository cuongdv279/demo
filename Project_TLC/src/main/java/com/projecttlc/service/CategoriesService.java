package com.projecttlc.service;

import com.projecttlc.dao.CategoriesDAO;
import com.projecttlc.model.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by CHIP_IT_DVC on 24/02/2016.
 */
@Service
public class CategoriesService {

    @Autowired
    CategoriesDAO categoriesDAO;

    public List<Categories> getAllCategories(){
        return categoriesDAO.getAllCategories();
    }
    public List<Categories> getAllCategories(int numPage, int pageOne){
        return  categoriesDAO.getAllCategories(numPage,pageOne);
    }

    public Categories getCategories(int cate_ID){
        return categoriesDAO.getCategories(cate_ID);
    }

    public void saveAndUpdate(Categories categories){
        categoriesDAO.saveAndUpdate(categories);
    }

    public void deleteCategories(int cate_ID){

    }
}
