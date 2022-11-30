package com.zinabadinov.dto.assembler;

import com.zinabadinov.controller.AmountOfStationController;
import com.zinabadinov.controller.InstalationDateController;
import com.zinabadinov.domain.InstalationDateEntity;
import com.zinabadinov.dto.AmountOfStationDto;
import com.zinabadinov.dto.InstalationDateDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class InstalationDateDtoAssembler implements RepresentationModelAssembler<InstalationDateEntity, InstalationDateDto> {
    @Override
    public InstalationDateDto toModel(InstalationDateEntity entity) {
        InstalationDateDto instalationDateDto = InstalationDateDto.builder()
                .id(entity.getId())
                .insDate(entity.getInsDate())
                .solarStationId(entity.getSolarStationBySolarStationId().getId())
                .build();
        Link selfLink = linkTo(methodOn(InstalationDateController.class).getById(instalationDateDto.getId())).withSelfRel();
        instalationDateDto.add(selfLink);
        return instalationDateDto;
    }

    @Override
    public CollectionModel<InstalationDateDto> toCollectionModel(Iterable<? extends InstalationDateEntity> entities) {
        var item = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(InstalationDateController.class).getContent()).withSelfRel();
        item.add(selfLink);
        return item;
    }
}
