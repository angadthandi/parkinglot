package client;

import modules.parkinglot.ParkingLot;
import modules.parkingmanager.ParkingManager;
import modules.vehicle.IVehicle;
import modules.vehicle.motorcycle.Motorcycle;
import modules.size.Size;

public class ClientBootstrap {

    public static void Run() {
        ParkingLot lot = ParkingLot.getInstance();
        ParkingManager manager = new ParkingManager(lot);

        IVehicle motorcycle = new Motorcycle();
        Size[] motorcycleSizes = motorcycle.getSize();
        if (motorcycleSizes.length > 0) {
            int spotID = manager.park(motorcycleSizes[0]);
            System.out.println(spotID);
        }
    }

}