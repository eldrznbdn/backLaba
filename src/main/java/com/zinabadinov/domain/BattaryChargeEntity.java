package com.zinabadinov.domain;

import lombok.Data;

import javax.persistence.*;

import java.util.Objects;
@Data
@Entity
@Table(name = "battary_charge", schema = "db_jdbclaba4", catalog = "")
public class BattaryChargeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "type_of_charge")
    private String typeOfCharge;

    @ManyToOne
    @JoinColumn(name = "solar_station_id", referencedColumnName = "id", nullable = false)
    private SolarStationEntity solarStationBySolarStationId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeOfCharge() {
        return typeOfCharge;
    }

    public void setTypeOfCharge(String typeOfCharge) {
        this.typeOfCharge = typeOfCharge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BattaryChargeEntity that = (BattaryChargeEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(typeOfCharge, that.typeOfCharge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeOfCharge);
    }

    public SolarStationEntity getSolarStationBySolarStationId() {
        return solarStationBySolarStationId;
    }

    public void setSolarStationBySolarStationId(SolarStationEntity solarStationBySolarStationId) {
        this.solarStationBySolarStationId = solarStationBySolarStationId;
    }
}
