package com.zinabadinov.service;

import com.zinabadinov.domain.OwnerSEntity;
import org.springframework.data.jpa.repository.Query;

public interface OwnerSService extends GeneralService<OwnerSEntity,Integer>{

    void insertIntoOwner(String name,String surname);

    void insertIntoOwner10Rows();
}
