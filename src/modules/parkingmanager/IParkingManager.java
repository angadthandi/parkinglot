package modules.parkingmanager;

import modules.size.Size;

public interface IParkingManager {
    // Can change/extend park()
    // to take "IVehicle" as a param instead of "Size",
    // so that a vehicle which needs more than 1 spot to park
    // can be handled separately & returns ArrayList of SpotIDs.
    int park(Size size);
    boolean unpark(int spotID);
}