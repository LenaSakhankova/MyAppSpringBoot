package com.example.myappfortrainnier.service;

import com.example.myappfortrainnier.entity.BookEntity;
import com.example.myappfortrainnier.entity.ReaderEntity;
import com.example.myappfortrainnier.repository.ReaderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class ReaderService {
    private final ReaderRepository readerRepository;

    public List<BookEntity> receiveReaderBooks(Long readerId)
    {
        Optional<ReaderEntity> readerEntity =  readerRepository.findById(readerId);

        if(readerEntity.isPresent()){
           return readerEntity.get().getBooks();
        }else{
            return new ArrayList<>();
        }
    }
    public ReaderEntity findById(Long id) {
        return readerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Reader not found"));
    }
    public List<ReaderEntity> getAllReaders(){
        return readerRepository.findAll();
    }

    @Transactional
    public void saveReader(ReaderEntity readerEntity) {
               readerRepository.save(readerEntity);
    }

    @Transactional
    public void deleteById(Long id){readerRepository.deleteById(id);}
}
