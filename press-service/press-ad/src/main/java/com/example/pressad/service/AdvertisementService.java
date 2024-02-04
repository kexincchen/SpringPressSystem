package com.example.pressad.service;

import com.example.pressresource.entity.Advertisement;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AdvertisementService {

    Advertisement insertNewAd(String title, String textContent, String placement, Long newsId);

    List<Advertisement> getAdByType(String placement);

    void clickAdByID(Long id) ;

}
