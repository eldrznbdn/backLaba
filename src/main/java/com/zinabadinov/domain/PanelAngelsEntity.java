package com.zinabadinov.domain;

import lombok.Data;

import javax.persistence.*;

import java.util.Objects;

@Data
@Entity
@Table(name = "panel_angels", schema = "db_jdbclaba4", catalog = "")
public class PanelAngelsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "tilt")
    private Integer tilt;

    @ManyToOne
    @JoinColumn(name = "panel_id", referencedColumnName = "id", nullable = false)
    private PanelEntity panelByPanelId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTilt() {
        return tilt;
    }

    public void setTilt(Integer tilt) {
        this.tilt = tilt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PanelAngelsEntity that = (PanelAngelsEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(tilt, that.tilt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tilt);
    }

    public PanelEntity getPanelByPanelId() {
        return panelByPanelId;
    }

    public void setPanelByPanelId(PanelEntity panelByPanelId) {
        this.panelByPanelId = panelByPanelId;
    }
}
