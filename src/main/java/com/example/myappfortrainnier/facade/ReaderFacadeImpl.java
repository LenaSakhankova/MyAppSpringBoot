package com.example.myappfortrainnier.facade;

import com.example.myappfortrainnier.dto.BookDTO;
import com.example.myappfortrainnier.dto.ReaderDTO;
import com.example.myappfortrainnier.entity.ReaderEntity;
import com.example.myappfortrainnier.mapper.BookMapper;
import com.example.myappfortrainnier.mapper.ReaderMapper;
import com.example.myappfortrainnier.service.ReaderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class ReaderFacadeImpl implements ReaderFacade{
    private final ReaderService readerService;
    private final ReaderMapper readerMapper;

    private final BookMapper bookMapper;


    @Override
    public List<ReaderDTO> getAllReaders()
    {
        List<ReaderEntity> readerEntity = readerService.getAllReaders();
        List<ReaderDTO> readerDTOS = new ArrayList<>();

        for (int i = 0; i < readerEntity.size(); i++)
        {
            readerDTOS.add(readerMapper.toReaderDTO(readerEntity.get(i)));
        }

        return readerDTOS;
    }
    @Override
    public ReaderDTO getReader(Long id)
    {

            ReaderEntity readerEntity = readerService.findById(id);

            return readerMapper.toReaderDTO(readerEntity);

    }

    @Override
    public ReaderDTO updateReader(ReaderDTO readerDTO, Long readerId) {
        ReaderEntity readerEntity = readerMapper.toReaderEntity(readerDTO);
        readerEntity.setId(readerId);
        readerService.saveReader(readerEntity);
        return readerMapper.toReaderDTO(readerEntity);
    }

    @Override
    public ReaderDTO createReader(ReaderDTO readerDTO) {
        ReaderEntity readerEntity = readerMapper.toReaderEntity(readerDTO);
        readerService.saveReader(readerEntity);
        return readerMapper.toReaderDTO(readerEntity);
    }
    @Override
    public void deleteById(Long id){
        readerService.deleteById(id);
    }

    @Override
    public List<BookDTO> receiveListOfReaderBooks(Long readerId) {
        return readerService.receiveReaderBooks(readerId).stream()
                .map(bookEntity -> bookMapper.toBookDTO(bookEntity))
                .collect(Collectors.toList());
    }
}
