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

    private ParkingLot() {
        generateLotStructure();
    }

    private void generateLotStructure() {
        LotStructureMap = GenerateLot.process();
    }

    public static ParkingLot getInstance() {
        if ( instance == null ) {
            instance = new ParkingLot();
        }

        return instance;
    }

    public ArrayList<ParkingSpot> getAllSpots() {
        ArrayList<ParkingSpot> spots = new ArrayList<ParkingSpot>();
        int totalSpots = LotStructureMap.size();

        for (int i=0; i<totalSpots; i++) {
            ParkingSpot p = LotStructureMap.get(i);
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
        int totalSpots = LotStructureMap.size();

        for (int i=0; i<totalSpots; i++) {
            ParkingSpot p = LotStructureMap.get(i);
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