package com.example.demo.controller;

import com.example.demo.entity.DisposalRecord;
import com.example.demo.service.DisposalRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disposals")
public class DisposalRecordController {

    private final DisposalRecordService disposalRecordService;

    public DisposalRecordController(DisposalRecordService disposalRecordService) {
        this.disposalRecordService = disposalRecordService;
    }

    @PostMapping
    public DisposalRecord createDisposal(@RequestBody DisposalRecord record) {
        return disposalRecordService.createDisposal(record);
    }

    @GetMapping
    public List<DisposalRecord> getAllDisposals() {
        return disposalRecordService.getAllDisposals();
    }

    @GetMapping("/{id}")
    public DisposalRecord getDisposalById(@PathVariable Long id) {
        return disposalRecordService.getDisposalRecordById(id);
    }
}
