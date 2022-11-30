package com.zinabadinov.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;


@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(itemRelation = "amountOfStation",collectionRelation = "StationsAmount")
public class AmountOfStationDto extends RepresentationModel<AmountOfStationDto> {
    private final Integer id;
    private final Integer amount;
    private final Integer ownerSId;

}
