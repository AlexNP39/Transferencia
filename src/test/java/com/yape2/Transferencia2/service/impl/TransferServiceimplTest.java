package com.yape2.Transferencia2.service.impl;

import com.yape2.Transferencia2.DTO.AccountDTO;
import com.yape2.Transferencia2.DTO.TransferDTO;
import com.yape2.Transferencia2.DTO.UserDTO;
import com.yape2.Transferencia2.Mapper.TransferMapper;
import com.yape2.Transferencia2.entity.Account;
import com.yape2.Transferencia2.entity.Transfer;
import com.yape2.Transferencia2.entity.User;
import com.yape2.Transferencia2.repository.AccountRepository;
import com.yape2.Transferencia2.repository.TransferRepository;
import com.yape2.Transferencia2.service.ITransferService;
import org.apache.coyote.BadRequestException;
import org.junit.jupiter.api.Test;
import org.mapstruct.control.MappingControl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
@SpringBootTest
public class TransferServiceimplTest {

    @Autowired
    private TransferServiceimpl transferService;

    @MockBean
    private TransferRepository transferRepository;

    @MockBean
    private TransferMapper transferMapper;

    @MockBean
    private AccountRepository accountRepository;

    @Test
    void startTransfer_test() {
        TransferDTO tDTO = new TransferDTO();
        User user1 = new User(1L, "Harumi", "Nolasco", 987654321);
        User user2 = new User(2L, "Luis", "Ramirez", 912345678);
        tDTO.setSourceAccount(new AccountDTO(1L, user1, "123456789120", BigDecimal.valueOf(1000)));
        tDTO.setDestinationAccount(new AccountDTO(2L, user2, "19283746501884",BigDecimal.valueOf(500)));
        tDTO.setAmount(BigDecimal.valueOf(200));

        Account sourceAccount = new Account();
        sourceAccount.setId(1L);
        sourceAccount.setBalance(BigDecimal.valueOf(1000));

        Account destinationAccount = new Account();
        destinationAccount.setId(2L);
        destinationAccount.setBalance(BigDecimal.valueOf(500));

        when(accountRepository.findAccountByUser_cellphone(987654321)).thenReturn(sourceAccount);
        when(accountRepository.findAccountByUser_cellphone(912345678)).thenReturn(destinationAccount);
        when(transferMapper.dtoToEntity(tDTO)).thenReturn(new Transfer());
        when(transferRepository.save(any(Transfer.class))).thenReturn(new Transfer());

        /*try {
            transferService.startTransfer(tDTO);
        } catch (BadRequestException e) {
            throw new RuntimeException(e);
        }
        Account account1 = accountRepository.findAccountByUser_cellphone(987654321);
        Account account2 = accountRepository.findAccountByUser_cellphone(912345678);
        assertEquals(BigDecimal.valueOf(800), account1.getBalance());
        assertEquals(BigDecimal.valueOf(700), account2.getBalance());

         */
        assertDoesNotThrow(() -> transferService.startTransfer(tDTO));
        verify(accountRepository, times(2)).save(any(Account.class));
        verify(transferRepository).save(any(Transfer.class));

    }

    @Test
    void testStartTransfer_InsufficientBalance(){
        TransferDTO tDTO = new TransferDTO();
        User user1 = new User(1L, "Harumi", "Nolasco", 987654321);
        User user2 = new User(2L, "Luis", "Ramirez", 912345678);
        tDTO.setSourceAccount(new AccountDTO(1L, user1, "123456789120", BigDecimal.valueOf(100)));
        tDTO.setDestinationAccount(new AccountDTO(2L, user2, "19283746501884",BigDecimal.valueOf(500)));
        tDTO.setAmount(BigDecimal.valueOf(200));

        Account sourceAccount = new Account();
        sourceAccount.setId(1L);
        sourceAccount.setBalance(BigDecimal.valueOf(100));

        Account destinationAccount = new Account();
        destinationAccount.setId(2L);
        destinationAccount.setBalance(BigDecimal.valueOf(500));

        when(accountRepository.findAccountByUser_cellphone(987654321)).thenReturn(sourceAccount);
        when(accountRepository.findAccountByUser_cellphone(912345678)).thenReturn(destinationAccount);
        when(transferMapper.dtoToEntity(tDTO)).thenReturn(new Transfer());
        when(transferRepository.save(any(Transfer.class))).thenReturn(new Transfer());

        assertThrows(BadRequestException.class, () -> transferService.startTransfer(tDTO));
        assertEquals(BigDecimal.valueOf(100), sourceAccount.getBalance());

    }

    @Test
    void validateTransfer_successtest() {
        TransferDTO tDTO = new TransferDTO();
        User user1 = new User(1L, "Harumi", "Nolasco", 987654321);
        User user2 = new User(2L, "Luis", "Ramirez", 912345678);
        tDTO.setSourceAccount(new AccountDTO(1L, user1, "123456789120", BigDecimal.valueOf(1000)));
        tDTO.setDestinationAccount(new AccountDTO(2L, user2, "19283746501884",BigDecimal.valueOf(500)));
        tDTO.setAmount(BigDecimal.valueOf(200));
        tDTO.setCurrency("Soles");

        assertDoesNotThrow(() -> transferService.validateTransfer(tDTO));
    }

    @Test
    void validateTransfer_sourceEqualsDestination(){
        TransferDTO tDTO = new TransferDTO();
        User user1 = new User(1L, "Harumi", "Nolasco", 987654321);
        tDTO.setSourceAccount(new AccountDTO(1L, user1, "123456789120", BigDecimal.valueOf(1000)));
        tDTO.setDestinationAccount(new AccountDTO(1L, user1, "123456789120", BigDecimal.valueOf(1000)));
        tDTO.setAmount(BigDecimal.valueOf(200));
        tDTO.setCurrency("Soles");
        ITransferService iTransferService = new TransferServiceimpl();


    }

}