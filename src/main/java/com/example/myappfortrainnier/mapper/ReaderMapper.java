package com.example.myappfortrainnier.mapper;

import com.example.myappfortrainnier.dto.ReaderDTO;
import com.example.myappfortrainnier.entity.ReaderEntity;
import org.springframework.stereotype.Component;

@Component
public class ReaderMapper {
    public ReaderDTO toReaderDTO(ReaderEntity readerEntity){
            ReaderDTO readerDTO = new ReaderDTO();

            readerDTO.setId(readerEntity.getId());
            readerDTO.setFIO(readerEntity.getFIO());
            readerDTO.setPhoneNumber(readerEntity.getPhoneNumber());
            readerDTO.setYearOfBirth(readerEntity.getYearOfBirth());
            readerDTO.setAddress(readerEntity.getAddress());
            readerDTO.setProfession(readerEntity.getProfession());

            return readerDTO;
    }

    public ReaderEntity toReaderEntity(ReaderDTO readerDTO)
    {
        ReaderEntity readerEntity = new ReaderEntity();

        readerEntity.setId(readerDTO.getId());
        readerEntity.setFIO(readerDTO.getFIO());
        readerEntity.setPhoneNumber(readerDTO.getPhoneNumber());
        readerEntity.setYearOfBirth(readerDTO.getYearOfBirth());
        readerEntity.setAddress(readerDTO.getAddress());
        readerEntity.setProfession(readerDTO.getProfession());

        return readerEntity;
    }
}
