package com.zinabadinov.dto.assembler;

import com.zinabadinov.controller.AmountOfStationController;
import com.zinabadinov.controller.SolarStationController;
import com.zinabadinov.domain.SolarStationEntity;
import com.zinabadinov.dto.AmountOfStationDto;
import com.zinabadinov.dto.SolarStationDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class SolarStationDtoAssembler implements RepresentationModelAssembler<SolarStationEntity, SolarStationDto> {
    @Override
    public SolarStationDto toModel(SolarStationEntity entity) {
        SolarStationDto solarStationDto = SolarStationDto.builder()
                .id(entity.getId())
                .capacity(entity.getCapacity())
                .country(entity.getCountry())
                .typeStation(entity.getTypeStation())
                .build();
        Link selfLink = linkTo(methodOn(SolarStationController.class).getById(solarStationDto.getId())).withSelfRel();
        solarStationDto.add(selfLink);
        return solarStationDto;
    }

    @Override
    public CollectionModel<SolarStationDto> toCollectionModel(Iterable<? extends SolarStationEntity> entities) {
        var item = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(SolarStationController.class).getContent()).withSelfRel();
        item.add(selfLink);
        return item;
    }

}
