package modules.parkinglot.generatelot;

import java.util.ArrayList;

import modules.parkingspot.*;
import modules.size.Size;

public class GenerateLot {

    public static ArrayList<ParkingSpot> process() {
        // TODO create lotStructure
        System.out.println("generate lot structure!");

        ArrayList<ParkingSpot> LotStructure = new ArrayList<ParkingSpot>();

        ParkingSpot spot = new ParkingSpot();
        spot.SpotID = 1;
        spot.IsAvailable = true;
        spot.Level = 1;
        spot.RowNumber = 1;
        spot.SpotNumber = 1;
        spot.SpotType = Size.SMALL;

        LotStructure.add(spot);

        return LotStructure;
    }

}