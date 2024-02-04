package com.example.pressnews.service.impl;

import com.example.pressnews.mapper.PressMapper;
import com.example.pressnews.service.PressService;
import com.example.pressresource.entity.Press;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PressServiceImpl implements PressService {
    @Autowired
    private PressMapper pressMapper;

    public List<Press> getAllPress(){
        return pressMapper.selectList(null);
    }

    public Press getPressById(Long id){
        return pressMapper.selectById(id);
    }

    public Press insertNewPress(String title, String body){
        Press press = new Press(title, body);
        pressMapper.insert(press);
        return press;
    }

    public void updatePress(Long id, String newTitle, String newBody) {
        // Fetch the existing press record
        Press press = pressMapper.selectById(id);

        if (press != null) {
            // Update the title and body
            press.setTitle(newTitle);
            press.setBody(newBody);

            // Persist the changes
            pressMapper.updateById(press);
        } else {
            throw new IllegalStateException("Press not found with id: " + id);
        }
    }

    public Press getPressWithAdvertisements(Long id) {
        return pressMapper.selectPressWithAdvertisements(id);
    }

    public List<Press> getAllPressWithAdvertisements() {
        return pressMapper.selectAllPressWithAdvertisements();
    }

    private void updatePressByOp(Long id, String op){
        Press press = pressMapper.selectById(id);
        if (press != null){
            if (op.equals("CLICK")){
                press.clickOnce();
            } else if (op.equals("LIKE")){
                press.likeOnce();
            } else if (op.equals("SHARE")){
                press.shareOnce();
            } else {
                throw new IllegalStateException("Invalid Operation with press: " + id);
            }
        } else {
            throw new IllegalStateException("Press not found with id: " + id);
        }
    }
    @Override
    public void clickPressByID(Long id) {
        updatePressByOp(id, "CLICK");
    }

    @Override
    public void sharePressByID(Long id) {
        updatePressByOp(id, "SHARE");
    }

    @Override
    public void likePressByID(Long id) {
        updatePressByOp(id, "LIKE");
    }
}