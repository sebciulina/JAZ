package com.example.workshop.repos;


import com.example.workshop.entities.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarsRepository extends JpaRepository<Cars, Integer>{

    @Query("SELECT t from Cars t where t.model like %?1% and t.status like %?2%")
    List<Cars> findCarsBy(String model, String status);

    @Modifying
    @Query("update Cars u set u.customerId = ?1, u.employeeId = ?2, u.model = ?3, u.status = ?4, u.totalCost = ?5 where u.id = ?6")
    void setCarInfoById(int customerId, int employeeId, String model, String status, Double totalCost, int id);

}
