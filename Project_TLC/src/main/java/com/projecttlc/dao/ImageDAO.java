package com.projecttlc.dao;

import com.projecttlc.model.Images;

import java.util.List;

/**
 * Created by CHIP_IT_DVC on 19/02/2016.
 */
public interface ImageDAO {

    List<Images> getAllImage(int numPage, int pageOne);

    void saveAndUpdate(Images images);

     void deleteImage(int Image_ID);
}

