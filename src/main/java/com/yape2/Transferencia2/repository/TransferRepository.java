package com.yape2.Transferencia2.repository;

import com.yape2.Transferencia2.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {

}
