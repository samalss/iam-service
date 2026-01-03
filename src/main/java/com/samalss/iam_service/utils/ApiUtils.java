package com.samalss.iam_service.utils;

import com.samalss.iam_service.model.constants.ApiConstants;

public class ApiUtils{
    public static String getMethodName() {
        try{
            return Thread.currentThread().getStackTrace()[1].getMethodName();
        } catch (Exception cause){
            return ApiConstants.UNDEFINED;
        }
    }
}
