package modules.vehicle.motorcycle;

import modules.size.*;
import modules.vehicle.IVehicle;

public class Motorcycle implements IVehicle {

    private String licensePlate;
    private int spotsNeeded = 1;

    public Size[] getSize() {
        return new Size[]{Size.SMALL};
    }

    public int getSpotsNeeded() {
        return spotsNeeded;
    }
}