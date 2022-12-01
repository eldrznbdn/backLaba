package com.zinabadinov.domain;

import lombok.Data;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Data
@Entity
@Table(name = "sold_energy", schema = "db_jdbclaba4", catalog = "")
public class SoldEnergyEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "amount_of_sold_energy")
    private Integer amountOfSoldEnergy;

    @ManyToOne
    @JoinColumn(name = "solar_station_id", referencedColumnName = "id", nullable = false)
    private SolarStationEntity solarStationBySolarStationId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmountOfSoldEnergy() {
        return amountOfSoldEnergy;
    }

    public void setAmountOfSoldEnergy(Integer amountOfSoldEnergy) {
        this.amountOfSoldEnergy = amountOfSoldEnergy;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SoldEnergyEntity that = (SoldEnergyEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(amountOfSoldEnergy, that.amountOfSoldEnergy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amountOfSoldEnergy);
    }

    public SolarStationEntity getSolarStationBySolarStationId() {
        return solarStationBySolarStationId;
    }

    public void setSolarStationBySolarStationId(SolarStationEntity solarStationBySolarStationId) {
        this.solarStationBySolarStationId = solarStationBySolarStationId;
    }
}
