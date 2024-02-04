package com.example.pressnews.service;


import com.example.pressresource.entity.Press;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PressService {

    List<Press> getAllPress();

    Press getPressById(Long id);

    Press insertNewPress(String title, String body);

    void updatePress(Long id, String newTitle, String newBody);

    Press getPressWithAdvertisements(Long id);

    List<Press> getAllPressWithAdvertisements();

    void clickPressByID(Long id);

    void sharePressByID(Long id);

    void likePressByID(Long id);

}
