package com.nihar.cards.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import com.nihar.cards.dto.CardsDto;
import com.nihar.cards.entity.Cards;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CardsMapper extends BaseMapper<Cards, CardsDto> {

}
