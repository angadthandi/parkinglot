package modules.parkingmanager;

import modules.size.Size;

public interface IParkingManager {
    int park(Size size);
    boolean unpark(int spotID);
}