package com.razah.dev.bookstore.transaction.service.impl;

import com.razah.dev.bookstore.transaction.entities.SequenceGenerator;
import com.razah.dev.bookstore.transaction.repository.SequenceGeneratorRepository;
import com.razah.dev.bookstore.transaction.service.SequenceGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class SequenceGeneratorServiceImpl implements SequenceGeneratorService {
    private final SequenceGeneratorRepository sequenceGeneratorRepository;

    @Override
    public String getOutletSequence() {
        if (sequenceGeneratorRepository.existsById("outlet_sequence"))
        {
            SequenceGenerator sequence = sequenceGeneratorRepository.findByName("outlet_sequence").orElseThrow(
                    () ->  new ResponseStatusException(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.getReasonPhrase()));
            assert sequence != null;
            Integer oldId = sequence.getSequence();
            sequence.setSequence(oldId + 1);
            sequenceGeneratorRepository.save(sequence);
            sequenceGeneratorRepository.flush();
            String format = String.format("%04d", sequence.getSequence());
            return "O-" + format;
        }
        SequenceGenerator sequenceGenerator = new SequenceGenerator();
        sequenceGenerator.setName("outlet_sequence");
        sequenceGenerator.setSequence(100);
        sequenceGeneratorRepository.saveAndFlush(sequenceGenerator);
        String format = String.format("%04d", sequenceGenerator.getSequence());
        return "O-"+format;
    }

    @Override
    public String getPhotoSequence() {
        if (sequenceGeneratorRepository.existsById("photo_sequence"))
        {
            SequenceGenerator sequence = sequenceGeneratorRepository.findByName("photo_sequence").orElseThrow(
                    () ->  new ResponseStatusException(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.getReasonPhrase()));
            assert sequence != null;
            Integer oldId = sequence.getSequence();
            sequence.setSequence(oldId + 1);
            sequenceGeneratorRepository.save(sequence);
            sequenceGeneratorRepository.flush();
            String format = String.format("%04d", sequence.getSequence());
            return "P"+"-"+format;
        }
        SequenceGenerator sequenceGenerator = new SequenceGenerator();
        sequenceGenerator.setName("photo_sequence");
        sequenceGenerator.setSequence(1);
        sequenceGeneratorRepository.saveAndFlush(sequenceGenerator);
        String format = String.format("%04d", sequenceGenerator.getSequence());
        return "P"+"-"+format;
    }

    @Override
    public String getBookSequence() {
        if (sequenceGeneratorRepository.existsById("book_sequence"))
        {
            SequenceGenerator sequence = sequenceGeneratorRepository.findByName("book_sequence").orElseThrow(
                    () ->  new ResponseStatusException(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.getReasonPhrase()));
            assert sequence != null;
            Integer oldId = sequence.getSequence();
            sequence.setSequence(oldId + 1);
            sequenceGeneratorRepository.save(sequence);
            sequenceGeneratorRepository.flush();
            String format = String.format("%04d", sequence.getSequence());
            return "B"+"-"+format;
        }
        SequenceGenerator sequenceGenerator = new SequenceGenerator();
        sequenceGenerator.setName("book_sequence");
        sequenceGenerator.setSequence(1);
        sequenceGeneratorRepository.saveAndFlush(sequenceGenerator);
        String format = String.format("%04d", sequenceGenerator.getSequence());
        return "B"+"-"+format;
    }
}
