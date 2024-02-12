package com.yape2.Transferencia2.repository;

import com.yape2.Transferencia2.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findAccountByUser_cellphone(int cellphone);


}
