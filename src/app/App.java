package app;

import client.ClientBootstrap;

// import modules.parkinglot.*;
// import modules.parkingspot.*;
// import modules.size.Size;

public class App {
    public static void main(String[] args) throws Exception {
        ClientBootstrap.Run();
    }

    public static void test() {
        // System.out.println("Hello Java");

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

        // ParkingLot p = ParkingLot.getInstance();
        // System.out.println(p);
        // ParkingLot p1 = ParkingLot.getInstance();
        // System.out.println(p1);

        // System.out.println("p");
        // for (ParkingSpot s : p.LotStructure) {
        //     String IsAvailable = "true";
        //     if (s.IsAvailable == false) {
        //         IsAvailable = "false";
        //     }

        //     System.out.println(
        //         "SpotID : " + Integer.toString(s.SpotID) +
        //         " IsAvailable : " + IsAvailable +
        //         " Level : " + Integer.toString(s.Level) +
        //         " RowNumber : " + Integer.toString(s.RowNumber) +
        //         " SpotNumber : " + Integer.toString(s.SpotNumber) +
        //         " SpotType : " + s.SpotType.toString()
        //     );
        // }

        // System.out.println("p1");
        // for (ParkingSpot s : p1.LotStructure) {
        //     System.out.println(s.SpotID);
        // }
    }
}