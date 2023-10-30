package com.codesimcoe.quarkusfx.ingredients;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class HopService {

  public List<Hop> listHops() {
    List<HopEntity> entities = HopEntity.listAll();
    return entities.stream().map(this::mapToDomain).toList();
  }

  public void saveHop(final Hop hop) {
    HopEntity entity = this.mapToEntity(hop);
    entity.persist();
  }

  private Hop mapToDomain(final HopEntity entity) {
    Hop hop = new Hop();
    hop.setId(entity.id);
    hop.setName(entity.getName());
    hop.setAlphaAcids(entity.getAlphaAcids());
    hop.setCountry(entity.getCountry());
    return hop;
  }

  private HopEntity mapToEntity(final Hop hop) {
    HopEntity entity = new HopEntity();
    entity.id = hop.getId();
    entity.setName(hop.getName());
    entity.setAlphaAcids(hop.getAlphaAcids());
    entity.setCountry(hop.getCountry());
    return entity;
  }

  public void deleteHop(final Hop hop) {
    HopEntity.deleteById(hop.getId());
  }
}
