package com.yape2.Transferencia2.controller;

import com.yape2.Transferencia2.DTO.AccountDTO;
import com.yape2.Transferencia2.service.impl.AccountServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountServiceimpl accountService;

    @GetMapping("/celular/{cellphone}")
    public ResponseEntity<AccountDTO> validar(@PathVariable int cellphone){
        AccountDTO testaccount = accountService.getAccountBycellphone(cellphone);
        if (testaccount != null){
            return ResponseEntity.ok(testaccount);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
