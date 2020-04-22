package modules.parkinglot;

import java.util.ArrayList;

import modules.parkinglot.generatelot.GenerateLot;
import modules.parkingspot.*;
import modules.size.Size;

public class ParkingLot implements IParkingLot {

    private static ParkingLot instance = null;

    public ArrayList<ParkingSpot> LotStructure = new ArrayList<ParkingSpot>();

    private ParkingLot() {
        generateLotStructure();
    }

    private void generateLotStructure() {
        LotStructure = GenerateLot.process();
    }

    public static ParkingLot getInstance() {
        if ( instance == null ) {
            instance = new ParkingLot();
        }

        return instance;
    }

    public ParkingSpot[] getAllSpots() {
        int totalSpots = 0;

        // TODO - fetch total spots

        ParkingSpot[] spots = new ParkingSpot[totalSpots];

        return spots;
    }

    public ParkingSpot[] getSpotsBySize(Size size) {
        int totalSpots = 0;

        // TODO - fetch total spots

        ParkingSpot[] spots = new ParkingSpot[totalSpots];

        return spots;
    }

    public boolean updateLot(int spotID, boolean isAvailable) {
        // TODO - update lot

        return true;
    }
}