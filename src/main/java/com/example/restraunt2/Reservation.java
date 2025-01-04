package com.example.restraunt2;
import java.util.Date;

public class Reservation {
    static int  reservationId=0;
    Date dateTime;
    int partySize;

    public Reservation(int reservationid, Date dateTime, int partySize) {
        reservationId = reservationid;
        this.dateTime = dateTime;
        this.partySize = partySize;
    }

    public Reservation() {
        reservationId ++;
        dateTime = new Date();
        partySize = 1;
    }
}
