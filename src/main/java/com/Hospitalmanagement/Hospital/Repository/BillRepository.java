package com.Hospitalmanagement.Hospital.Repository;

import com.Hospitalmanagement.Hospital.modles.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {
}
