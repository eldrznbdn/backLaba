package com.zinabadinov.repository;

import com.zinabadinov.domain.OwnerSEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerSRepository extends JpaRepository<OwnerSEntity,Integer> {
    @Query(value = "CALL insert_into_owner(:new_name, :new_surname);", nativeQuery = true)
    void insertIntoOwner(@Param("new_name") String name,@Param("new_surname") String surname);

    @Query(value = "CALL insert_owner_10_rows();", nativeQuery = true)
    void insertIntoOwner10Rows();

}
