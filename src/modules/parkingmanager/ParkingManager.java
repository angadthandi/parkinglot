package modules.parkingmanager;

import java.util.ArrayList;
import modules.parkinglot.*;
import modules.parkingspot.ParkingSpot;
import modules.size.*;

public class ParkingManager implements IParkingManager {

    private IParkingLot parkingLot;

    public ParkingManager(IParkingLot i) {
        // store reference to IParkingLot,
        // to read/update parking lot structure
        parkingLot = i;
    }

    // Can change/extend park()
    // to take "IVehicle" as a param instead of "Size",
    // so that a vehicle which needs more than 1 spot to park
    // can be handled separately & returns ArrayList of SpotIDs.
    public int park(Size size) {
        ArrayList<ParkingSpot> spots = parkingLot.getSpotsBySize(size);
        int totalSpots = spots.size();
        if (totalSpots == 0) {
            return -1;
        }

        ParkingSpot spot = spots.get(0);
        spot.IsAvailable = false;

        return spot.SpotID;
    }

    public boolean unpark(int spotID) {
        parkingLot.updateLot(spotID, true);

        return true;
    }
}