package com.nihar.accounts.mapper;

public interface BaseMapper<E, D> {
	D toDto(E entity);
	E toEntity(D dto);
}
