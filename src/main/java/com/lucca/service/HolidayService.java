package com.lucca.service;

import com.lucca.entities.Holiday;
import com.lucca.repos.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HolidayService {

    @Autowired
    private HolidayRepository holidayRepository;

    public void addHolidayToUser(int holidayCount, int employeeId){
        Holiday holiday = new Holiday();
        holiday.setHolidayCount(holidayCount);
        holiday.setEmployeeId(employeeId);
        this.holidayRepository.save(holiday);
    }
}
