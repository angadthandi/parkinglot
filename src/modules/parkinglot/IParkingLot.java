package modules.parkinglot;

import modules.parkingspot.*;
import modules.size.*;

public interface IParkingLot {
    ParkingSpot[] getAllSpots();
    ParkingSpot[] getSpotsBySize(Size size);
    boolean updateLot(int spotID, boolean isAvailable);
}