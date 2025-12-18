package com.example.demo.controller;


import java.util.List;


import org.springframework.web.bind.annotation.*;


import com.example.demo.entity.Asset;
//import com.example.demo.dto.AssetStatusUpdateRequest;
import com.example.demo.service.AssetService;


import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/api/assets")
@Tag(name = "Asset Controller")
public class AssetController {


private final AssetService assetService;


public AssetController(AssetService assetService) {
this.assetService = assetService;
}


@PostMapping
public Asset createAsset(@RequestBody Asset asset) {
return assetService.createAsset(asset);
}


@GetMapping
public List<Asset> getAllAssets() {
return assetService.getAllAssets();
}


@GetMapping("/{id}")
public Asset getAsset(@PathVariable Long id) {
return assetService.getAsset(id);
}


@PutMapping("/status/{id}")
public Asset updateStatus(@PathVariable Long id, @RequestBody AssetStatusUpdateRequest request) {
return assetService.updateStatus(id, request.getStatus());
}
}