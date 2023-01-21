package com.project.backend.controllers;

import com.project.backend.domain.Transfer;
import com.project.backend.dtos.CreateTransferDTO;
import com.project.backend.dtos.ReadTransferDTO;
import com.project.backend.exceptions.DataIntegrityException;
import com.project.backend.services.TransferService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


@RestController
@RequestMapping("/transfer")
@AllArgsConstructor
public class TransferController {
    private final TransferService transferService;
    private final ModelMapper mapper;

    @GetMapping
    Page<ReadTransferDTO> findAll(Pageable pagination) {
        return transferService.findAll(pagination);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ReadTransferDTO create(@RequestBody CreateTransferDTO dto) {
        Transfer transfer = mapper.map(dto, Transfer.class);

        transfer.setCreatedAt(LocalDate.now());
        try {
            LocalDate scheduleDate = LocalDate.parse(dto.getScheduleDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            transfer.setScheduleDate(scheduleDate);
            transferService.create(transfer);
            return mapper.map(transfer, ReadTransferDTO.class);
        } catch(DateTimeParseException ex) {
            throw new DataIntegrityException("Data inválida");
        }
    }

}
