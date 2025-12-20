package com.example.demo.controller;

import com.example.demo.entity.TransferRecord;
import com.example.demo.service.TransferRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transfers")
public class TransferRecordController {

    private final TransferRecordService transferRecordService;

    public TransferRecordController(TransferRecordService transferRecordService) {
        this.transferRecordService = transferRecordService;
    }

    // @PostMapping
    // public TransferRecord createTransfer(@RequestBody TransferRecord record) {
    //     return transferRecordService.createTransfer(record);
    // }
    @PostMapping("/{assetId}")
    public TransferRecord createTransfer(@PathVariable Long assetId, @RequestBody TransferRecord record) {
           return transferRecordService.createTransfer(assetId, record);
    }


    @GetMapping
    public List<TransferRecord> getAllTransfers() {
        return transferRecordService.getAllTransfers();
    }

    @GetMapping("/{id}")
    public TransferRecord getTransferById(@PathVariable Long id) {
        return transferRecordService.getTransferById(id);
    }
}
