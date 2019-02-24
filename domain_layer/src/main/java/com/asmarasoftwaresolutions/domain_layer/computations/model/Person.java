package com.asmarasoftwaresolutions.domain_layer.computations.model;

import com.asmarasoftwaresolutions.domain_layer.computations.utils.Constant;

public class Person {
    private String mName;
    private Constant.Country mCountry;

    public Person(String mName, Constant.Country mCountry) {
        this.mName = mName;
        this.mCountry = mCountry;
    }
}
