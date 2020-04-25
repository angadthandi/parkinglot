package modules.parkinglot;

// import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

import modules.parkinglot.generatelot.GenerateLot;
import modules.parkingspot.*;
import modules.size.Size;

public class ParkingLot implements IParkingLot {

    private static ParkingLot instance = null;

    public HashMap<Integer, ParkingSpot> LotStructureMap = new HashMap<Integer, ParkingSpot>();

    // DEBUG METHODS FOR TESTING ----------------------------------------------------------
    /**
     * WARNING: BREAKS SINGLETON DESIGN PATTERN
     * ONLY DONE FOR RUNNING MULTIPLE TEST CASES AT ONCE
     */
    public void debugClearSingletonInstanceForTesting() {
        instance = null;
    }

    public void debugLotStructureMap() {

        for (HashMap.Entry mapElement : LotStructureMap.entrySet()) {
            ParkingSpot p = (ParkingSpot)mapElement.getValue();

            System.out.printf(
                "\n SpotID: %d; " +
                "IsAvailable: %s; " +
                "Level: %d; " +
                "RowNumber: %d; " +
                "SpotNumber: %d; " +
                "SpotType: %s; ",

                p.SpotID,
                p.IsAvailable,
                p.Level ,
                p.RowNumber,
                p.SpotNumber,
                p.SpotType
            );
        }

    }
    // /DEBUG METHODS FOR TESTING ----------------------------------------------------------

    private ParkingLot(
        int totalLevels,
        int totalRows,
        int totalSpots
    ) {
        LotStructureMap = GenerateLot.process(
            totalLevels,
            totalRows,
            totalSpots
        );
    }

    /**
     * @param totalLevels // min 1, to generate structure
     * @param totalRows // min 3, to generate all Sizes of Spots
     * @param totalSpots // min 5, to accommodate BUS
     */
    public static ParkingLot getInstance(
        int totalLevels,
        int totalRows,
        int totalSpots
    ) {
        if ( instance == null ) {
            instance = new ParkingLot(
                totalLevels,
                totalRows,
                totalSpots
            );
        }

        return instance;
    }

    public ArrayList<ParkingSpot> getAllSpots() {
        ArrayList<ParkingSpot> spots = new ArrayList<ParkingSpot>();

        for (HashMap.Entry mapElement : LotStructureMap.entrySet()) { 
            // int key = (int)mapElement.getKey();
            ParkingSpot p = (ParkingSpot)mapElement.getValue();

            if (p != null) {
                if (p.IsAvailable) {
                    spots.add(p);
                }
            }
        }

        return spots;
    }

    public ArrayList<ParkingSpot> getSpotsBySize(Size size) {
        ArrayList<ParkingSpot> spots = new ArrayList<ParkingSpot>();

        for (HashMap.Entry mapElement : LotStructureMap.entrySet()) { 
            // int key = (int)mapElement.getKey();
            ParkingSpot p = (ParkingSpot)mapElement.getValue();

            if (p != null) {
                if (p.IsAvailable && p.SpotType == size) {
                    spots.add(p);
                }
            }
        }

        return spots;
    }

    public boolean updateLot(int spotID, boolean isAvailable) {
        ParkingSpot spot = LotStructureMap.get(spotID);
        spot.IsAvailable = isAvailable;
        LotStructureMap.put(spotID, spot);

        return true;
    }
}