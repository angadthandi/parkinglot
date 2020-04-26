package modules.vehicle.bus;

import modules.size.*;
import modules.vehicle.IVehicle;

public class Bus implements IVehicle {

    private String licensePlate;
    private int spotsNeeded = 1;

    public Size[] getSize() {
        return new Size[]{Size.LARGE};
    }

    public int getSpotsNeeded() {
        return spotsNeeded;
    }
}