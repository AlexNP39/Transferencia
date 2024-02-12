package com.yape2.Transferencia2.Mapper;

import com.yape2.Transferencia2.DTO.AccountDTO;
import com.yape2.Transferencia2.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    AccountDTO entityToDTO(Account account);

    List<AccountDTO> entitiesToDTOs(List<Account> accounts);

    Account dtoToEntity(AccountDTO accountDTO);

}
