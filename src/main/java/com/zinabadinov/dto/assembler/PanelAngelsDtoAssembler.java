package com.zinabadinov.dto.assembler;

import com.zinabadinov.controller.AmountOfStationController;
import com.zinabadinov.controller.PanelAngelsController;
import com.zinabadinov.domain.PanelAngelsEntity;
import com.zinabadinov.dto.AmountOfStationDto;
import com.zinabadinov.dto.PanelAngelsDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PanelAngelsDtoAssembler implements RepresentationModelAssembler<PanelAngelsEntity, PanelAngelsDto> {
    @Override
    public PanelAngelsDto toModel(PanelAngelsEntity entity) {
        PanelAngelsDto panelAngelsDto = PanelAngelsDto.builder()
                .id(entity.getId())
                .tilt(entity.getTilt())
                .panelId(entity.getPanelByPanelId().getId())
                .build();
        Link selfLink = linkTo(methodOn(PanelAngelsController.class).getById(panelAngelsDto.getId())).withSelfRel();
        panelAngelsDto.add(selfLink);
        return panelAngelsDto;
    }

    @Override
    public CollectionModel<PanelAngelsDto> toCollectionModel(Iterable<? extends PanelAngelsEntity> entities) {
        var item = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(PanelAngelsController.class).getContent()).withSelfRel();
        item.add(selfLink);
        return item;
    }

}
