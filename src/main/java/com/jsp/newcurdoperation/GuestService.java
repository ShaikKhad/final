package com.jsp.newcurdoperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GuestService {
    
    @Autowired
    private GuestRepository guestRepository;
    
    public List<Guest> getAllGuests(Pageable pageable) {
        return (List<Guest>) guestRepository.findAll(pageable);
    }
    
    public Guest getGuestById(Long id) {
        return guestRepository.findById(id).orElseThrow();
    }
    
    public Guest createGuest(Guest guest) {
        return guestRepository.save(guest);
    }
    
    public Guest updateGuest(Long id, Guest guest) {
        Guest existingGuest = getGuestById(id);
        existingGuest.setGuestName(guest.getGuestName());
        existingGuest.setGuestEmail(guest.getGuestEmail());
        return guestRepository.save(existingGuest);
    }
    
    public void deleteGuest(Long id) {
        guestRepository.deleteById(id);
    }
    public void removeGuestFromCheckIn(Long id, Long guestId) {
        CheckIn checkIn = new CheckIn();
        List<Guest> guests = checkIn.getGuests();
        Guest guestToRemove = guests.stream()
                .filter(guest -> guest.getId().equals(guestId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Guest not found in check-in"));
        guests.remove(guestToRemove);
        CheckIn save = new CheckIn();
    }
	
}