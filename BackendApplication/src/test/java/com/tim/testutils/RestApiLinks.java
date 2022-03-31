package com.tim.testutils;

public abstract class RestApiLinks {
    public static String API_LINK = "/api";
    public static String jobApiLink(int jobId) {
        return  API_LINK + "/jobid/" + jobId;
    }

    public static String productApiLink(int productId) {
        return  API_LINK + "/product/" + productId;
    }
}
