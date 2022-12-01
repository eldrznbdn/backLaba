package com.zinabadinov.domain;

import lombok.Data;

import javax.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Data
@Entity
@Table(name = "owner_s", schema = "db_jdbclaba4", catalog = "")
public class OwnerSEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "surname")
    private String surname;
    @OneToMany(mappedBy = "ownerSByOwnerSId")
    private Collection<AmountOfStationEntity> amountOfStationsById;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OwnerSEntity that = (OwnerSEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(surname, that.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname);
    }

    public Collection<AmountOfStationEntity> getAmountOfStationsById() {
        return amountOfStationsById;
    }

    public void setAmountOfStationsById(Collection<AmountOfStationEntity> amountOfStationsById) {
        this.amountOfStationsById = amountOfStationsById;
    }
}
