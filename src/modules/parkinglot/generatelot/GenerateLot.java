package modules.parkinglot.generatelot;

import java.util.Map;
import java.util.HashMap;

import modules.parkingspot.*;
import modules.size.Size;

public class GenerateLot {

    public static Map<Integer, ParkingSpot> process() {
        Map<Integer, ParkingSpot> LotStructureMap = new HashMap<Integer, ParkingSpot>();

        for (int level = 1; level <= 3; level++) {

            for (int row = 1; row <= 3; row++) {

                Size size = getSizeByRow(row);

                for (int spotNumber = 1; spotNumber <= 5; spotNumber++) {

                    ParkingSpot spot = new ParkingSpot();
                    spot.SpotID = getSpotID(level, row, spotNumber);
                    spot.IsAvailable = true;
                    spot.Level = level;
                    spot.RowNumber = row;
                    spot.SpotNumber = spotNumber;
                    spot.SpotType = size;

                    LotStructureMap.put(spot.SpotID, spot);

                }
            }

        }
        System.out.println(LotStructureMap);

        return LotStructureMap;
    }

    private static int getSpotID(int level, int row, int spotNumber) {
        int spotID = 0;
        String strSpotID = Integer.toString(level) +
                            Integer.toString(row) +
                            Integer.toString(spotNumber);

        try {
            spotID = Integer.parseInt(strSpotID);
        }
        catch (NumberFormatException e) {
            System.out.println("getSpotID() : unable to convert string to int error: " + e);
        }

        return spotID;
    }

    private static Size getSizeByRow(int row) {
        switch (row) {
            case 1:
                return Size.SMALL;
            case 2:
                return Size.MEDIUM;
            case 3:
                return Size.LARGE;
        }

        System.out.println("getSizeByRow() : Invalid row : " + row);
        return Size.MEDIUM;
    }

}