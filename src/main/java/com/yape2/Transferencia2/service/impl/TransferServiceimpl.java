package com.yape2.Transferencia2.service.impl;

import com.yape2.Transferencia2.DTO.AccountDTO;
import com.yape2.Transferencia2.DTO.TransferDTO;
import com.yape2.Transferencia2.Mapper.AccountMapper;
import com.yape2.Transferencia2.Mapper.TransferMapper;
import com.yape2.Transferencia2.entity.Account;
import com.yape2.Transferencia2.entity.Transfer;
import com.yape2.Transferencia2.exceptions.RequestException;
import com.yape2.Transferencia2.repository.AccountRepository;
import com.yape2.Transferencia2.repository.TransferRepository;
import com.yape2.Transferencia2.service.IAccountService;
import com.yape2.Transferencia2.service.ITransferService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransferServiceimpl implements ITransferService {
    @Autowired
    private TransferRepository transferRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private IAccountService accountService;

    @Override
    public void startTransfer(TransferDTO transferDTO){

        AccountDTO sourceAccountDTO = accountService.getAccountBycellphone(transferDTO.getSourceAccount().getUser().getCellphone());
        AccountDTO destinationAccountDTO = accountService.getAccountBycellphone(transferDTO.getDestinationAccount().getUser().getCellphone());

        if (sourceAccountDTO != null && destinationAccountDTO != null) {
            if (sourceAccountDTO.getBalance().compareTo(transferDTO.getAmount()) >= 0) {
                //sourceAccountDTO.setBalance(sourceAccountDTO.getBalance().subtract(transferDTO.getAmount()));
                //destinationAccountDTO.setBalance(destinationAccountDTO.getBalance().add(transferDTO.getAmount()));
                //Realizar la transferencia a nivel de clase
                BigDecimal newSourceBalance = sourceAccountDTO.getBalance().subtract(transferDTO.getAmount());
                BigDecimal newDestinationBalance = destinationAccountDTO.getBalance().add(transferDTO.getAmount());
                sourceAccountDTO.setBalance(newSourceBalance);
                destinationAccountDTO.setBalance(newDestinationBalance);
                //Actualizar las cuentas
                Account sourceAccount = accountMapper.dtoToEntity(sourceAccountDTO);
                Account destinationAccount = accountMapper.dtoToEntity(destinationAccountDTO);

                accountRepository.save(sourceAccount);
                accountRepository.save(destinationAccount);

                Transfer transfer = TransferMapper.INSTANCE.dtoToEntity(transferDTO);
                transfer.setSourceAccount(sourceAccount);
                transfer.setDestinationAccount(destinationAccount);
                transferRepository.save(transfer);
                System.out.println("Transfer success");
            } else {
                throw new RequestException("51", HttpStatus.BAD_REQUEST,"Insufficient balance in the source account");
            }
        } else {
            throw new RequestException("52",HttpStatus.NOT_FOUND,"The account(s) do not exist");
        }

    }

    @Override
    public void validateTransfer(TransferDTO transferDTO) {

        if (transferDTO.getSourceAccount().equals(transferDTO.getDestinationAccount())) {
            System.out.println("Cannot transfer to your own account");
        }
        if (transferDTO.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Import must be greater than ZERO");
        }
        String currency = transferDTO.getCurrency().toUpperCase();
        if (!currency.equals("SOLES") && !currency.equals("DOLARES")) {
            System.out.println("Only soles and dollars are accepted");
        }

        System.out.println("Validation Success");

    }
}
