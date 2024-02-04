package com.example.pressad.service.impl;

import com.example.pressresource.entity.Advertisement;
import com.example.pressad.mapper.AdvertisementMapper;
import com.example.pressad.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {
    @Autowired
    private AdvertisementMapper advertisementMapper;

    public Advertisement insertNewAd(String title, String textContent, String placement, Long newsId){
        Advertisement ad = new Advertisement(title, textContent, placement, newsId);
        advertisementMapper.insert(ad);
        return ad;
    }

    public List<Advertisement> getAdByType(String placement){
        return advertisementMapper.selectByPlacement(placement);
    }

    public void clickAdByID(Long id) {
        Advertisement ad = advertisementMapper.selectById(id);
        if (ad != null){
            ad.clickOnce();
            advertisementMapper.updateById(ad);
        } else {
            throw new IllegalStateException("Advertisement not found with id: " + id);
        }

    }
}
