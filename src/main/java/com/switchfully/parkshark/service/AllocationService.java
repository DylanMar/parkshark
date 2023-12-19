package com.switchfully.parkshark.service;

import com.switchfully.parkshark.dto.*;
import com.switchfully.parkshark.entity.*;
import com.switchfully.parkshark.mapper.*;
import com.switchfully.parkshark.repository.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

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

    public AllocationDto startAllocation(Member member, CreateAllocationDto createAllocationDto) {
        Allocation allocation = allocationMapper.createAllocationDtoToAllocation(createAllocationDto);
        allocation.setMember(member);
        ParkingLot parkingLot = parkingLotRepository.findById(createAllocationDto.getParkingLotId())
                .orElseThrow(() -> new IllegalArgumentException("ParkingLot with id " + createAllocationDto.getParkingLotId() + " does not exist."));

        allocation.setParkingLot(parkingLot);

        return allocationMapper.allocationToAllocationDto(allocationRepository.save(allocation));
    }

    public void checkLicensePlate(Member member, CreateAllocationDto createAllocationDto){
        if (!Objects.equals(member.getLicensePlate(), createAllocationDto.getLicensePlate())){
            if(!member.getLevel().getLevelType().equals(LevelType.GOLD)) {
              throw new RuntimeException();
            }
        }
    }

    public AllocationDto stopAllocation(Member member, Long id, UpDateAllocationDto upDateAllocationDto) {
        Allocation allocation = allocationRepository.findById(id).get();
        allocation.setStopTime(upDateAllocationDto.getStopTime());
        allocation.setStatus(AllocationStatus.STOPPED);
        return allocationMapper.allocationToAllocationDto(allocationRepository.save(allocation));

    }

    public void checkAllocation(Member member, Long id){
        Allocation allocation = allocationRepository.findById(id).get();
        if(allocation.getMember() != member){
            throw new RuntimeException();
        } else {
            if(allocation.getStatus() == AllocationStatus.STOPPED){
                throw new RuntimeException();
            }
        }
    }

    public List<AllocationDto> getAllAllocations(AllocationStatus allocationStatus, String direction, Integer limit) {
        Stream<Allocation> allocationList = allocationRepository.findAll().stream().sorted(Comparator.comparing(Allocation::getStartTime));
        if (allocationStatus != null ) {
            allocationList = findByAllocationStatus(allocationStatus, allocationList);
        }
        if(limit != null){
            allocationList = limitAllocation(limit, allocationList);
        }
        List<AllocationDto> allocationDtos = allocationList
                .map(allocation -> allocationMapper.allocationToAllocationDto(allocation))
                .collect(Collectors.toList());
        if(direction != null && direction.equals("DESC")){
            Collections.reverse(allocationDtos);
        }
        return allocationDtos;

    }

    private Stream<Allocation> limitAllocation(Integer limit, Stream<Allocation> stream) {
        return stream.limit(limit);
    }

    private Stream<Allocation> sortByDirection(String direction, Stream<Allocation> stream) {
        return stream.sorted(Comparator.comparing(Allocation::getStartTime));
    }

    private Stream<Allocation> findByAllocationStatus(AllocationStatus allocationStatus, Stream<Allocation> stream){
        return stream.filter(allocation -> allocation.getStatus().equals(allocationStatus));
    }

}
