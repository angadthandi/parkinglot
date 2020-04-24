package modules.parkinglot;

import java.util.ArrayList;
import modules.parkingspot.*;
import modules.size.*;

public interface IParkingLot {
    ArrayList<ParkingSpot> getAllSpots();
    ArrayList<ParkingSpot> getSpotsBySize(Size size);
    boolean updateLot(int spotID, boolean isAvailable);
}