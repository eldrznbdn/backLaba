package com.zinabadinov.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "electricity_price", schema = "db_jdbclaba4", catalog = "")
public class ElectricityPriceEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "price")
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "solar_station_id", referencedColumnName = "id", nullable = false)
    private SolarStationEntity solarStationBySolarStationId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElectricityPriceEntity that = (ElectricityPriceEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price);
    }

    public SolarStationEntity getSolarStationBySolarStationId() {
        return solarStationBySolarStationId;
    }

    public void setSolarStationBySolarStationId(SolarStationEntity solarStationBySolarStationId) {
        this.solarStationBySolarStationId = solarStationBySolarStationId;
    }
}
