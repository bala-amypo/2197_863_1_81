package com.example.demo.controller;

import com.example.demo.entity.DisposalRecord;
import com.example.demo.service.DisposalRecordService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disposals")
public class DisposalRecordController {

    private final DisposalRecordService disposalRecordService;

    public DisposalRecordController(DisposalRecordService disposalRecordService) {
        this.disposalRecordService = disposalRecordService;
    }

    @PostMapping("/asset/{assetId}")
    public ResponseEntity<DisposalRecord> createDisposal(
            @PathVariable Long assetId,
            @Valid @RequestBody DisposalRecord disposal) {

        return new ResponseEntity<>(
                disposalRecordService.createDisposal(assetId, disposal),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisposalRecord> getDisposal(@PathVariable Long id) {
        return ResponseEntity.ok(disposalRecordService.getDisposal(id));
    }

    @GetMapping
    public ResponseEntity<List<DisposalRecord>> getAllDisposals() {
        return ResponseEntity.ok(disposalRecordService.getAllDisposals());
    }
}
