package com.switchfully.selfeval.eurder.domain.user.role;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public enum Role {
    Admin(newArrayList(
            Feature.ADD_AN_ITEM
    )),
    Customer(newArrayList(
            Feature.ORDER_AN_ITEM
    ));
    private List<Feature> featureList;

    Role(List<Feature> featureList) {
        this.featureList = featureList;
    }
    public boolean canAccess(Feature feature){
        return featureList.contains(feature);
    }
}
