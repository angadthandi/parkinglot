package modules.parkinglot.generatelot;

// import java.util.Map;
import java.util.HashMap;

import modules.parkingspot.*;
import modules.size.Size;

public class GenerateLot {

    /**
     * @param totalLevels // min 1, to generate structure
     * @param totalRows // min 3, to generate all Sizes of Spots
     * @param totalSpots // min 5, to accommodate BUS
     */
    public static HashMap<Integer, ParkingSpot> process(
        int totalLevels,
        int totalRows,
        int totalSpots
    ) {
        HashMap<Integer, ParkingSpot> LotStructureMap = new HashMap<Integer, ParkingSpot>();

        for (int level = 1; level <= totalLevels; level++) {

            for (int row = 1; row <= totalRows; row++) {

                Size size = getSizeByRow(row);

                for (int spotNumber = 1; spotNumber <= totalSpots; spotNumber++) {

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