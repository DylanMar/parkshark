package com.switchfully.parkshark.service;

import com.switchfully.parkshark.dto.*;
import com.switchfully.parkshark.entity.*;
import com.switchfully.parkshark.mapper.*;
import com.switchfully.parkshark.repository.*;
import org.springframework.stereotype.*;

@Service
public class AllocationService {
    private AllocationRepository allocationRepository;
    private AllocationMapper allocationMapper;
    private ParkingLotRepository parkingLotRepository;

    public AllocationService(AllocationRepository allocationRepository, AllocationMapper allocationMapper, ParkingLotRepository parkingLotRepository) {
        this.allocationRepository = allocationRepository;
        this.allocationMapper = allocationMapper;
        this.parkingLotRepository = parkingLotRepository;
    }

    public AllocationDto createAllocation(Member member, CreateAllocationDto createAllocationDto) {
        Allocation allocation = allocationMapper.createAllocationDtoToAllocation(createAllocationDto);
        allocation.setMember(member);
        ParkingLot parkingLot = parkingLotRepository.findById(createAllocationDto.getParkingLotId());
        allocation.setParkingLot(parkingLot);

        return allocationMapper.allocationToAllocationDto(allocationRepository.save(allocation));
    }
}
