package com.zinabadinov.domain;

import lombok.Data;

import javax.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Data
@Entity
@Table(name = "panel", schema = "db_jdbclaba4", catalog = "")
public class PanelEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "amount_of_panel")
    private Integer amountOfPanel;

    @ManyToOne
    @JoinColumn(name = "solar_station_id", referencedColumnName = "id", nullable = false)
    private SolarStationEntity solarStationBySolarStationId;
    @OneToMany(mappedBy = "panelByPanelId")
    private Collection<PanelAngelsEntity> panelAngelsById;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmountOfPanel() {
        return amountOfPanel;
    }

    public void setAmountOfPanel(Integer amountOfPanel) {
        this.amountOfPanel = amountOfPanel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PanelEntity that = (PanelEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(amountOfPanel, that.amountOfPanel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amountOfPanel);
    }

    public SolarStationEntity getSolarStationBySolarStationId() {
        return solarStationBySolarStationId;
    }

    public void setSolarStationBySolarStationId(SolarStationEntity solarStationBySolarStationId) {
        this.solarStationBySolarStationId = solarStationBySolarStationId;
    }

    public Collection<PanelAngelsEntity> getPanelAngelsById() {
        return panelAngelsById;
    }

    public void setPanelAngelsById(Collection<PanelAngelsEntity> panelAngelsById) {
        this.panelAngelsById = panelAngelsById;
    }
}
