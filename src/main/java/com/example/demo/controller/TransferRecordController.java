package com.example.demo.controller;

import com.example.demo.entity.TransferRecord;
import com.example.demo.service.TransferRecordService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transfers")
public class TransferRecordController {

    private final TransferRecordService transferRecordService;

    public TransferRecordController(TransferRecordService transferRecordService) {
        this.transferRecordService = transferRecordService;
    }

    @PostMapping("/asset/{assetId}")
    public ResponseEntity<TransferRecord> createTransfer(
            @PathVariable Long assetId,
            @Valid @RequestBody TransferRecord record) {

        return new ResponseEntity<>(
                transferRecordService.createTransfer(assetId, record),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/asset/{assetId}")
    public ResponseEntity<List<TransferRecord>> getTransfers(@PathVariable Long assetId) {
        return ResponseEntity.ok(transferRecordService.getTransfersForAsset(assetId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransferRecord> getTransfer(@PathVariable Long id) {
        return ResponseEntity.ok(transferRecordService.getTransfer(id));
    }
}
