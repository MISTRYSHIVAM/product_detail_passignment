package com.example.practical_assignment;

import java.io.Serializable;

public class Product implements Serializable {
    Product(){};

    String pdCategory , pdTitle , pdDescription , pdKeyFeature ;

    public String getPdCategory() {
        return pdCategory;
    }

    public void setPdCategory(String pdCategory) {
        this.pdCategory = pdCategory;
    }

    public String getPdTitle() {
        return pdTitle;
    }

    public void setPdTitle(String pdTitle) {
        this.pdTitle = pdTitle;
    }

    public String getPdDescription() {
        return pdDescription;
    }

    public void setPdDescription(String pdDescription) {
        this.pdDescription = pdDescription;
    }

    public String getPdKeyFeature() {
        return pdKeyFeature;
    }

    public void setPdKeyFeature(String pdKeyFeature) {
        this.pdKeyFeature = pdKeyFeature;
    }
}
