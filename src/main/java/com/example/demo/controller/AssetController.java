package com.example.demo.controller;

import com.example.demo.entity.Asset;
import com.example.demo.service.AssetService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assets")
public class AssetController {

    private final AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @PostMapping
    public ResponseEntity<Asset> createAsset(@Valid @RequestBody Asset asset) {
        return new ResponseEntity<>(assetService.createAsset(asset), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asset> getAsset(@PathVariable Long id) {
        return ResponseEntity.ok(assetService.getAsset(id));
    }

    @GetMapping
    public ResponseEntity<List<Asset>> getAllAssets() {
        return ResponseEntity.ok(assetService.getAllAssets());
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Asset> updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        return ResponseEntity.ok(assetService.updateStatus(id, status));
    }
}
