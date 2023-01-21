package com.project.backend.controllers;

import com.project.backend.dtos.ChartsDTO;
import com.project.backend.queries.TransferQuery;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/charts")
public class ChartsController {
    private final TransferQuery transferQuery;

    @GetMapping
    ChartsDTO tst() {
        return transferQuery.getChartsValue();
    }
}
