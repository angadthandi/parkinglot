package client;

import modules.parkinglot.ParkingLot;
import modules.parkingmanager.ParkingManager;
import modules.vehicle.IVehicle;
import modules.vehicle.bus.Bus;
import modules.size.Size;

public class TestBus {

    public static TestMetric Run() {
        int totalTests = 0;
        int totalPassed = 0;
        int totalFailed = 0;

        if (TestParkOneBus()) {
            totalTests += 1;
            totalPassed += 1;
        } else {
            totalTests += 1;
            totalFailed += 1;
        }

        TestMetric t = new TestMetric();
        t.Total = totalTests;
        t.Pass = totalPassed;
        t.Fail = totalFailed;

        return t;
    }

    public static boolean TestParkOneBus() {
        boolean pass = false;

        // SETUP ------------------------------------
        int totalLevels = 1;
        int totalRows = 3;
        int totalSpots = 3;

        ParkingLot lot = ParkingLot.getInstance(
            totalLevels,
            totalRows,
            totalSpots
        );
        ParkingManager manager = new ParkingManager(lot);
        // /SETUP ------------------------------------

        // RUN ------------------------------------
        int spotID1 = 0;
        IVehicle bus1 = new Bus();
        Size[] busSizes1 = bus1.getSize();
        if (busSizes1.length > 0) {
            spotID1 = manager.park(busSizes1[0]);
        }
        // /RUN ------------------------------------

        // VERIFY ------------------------------------
        if (spotID1 == -1) {
            System.out.printf(
                "\nTestParkOneBus(): " +
                "FAIL : spotID1 = %d;", spotID1
            );
        }
        else {
            System.out.printf(
                "\nTestParkOneBus(): " +
                "PASS : spotID1 = %d;",
                spotID1
            );

            pass = true;
        }
        // /VERIFY ------------------------------------

        // CLEANUP
        lot.debugClearSingletonInstanceForTesting();

        return pass;
    }

}