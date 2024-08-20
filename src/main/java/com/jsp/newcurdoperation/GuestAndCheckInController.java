package com.jsp.newcurdoperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GuestAndCheckInController {
    @Autowired
    private GuestService guestService;

    @Autowired
    private CheckInService checkInService;


    @GetMapping("/guests")
    public Page<Guest> getAllGuests(@RequestParam int page, 
                                    @RequestParam int size, 
                                    @RequestParam String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return (Page<Guest>) guestService.getAllGuests(pageable);
    }

    @GetMapping("/guests/{id}")
    public Guest getGuest(@PathVariable Long id) {
        return guestService.getGuestById(id);
    }

    @PostMapping("/guests")
    public Guest createGuest(@RequestBody Guest guest) {
        return guestService.createGuest(guest);
    }

    @PutMapping("/guests/{id}")
    public Guest updateGuest(@PathVariable Long id, @RequestBody Guest guest) {
        return guestService.updateGuest(id, guest);
    }

    @DeleteMapping("/guests/{id}")
    public void deleteGuest(@PathVariable Long id) {
        guestService.deleteGuest(id);
    }


    @GetMapping("/check-ins")
    public Page<CheckIn> getAllCheckIns(@RequestParam int page, 
                                        @RequestParam int size, 
                                        @RequestParam String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return (Page<CheckIn>) checkInService.getAllCheckIns(pageable);
    }

    @GetMapping("/check-ins/{id}")
    public CheckIn getCheckIn(@PathVariable Long id) {
        return checkInService.getCheckInById(id);
    }

    @PostMapping("/check-ins")
    public CheckIn createCheckIn(@RequestBody CheckIn checkIn) {
        return checkInService.createCheckIn(checkIn);
    }

    @PutMapping("/check-ins/{id}")
    public CheckIn updateCheckIn(@PathVariable Long id, @RequestBody CheckIn checkIn) {
        return checkInService.updateCheckIn(id, checkIn);
    }

    @DeleteMapping("/check-ins/{id}")
    public void deleteCheckIn(@PathVariable Long id) {
        checkInService.deleteCheckIn(id);
    }


    @GetMapping("/check-ins/{id}/guests")
    public List<Guest> getGuestsForCheckIn(@PathVariable Long id) {
        return checkInService.getGuestsForCheckIn(id);
    }

    @PostMapping("/check-ins/{id}/guests")
    public Guest addGuestToCheckIn(@PathVariable Long id, @RequestBody Guest guest) {
        return checkInService.addGuestToCheckIn(id, guest);
    }

    @DeleteMapping("/check-ins/{id}/guests/{guestId}")
    public void removeGuestFromCheckIn(@PathVariable Long id, @PathVariable Long guestId) {
        checkInService.removeGuestFromCheckIn(id, guestId);
    }
}