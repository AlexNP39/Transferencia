package com.yape2.Transferencia2.service.impl;

import com.yape2.Transferencia2.DTO.AccountDTO;
import com.yape2.Transferencia2.Mapper.AccountMapper;
import com.yape2.Transferencia2.entity.Account;
import com.yape2.Transferencia2.repository.AccountRepository;
import com.yape2.Transferencia2.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceimpl implements IAccountService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    AccountMapper accountMapper;
    @Override
    public AccountDTO getAccountBycellphone(int cellphone) {
        Account account = accountRepository.findAccountByUser_cellphone(cellphone);

        AccountDTO accountDTO = accountMapper.entityToDTO(account);
        return accountDTO;
    }
}
