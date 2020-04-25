package client;

import helper.Helper;
import modules.parkinglot.ParkingLot;
import modules.parkingmanager.ParkingManager;
import modules.vehicle.IVehicle;
import modules.vehicle.motorcycle.Motorcycle;
import modules.size.Size;

public class TestMotorcycle {

    public static TestMetric Run() {
        int totalTests = 0;
        int totalPassed = 0;
        int totalFailed = 0;

        if (TestParkThreeMotorcyclesAndNotFourth()) {
            totalTests += 1;
            totalPassed += 1;
        } else {
            totalTests += 1;
            totalFailed += 1;
        }

        if (TestParkNoneMotorcycles()) {
            totalTests += 1;
            totalPassed += 1;
        } else {
            totalTests += 1;
            totalFailed += 1;
        }

        if (Test_Park_NotAbleToParkSecond_Unpark_ParkSecond()) {
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

    public static boolean TestParkThreeMotorcyclesAndNotFourth() {
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
        IVehicle motorcycle1 = new Motorcycle();
        Size[] motorcycleSizes1 = motorcycle1.getSize();
        if (motorcycleSizes1.length > 0) {
            spotID1 = manager.park(motorcycleSizes1[0]);
        }

        int spotID2 = 0;
        IVehicle motorcycle2 = new Motorcycle();
        Size[] motorcycleSizes2 = motorcycle2.getSize();
        if (motorcycleSizes2.length > 0) {
            spotID2 = manager.park(motorcycleSizes2[0]);
        }

        int spotID3 = 0;
        IVehicle motorcycle3 = new Motorcycle();
        Size[] motorcycleSizes3 = motorcycle3.getSize();
        if (motorcycleSizes3.length > 0) {
            spotID3 = manager.park(motorcycleSizes3[0]);
        }

        int spotID4 = 0;
        IVehicle motorcycle4 = new Motorcycle();
        Size[] motorcycleSizes4 = motorcycle4.getSize();
        if (motorcycleSizes4.length > 0) {
            spotID4 = manager.park(motorcycleSizes4[0]);
        }
        // /RUN ------------------------------------

        // VERIFY ------------------------------------
        if (Helper.AreAllEqual(spotID1, spotID2, spotID3, spotID4)) {
            System.out.printf(
                "\nTestParkThreeMotorcyclesAndNotFourth(): " +
                "FAIL : spotID1 = %d; spotID2 = %d;" +
                " spotID3 = %d; spotID4 = %d;",
                spotID1, spotID2, spotID3, spotID4
            );
        }
        else if (spotID4!= -1) {
            System.out.printf(
                "\nTestParkThreeMotorcyclesAndNotFourth(): " +
                "FAIL : spotID4 = %d;", spotID4
            );
        }
        else {
            System.out.printf(
                "\nTestParkThreeMotorcyclesAndNotFourth(): " +
                "PASS : spotID1 = %d; spotID2 = %d;" +
                " spotID3 = %d; spotID4 = %d;",
                spotID1, spotID2, spotID3, spotID4
            );

            pass = true;
        }
        // /VERIFY ------------------------------------

        // CLEANUP
        lot.debugClearSingletonInstanceForTesting();

        return pass;
    }

    public static boolean TestParkNoneMotorcycles() {
        boolean pass = false;

        // SETUP ------------------------------------
        int totalLevels = 1;
        int totalRows = 1;
        int totalSpots = 0;

        ParkingLot lot = ParkingLot.getInstance(
            totalLevels,
            totalRows,
            totalSpots
        );
        ParkingManager manager = new ParkingManager(lot);
        // /SETUP ------------------------------------

        // RUN ------------------------------------
        int spotID1 = 0;
        IVehicle motorcycle1 = new Motorcycle();
        Size[] motorcycleSizes1 = motorcycle1.getSize();
        if (motorcycleSizes1.length > 0) {
            spotID1 = manager.park(motorcycleSizes1[0]);
        }

        int spotID2 = 0;
        IVehicle motorcycle2 = new Motorcycle();
        Size[] motorcycleSizes2 = motorcycle2.getSize();
        if (motorcycleSizes2.length > 0) {
            spotID2 = manager.park(motorcycleSizes2[0]);
        }

        int spotID3 = 0;
        IVehicle motorcycle3 = new Motorcycle();
        Size[] motorcycleSizes3 = motorcycle3.getSize();
        if (motorcycleSizes3.length > 0) {
            spotID3 = manager.park(motorcycleSizes3[0]);
        }

        int spotID4 = 0;
        IVehicle motorcycle4 = new Motorcycle();
        Size[] motorcycleSizes4 = motorcycle4.getSize();
        if (motorcycleSizes4.length > 0) {
            spotID4 = manager.park(motorcycleSizes4[0]);
        }
        // /RUN ------------------------------------

        // VERIFY ------------------------------------
        if (spotID1 != -1 || spotID2 != -1 || spotID3 != -1 || spotID4 != -1) {
            System.out.printf(
                "\nTestParkNoneMotorcycles(): " +
                "FAIL : spotID1 = %d; spotID2 = %d;" +
                " spotID3 = %d; spotID4 = %d;",
                spotID1, spotID2, spotID3, spotID4
            );
        }
        else {
            System.out.printf(
                "\nTestParkNoneMotorcycles(): " +
                "PASS : spotID1 = %d; spotID2 = %d;" +
                " spotID3 = %d; spotID4 = %d;",
                spotID1, spotID2, spotID3, spotID4
            );

            pass = true;
        }
        // /VERIFY ------------------------------------

        // CLEANUP
        lot.debugClearSingletonInstanceForTesting();

        return pass;
    }

    public static boolean Test_Park_NotAbleToParkSecond_Unpark_ParkSecond() {
        boolean pass = false;

        // SETUP ------------------------------------
        int totalLevels = 1;
        int totalRows = 3;
        int totalSpots = 1;

        ParkingLot lot = ParkingLot.getInstance(
            totalLevels,
            totalRows,
            totalSpots
        );
        ParkingManager manager = new ParkingManager(lot);
        // /SETUP ------------------------------------

        // RUN & VERIFY ------------------------------------

        // 1. Park Motorocycle 1
        int spotID1 = 0;
        IVehicle motorcycle1 = new Motorcycle();
        Size[] motorcycleSizes1 = motorcycle1.getSize();
        if (motorcycleSizes1.length > 0) {
            spotID1 = manager.park(motorcycleSizes1[0]);
        }
        // VERIFY ------------------------------------
        if (spotID1 == -1) {
            System.out.printf(
                "\nTest_Park_NotAbleToParkSecond_Unpark_ParkSecond(): " +
                "FAIL : spotID1 = %d;",
                spotID1
            );

            // CLEANUP
            lot.debugClearSingletonInstanceForTesting();
            return pass;
        }

        // 2. FAIL to Park Motorocycle 2
        int spotID2 = 0;
        IVehicle motorcycle2 = new Motorcycle();
        Size[] motorcycleSizes2 = motorcycle2.getSize();
        if (motorcycleSizes2.length > 0) {
            spotID2 = manager.park(motorcycleSizes2[0]);
        }
        // VERIFY ------------------------------------
        if (spotID2 != -1) {
            System.out.printf(
                "\nTest_Park_NotAbleToParkSecond_Unpark_ParkSecond(): " +
                "FAIL : spotID2 = %d;",
                spotID2
            );

            // CLEANUP
            lot.debugClearSingletonInstanceForTesting();
            return pass;
        }

        // 3. Unpark Motorocycle 1
        if (!manager.unpark(spotID1)) {
            System.out.printf(
                "\nTest_Park_NotAbleToParkSecond_Unpark_ParkSecond(): " +
                "FAIL : Unable to unpark spotID1: %d",
                spotID1
            );

            // CLEANUP
            lot.debugClearSingletonInstanceForTesting();
            return pass;
        }

        // 1. Try Parking Motorocycle 2 Again!!
        spotID2 = manager.park(motorcycleSizes2[0]);
        // VERIFY ------------------------------------
        if (spotID2 == -1) {
            System.out.printf(
                "\nTest_Park_NotAbleToParkSecond_Unpark_ParkSecond(): " +
                "FAIL : spotID2 = %d;",
                spotID2
            );

            // CLEANUP
            lot.debugClearSingletonInstanceForTesting();
            return pass;
        } else {
            System.out.printf(
                "\nTest_Park_NotAbleToParkSecond_Unpark_ParkSecond(): " +
                "PASS : spotID2 = %d;",
                spotID2
            );

            // If we are here, we passed all cases, set pass to TRUE
            pass = true;
        }

        // /RUN & VERIFY ------------------------------------

        // CLEANUP
        lot.debugClearSingletonInstanceForTesting();

        return pass;
    }
}