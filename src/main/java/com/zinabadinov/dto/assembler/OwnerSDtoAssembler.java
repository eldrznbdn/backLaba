package com.zinabadinov.dto.assembler;

import com.zinabadinov.controller.AmountOfStationController;
import com.zinabadinov.controller.OwnerSController;
import com.zinabadinov.domain.OwnerSEntity;
import com.zinabadinov.dto.AmountOfStationDto;
import com.zinabadinov.dto.OwnerSDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class OwnerSDtoAssembler implements RepresentationModelAssembler<OwnerSEntity, OwnerSDto> {
    @Override
    public OwnerSDto toModel(OwnerSEntity entity) {
        OwnerSDto ownersdto = OwnerSDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .build();
        Link selfLink = linkTo(methodOn(OwnerSController.class).getById(ownersdto.getId())).withSelfRel();
        ownersdto.add(selfLink);
        return ownersdto;
    }

    @Override
    public CollectionModel<OwnerSDto> toCollectionModel(Iterable<? extends OwnerSEntity> entities) {
        var item = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(OwnerSController.class).getContent()).withSelfRel();
        item.add(selfLink);
        return item;
    }
}
