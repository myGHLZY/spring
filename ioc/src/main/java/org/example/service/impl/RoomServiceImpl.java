package org.example.service.impl;

import org.example.mapper.RoomMapper;
import org.example.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomMapper roomMapper;

    public void setRoomMapper(RoomMapper roomMapper) {
        this.roomMapper = roomMapper;
    }

    @Override
    public void show(){
        System.out.println(roomMapper.list());
    }
}
