package com.jsp.newcurdoperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CheckInService {
    
    @Autowired
    private CheckInRepository checkInRepository;
    
    public List<CheckIn> getAllCheckIns(Pageable pageable) {
        return (List<CheckIn>) checkInRepository.findAll(pageable);
    }
    
    public CheckIn getCheckInById(Long id) {
        return checkInRepository.findById(id).orElseThrow();
    }
    
    public CheckIn createCheckIn(CheckIn checkIn) {
        return checkInRepository.save(checkIn);
    }
    
    public CheckIn updateCheckIn(Long id, CheckIn checkIn) {
        CheckIn existingCheckIn = getCheckInById(id);
        existingCheckIn.setCheckInDate(checkIn.getCheckInDate());
        existingCheckIn.setCheckOutDate(checkIn.getCheckOutDate());
        return checkInRepository.save(existingCheckIn);
    }
    
    public void deleteCheckIn(Long id) {
        checkInRepository.deleteById(id);
    }

    public void removeGuestFromCheckIn(Long id, Long guestId) {
        CheckIn checkIn = getCheckInById(id);
        List<Guest> guests = checkIn.getGuests();
        guests.removeIf(guest -> guest.getId().equals(guestId));
        checkInRepository.save(checkIn);
    }

    public List<Guest> getGuestsForCheckIn(Long id) {
        CheckIn checkIn = getCheckInById(id);
        return checkIn.getGuests();
    }

    public Guest addGuestToCheckIn(Long id, Guest guest) {
        CheckIn checkIn = getCheckInById(id);
        List<Guest> guests = checkIn.getGuests();
        guests.add(guest);
        checkInRepository.save(checkIn);
        return guest;
    }
}