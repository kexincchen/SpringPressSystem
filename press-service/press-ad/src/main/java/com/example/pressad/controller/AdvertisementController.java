package com.example.pressad.controller;

import com.example.pressresource.entity.Advertisement;
import com.example.pressad.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ad")
public class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;

    @PreAuthorize("hasAnyRole('admin')")
    @PostMapping("/add")
    public ResponseEntity<String> insertNewAd(@RequestParam String title,
                                              @RequestParam String textContent,
                                              @RequestParam String placement,
                                              @RequestParam Long newsId) {
        Advertisement ad = advertisementService.insertNewAd(title, textContent, placement, newsId);
        return ResponseEntity.status(HttpStatus.CREATED).body("Advertisement created successfully. \nID: " + ad.getAdid());
    }

    @GetMapping("/by-placement")
    public ResponseEntity<List<Advertisement>> getAdByType(@RequestParam String placement) {
        List<Advertisement> ads = advertisementService.getAdByType(placement);
        return ResponseEntity.ok(ads);
    }

    @PutMapping("/{id}/click")
    public ResponseEntity<String> clickAdByID(@PathVariable Long id) {
        advertisementService.clickAdByID(id);
        return ResponseEntity.ok("Advertisement clicked successfully");
    }
}

