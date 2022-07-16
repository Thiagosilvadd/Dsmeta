package com.thiagosilva.dsmeta.controllers;

import com.thiagosilva.dsmeta.entities.Sale;
import com.thiagosilva.dsmeta.services.NotificationService;
import com.thiagosilva.dsmeta.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService service;

    @Autowired
    private NotificationService notificationService;

    @GetMapping
    public Page<Sale> findSales(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable) {
        return service.findSales(minDate, maxDate, pageable);
    }

    @GetMapping("/{id}/notification")
    public void notificationSms(@PathVariable Long id){
        notificationService.sendSms(id);
    }

}
