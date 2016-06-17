package com.projecttlc.dao;

import com.projecttlc.model.App_params;

import java.util.List;

/**
 * Created by CHIP_IT_DVC on 19/02/2016.
 */
public interface AppParamDAO {
    List<App_params> getAllAppParam(int numPage, int pageOne);

    void saveAndUpdate(App_params appParams);

    void deleteAppParams(int par_ID);
}
