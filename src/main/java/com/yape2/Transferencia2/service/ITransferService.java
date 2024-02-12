package com.yape2.Transferencia2.service;

import com.yape2.Transferencia2.DTO.TransferDTO;
import com.yape2.Transferencia2.entity.Transfer;
import org.apache.coyote.BadRequestException;

public interface ITransferService {
    void startTransfer(TransferDTO transferDTO) throws BadRequestException;

    void validateTransfer(TransferDTO transferDTO);

}
