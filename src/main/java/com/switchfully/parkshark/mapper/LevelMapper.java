package com.switchfully.parkshark.mapper;

import com.switchfully.parkshark.dto.LevelDto;
import com.switchfully.parkshark.entity.Level;
import org.springframework.stereotype.Component;

@Component
public class LevelMapper {

    public LevelDto levelToLevelDto(Level level){
        return new LevelDto(level.getId(), level.getMonthlyCost(), level.getAllocationReduction(), level.getMaximumTime(), level.getLevelType());
    }
}
