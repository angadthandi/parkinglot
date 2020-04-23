package app;

import modules.parkinglot.*;
import modules.parkingspot.*;
// import modules.size.Size;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");

        // for (Size cName : Size.values()) {
		// 	System.out.println(
        //         "Size Value: " + cName.getValue() +
        //         " - Size Name: " + cName);
        // }
        
        // System.out.println(Size.SMALL + " : " + Size.SMALL.getValue());
        // System.out.println(Size.MEDIUM + " : " + Size.MEDIUM.getValue());
        // System.out.println(Size.LARGE + " : " + Size.LARGE.getValue());

        // ParkingSpot spot = new ParkingSpot();
        // spot.SpotID = 1;
        // spot.IsAvailable = true;
        // spot.Level = 1;
        // spot.RowNumber = 1;
        // spot.SpotNumber = 1;
        // spot.SpotType = Size.SMALL;

        // System.out.println(spot.SpotID);
        // System.out.println(spot.IsAvailable);
        // System.out.println(spot.Level);
        // System.out.println(spot.RowNumber);
        // System.out.println(spot.SpotNumber);
        // System.out.println(spot.SpotType);

        ParkingLot p = ParkingLot.getInstance();
        // System.out.println(p);
        // ParkingLot p1 = ParkingLot.getInstance();
        // System.out.println(p1);

        // System.out.println("p");
        for (ParkingSpot s : p.LotStructure) {
            System.out.println(s.SpotID);
        }

        // System.out.println("p1");
        // for (ParkingSpot s : p1.LotStructure) {
        //     System.out.println(s.SpotID);
        // }
    }
}