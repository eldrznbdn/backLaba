package com.zinabadinov.domain;



import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "amount_of_station", schema = "db_jdbclaba4", catalog = "")
public class AmountOfStationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "amount")
    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "owner_s_id", referencedColumnName = "id", nullable = false)
    private OwnerSEntity ownerSByOwnerSId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AmountOfStationEntity that = (AmountOfStationEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount);
    }

    public OwnerSEntity getOwnerSByOwnerSId() {
        return ownerSByOwnerSId;
    }

    public void setOwnerSByOwnerSId(OwnerSEntity ownerSByOwnerSId) {
        this.ownerSByOwnerSId = ownerSByOwnerSId;
    }
}
