package com.zinabadinov.domain;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "instalation_date", schema = "db_jdbclaba4", catalog = "")
public class InstalationDateEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "ins_date")
    private String insDate;

    @ManyToOne
    @JoinColumn(name = "solar_station_id", referencedColumnName = "id", nullable = false)
    private SolarStationEntity solarStationBySolarStationId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInsDate() {
        return insDate;
    }

    public void setInsDate(String insDate) {
        this.insDate = insDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstalationDateEntity that = (InstalationDateEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(insDate, that.insDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, insDate);
    }

    public SolarStationEntity getSolarStationBySolarStationId() {
        return solarStationBySolarStationId;
    }

    public void setSolarStationBySolarStationId(SolarStationEntity solarStationBySolarStationId) {
        this.solarStationBySolarStationId = solarStationBySolarStationId;
    }
}
