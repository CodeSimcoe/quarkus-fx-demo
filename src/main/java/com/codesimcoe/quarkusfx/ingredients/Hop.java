package com.codesimcoe.quarkusfx.ingredients;

import com.codesimcoe.quarkusfx.common.Country;
import org.bson.types.ObjectId;

public class Hop {

  private ObjectId id;
  private String name;
  private float alphaAcids;
  private Country country;

  public ObjectId getId() {
    return this.id;
  }

  public void setId(final ObjectId id) {
    this.id = id;
  }

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
