package com.nihar.loans.mapper;

import org.mapstruct.MappingTarget;

public interface BaseMapper<E, D> {
  D toDto(E entity);

  E toEntity(D dto);

  void updateDto(E entity, @MappingTarget D dto);

  void updateEntity(D dto, @MappingTarget E Entity);
}
