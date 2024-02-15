package com.yape2.Transferencia2.service.impl;

import com.yape2.Transferencia2.DTO.AccountDTO;
import com.yape2.Transferencia2.Mapper.AccountMapper;
import com.yape2.Transferencia2.entity.Account;
import com.yape2.Transferencia2.repository.AccountRepository;
import com.yape2.Transferencia2.service.IAccountService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@SpringBootTest
public class AccountServiceimplTest {

    @Autowired
    private IAccountService accountService;
    @Mock
    private AccountRepository accountRepository;
    @Mock
    private AccountMapper accountMapper;

    @Test
    void TestgetAccountBycellphone() {
        int cellphone = 987654321;
        Account tAccount = new Account();
        AccountDTO accountDTO = new AccountDTO();
        when(accountRepository.findAccountByUser_cellphone(cellphone)).thenReturn(tAccount);
        when(accountMapper.entityToDTO(tAccount)).thenReturn(accountDTO);

        AccountDTO testaccount = accountService.getAccountBycellphone(cellphone);

        assertNotNull(testaccount);
    }
}