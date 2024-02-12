package com.yape2.Transferencia2.controller;

import com.yape2.Transferencia2.DTO.TransferDTO;
import com.yape2.Transferencia2.entity.Transfer;
import com.yape2.Transferencia2.service.ITransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/transfer")
public class Transfercontroller {
    @Autowired
    public ITransferService transferService;
    @PostMapping("/start")
    public ResponseEntity<String> startTransfer(@RequestBody TransferDTO transferDTO){
        try {
            transferService.validateTransfer(transferDTO);
            transferService.startTransfer(transferDTO);
            return new ResponseEntity<>("Transfer Success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
