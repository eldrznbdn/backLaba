package com.zinabadinov.domain;

import lombok.Data;

import javax.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Data
@Entity
@Table(name = "solar_station", schema = "db_jdbclaba4", catalog = "")
public class SolarStationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "country")
    private String country;
    @Basic
    @Column(name = "type_station")
    private String typeStation;
    @Basic
    @Column(name = "capacity")
    private Integer capacity;
    @OneToMany(mappedBy = "solarStationBySolarStationId")
    private Collection<BattaryChargeEntity> battaryChargesById;
    @OneToMany(mappedBy = "solarStationBySolarStationId")
    private Collection<ElectricityPriceEntity> electricityPricesById;
    @OneToMany(mappedBy = "solarStationBySolarStationId")
    private Collection<InstalationDateEntity> instalationDatesById;
    @OneToMany(mappedBy = "solarStationBySolarStationId")
    private Collection<PanelEntity> panelsById;
    @OneToMany(mappedBy = "solarStationBySolarStationId")
    private Collection<SoldEnergyEntity> soldEnergiesById;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTypeStation() {
        return typeStation;
    }

    public void setTypeStation(String typeStation) {
        this.typeStation = typeStation;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SolarStationEntity that = (SolarStationEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(country, that.country) && Objects.equals(typeStation, that.typeStation) && Objects.equals(capacity, that.capacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, typeStation, capacity);
    }

    public Collection<BattaryChargeEntity> getBattaryChargesById() {
        return battaryChargesById;
    }

    public void setBattaryChargesById(Collection<BattaryChargeEntity> battaryChargesById) {
        this.battaryChargesById = battaryChargesById;
    }

    public Collection<ElectricityPriceEntity> getElectricityPricesById() {
        return electricityPricesById;
    }

    public void setElectricityPricesById(Collection<ElectricityPriceEntity> electricityPricesById) {
        this.electricityPricesById = electricityPricesById;
    }

    public Collection<InstalationDateEntity> getInstalationDatesById() {
        return instalationDatesById;
    }

    public void setInstalationDatesById(Collection<InstalationDateEntity> instalationDatesById) {
        this.instalationDatesById = instalationDatesById;
    }

    public Collection<PanelEntity> getPanelsById() {
        return panelsById;
    }

    public void setPanelsById(Collection<PanelEntity> panelsById) {
        this.panelsById = panelsById;
    }

    public Collection<SoldEnergyEntity> getSoldEnergiesById() {
        return soldEnergiesById;
    }

    public void setSoldEnergiesById(Collection<SoldEnergyEntity> soldEnergiesById) {
        this.soldEnergiesById = soldEnergiesById;
    }
}
