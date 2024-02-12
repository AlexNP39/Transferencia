package com.yape2.Transferencia2.service;

import com.yape2.Transferencia2.DTO.AccountDTO;
import com.yape2.Transferencia2.entity.Account;

public interface IAccountService {
    AccountDTO getAccountBycellphone(int cellphone);
}
