package com.example.ProjectJAVA.Payloads.Resquest;

import com.example.ProjectJAVA.Enums.BookingStatus;

import java.util.List;

public class BookingRequest {
    private Integer userId;
    private Integer showtimeId;
    private List<Integer> seatIds;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getShowtimeId() {
        return showtimeId;
    }

    public void setShowtimeId(Integer showtimeId) {
        this.showtimeId = showtimeId;
    }

    public List<Integer> getSeatIds() {
        return seatIds;
    }

    public void setSeatIds(List<Integer> seatIds) {
        this.seatIds = seatIds;
    }
}
