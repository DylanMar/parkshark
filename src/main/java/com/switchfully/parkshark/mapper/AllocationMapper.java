package com.switchfully.parkshark.mapper;

import com.switchfully.parkshark.dto.*;
import com.switchfully.parkshark.entity.*;
import org.springframework.stereotype.*;

@Component
public class AllocationMapper {

    private MemberMapper memberMapper;
    private ParkingLotMapper parkingLotMapper;

    public AllocationMapper(MemberMapper memberMapper, ParkingLotMapper parkingLotMapper) {
        this.memberMapper = memberMapper;
        this.parkingLotMapper = parkingLotMapper;
    }

    public Allocation createAllocationDtoToAllocation(CreateAllocationDto createAllocationDto){
        Allocation allocation = new Allocation(createAllocationDto.getLicensePlate(), AllocationStatus.ACTIVE, createAllocationDto.getStartTime());

        return allocation;
    }

    public AllocationDto allocationToAllocationDto(Allocation allocation){
        return new AllocationDto(
                allocation.getId(),
                allocation.getLicensePlate(),
                allocation.getStatus(),
                allocation.getStartTime(),
                allocation.getStopTime(),
                memberMapper.memberToMemberDto(allocation.getMember()),
                parkingLotMapper.mapParkingLotToParkingLotDto(allocation.getParkingLot())
        );
    }
}
