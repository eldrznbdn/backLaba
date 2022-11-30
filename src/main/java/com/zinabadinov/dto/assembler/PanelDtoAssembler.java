package com.zinabadinov.dto.assembler;

import com.zinabadinov.controller.AmountOfStationController;
import com.zinabadinov.controller.PanelController;
import com.zinabadinov.domain.PanelEntity;
import com.zinabadinov.dto.AmountOfStationDto;
import com.zinabadinov.dto.PanelDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PanelDtoAssembler implements RepresentationModelAssembler<PanelEntity, PanelDto> {

    @Override
    public PanelDto toModel(PanelEntity entity) {
        PanelDto panelDto = PanelDto.builder()
                .id(entity.getId())
                .amountOfPanel(entity.getAmountOfPanel())
                .solarStationId(entity.getSolarStationBySolarStationId().getId())
                .build();
        Link selfLink = linkTo(methodOn(PanelController.class).getById(panelDto.getId())).withSelfRel();
        panelDto.add(selfLink);
        return panelDto;
    }
    @Override
    public CollectionModel<PanelDto> toCollectionModel(Iterable<? extends PanelEntity> entities) {
        var item = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(PanelController.class).getContent()).withSelfRel();
        item.add(selfLink);
        return item;
    }
}
