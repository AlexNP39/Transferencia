package com.yape2.Transferencia2.Mapper;

import com.yape2.Transferencia2.DTO.TransferDTO;
import com.yape2.Transferencia2.entity.Transfer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransferMapper {
    TransferMapper INSTANCE = Mappers.getMapper(TransferMapper.class);

    @Mapping(target = "sourceAccount", source = "sourceAccount")
    @Mapping(target = "destinationAccount", source = "destinationAccount")
    @Mapping(target = "amount", source = "amount")
    @Mapping(target = "currency", source = "currency")
    TransferDTO entityToDTO(Transfer transfer);

    Transfer dtoToEntity(TransferDTO transferDTO);
}
