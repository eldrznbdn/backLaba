package com.zinabadinov.dto.assembler;

import com.zinabadinov.controller.AmountOfStationController;
import com.zinabadinov.domain.AmountOfStationEntity;
import com.zinabadinov.dto.AmountOfStationDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class AmountOfStationDtoAssembler implements RepresentationModelAssembler<AmountOfStationEntity, AmountOfStationDto> {
    @Override
    public AmountOfStationDto toModel(AmountOfStationEntity entity) {
        AmountOfStationDto amountOfStationDto = AmountOfStationDto.builder()
                .id(entity.getId())
                .amount(entity.getAmount())
                .ownerSId(entity.getOwnerSByOwnerSId().getId())
                .build();
        Link selfLink = linkTo(methodOn(AmountOfStationController.class).getById(amountOfStationDto.getId())).withSelfRel();
        amountOfStationDto.add(selfLink);
        return amountOfStationDto;
    }

    @Override
    public CollectionModel<AmountOfStationDto> toCollectionModel(Iterable<? extends AmountOfStationEntity> entities) {
        var item = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(AmountOfStationController.class).getAllAmountOfStation()).withSelfRel();
        item.add(selfLink);
        return item;
    }
}
