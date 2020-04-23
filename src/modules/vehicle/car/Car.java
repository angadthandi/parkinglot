package modules.vehicle.car;

import modules.size.*;
import modules.vehicle.IVehicle;

public class Car implements IVehicle {

    private String licensePlate;
    private int spotsNeeded = 1;

    public Size[] getSize() {
        return new Size[]{Size.MEDIUM, Size.LARGE};
    }

    public int getSpotsNeeded() {
        return spotsNeeded;
    }
}