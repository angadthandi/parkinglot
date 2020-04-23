package modules.parkingmanager;

import modules.parkinglot.*;
import modules.size.*;

public class ParkingManager implements IParkingManager {

    public ParkingManager(IParkingLot i) {
        // store reference to IParkingLot,
        // to read/update parking lot structure
    }

    public int park(Size size) {
        int spotID = 0;

        // TODO implement park

        return spotID;
    }

    public boolean unpark(int spotID) {

        // TODO implement unpark

        return true;
    }
}