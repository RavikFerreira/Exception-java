package Model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer roomNumber;
    private Date checkin;
    private Date checkout;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer roomNumber, Date checkin, Date checkout) {
        this.setRoomNumber(roomNumber);
        this.checkin=checkin;
        this.checkout=checkout;
    }

    public Date getCheckout() {
        return checkout;
    }
    public Date getCheckin() {
        return checkin;
    }
    public Integer getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Long duration(){
        Long diff = checkout.getTime() - checkin.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
    public void updateDates(Date checkin, Date checkout){
        this.checkin = checkin;
        this.checkout = checkout;
        
    }
    @Override
    public String toString() {
        return "Room "
        + roomNumber
        + ", check-in: "
        + sdf.format(checkin)
        + ", check-out: "
        + sdf.format(checkout)
        + ", "
        + duration()
        +" nights";
    }



}
