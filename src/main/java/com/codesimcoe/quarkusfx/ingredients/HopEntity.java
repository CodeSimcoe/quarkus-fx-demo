package com.codesimcoe.quarkusfx.ingredients;

import com.codesimcoe.quarkusfx.common.CollectionNames;
import com.codesimcoe.quarkusfx.common.Country;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection = CollectionNames.HOPS)
public class HopEntity extends PanacheMongoEntity {

    private String name;
    private float alphaAcids;
    private Country country;

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public float getAlphaAcids() {
        return this.alphaAcids;
    }

    public void setAlphaAcids(final float alphaAcids) {
        this.alphaAcids = alphaAcids;
    }

    public Country getCountry() {
        return this.country;
    }

    public void setCountry(final Country country) {
        this.country = country;
    }
}