package client;

import helper.Helper;
import modules.parkinglot.ParkingLot;
import modules.parkingmanager.ParkingManager;
import modules.parkingspot.ParkingSpot;
import modules.vehicle.IVehicle;
import modules.vehicle.car.Car;
import modules.size.Size;

public class TestCar {

    public static TestMetric Run() {
        int totalTests = 0;
        int totalPassed = 0;
        int totalFailed = 0;

        if (TestParkThreeCarsInMEDIUMSpotAndFourthInLARGESpot()) {
            totalTests += 1;
            totalPassed += 1;
        } else {
            totalTests += 1;
            totalFailed += 1;
        }

        if (Test_ParkFirstInMEDIUM_ParkSecondInLARGE_UnparkFirst_ParkThirdInMEDIUM()) {
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

    public static boolean TestParkThreeCarsInMEDIUMSpotAndFourthInLARGESpot() {
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

        // Car can be parked either in MEDIUM OR LARGE

        int spotID1 = 0;
        IVehicle car1 = new Car();
        Size[] carSizes1 = car1.getSize();
        if (carSizes1.length > 0) {
            for (int i = 0; i < carSizes1.length; i++) {
                spotID1 = manager.park(carSizes1[i]);
                if (spotID1 != -1) {
                    break;
                }
            }
        }

        int spotID2 = 0;
        IVehicle car2 = new Car();
        Size[] carSizes2 = car2.getSize();
        if (carSizes2.length > 0) {
            for (int i = 0; i < carSizes2.length; i++) {
                spotID2 = manager.park(carSizes2[i]);
                if (spotID2 != -1) {
                    break;
                }
            }
        }

        int spotID3 = 0;
        IVehicle car3 = new Car();
        Size[] carSizes3 = car3.getSize();
        if (carSizes3.length > 0) {
            for (int i = 0; i < carSizes3.length; i++) {
                spotID3 = manager.park(carSizes3[i]);
                if (spotID3 != -1) {
                    break;
                }
            }
        }

        int spotID4 = 0;
        IVehicle car4 = new Car();
        Size[] carSizes4 = car4.getSize();
        if (carSizes4.length > 0) {
            for (int i = 0; i < carSizes4.length; i++) {
                spotID4 = manager.park(carSizes4[i]);
                if (spotID4 != -1) {
                    break;
                }
            }
        }
        ParkingSpot p4 = lot.LotStructureMap.get(spotID4);
        // /RUN ------------------------------------

        // VERIFY ------------------------------------
        if (Helper.AreAllEqual(spotID1, spotID2, spotID3, spotID4)) {
            System.out.printf(
                "\nTestParkThreeCarsInMEDIUMSpotAndFourthInLARGESpot(): " +
                "FAIL : spotID1 = %d; spotID2 = %d;" +
                " spotID3 = %d; spotID4 = %d;",
                spotID1, spotID2, spotID3, spotID4
            );
        }
        else if (p4.SpotType != Size.LARGE) {
            System.out.printf(
                "\nTestParkThreeCarsInMEDIUMSpotAndFourthInLARGESpot(): " +
                "FAIL : Unable to park in LARGE spot " +
                "for spotID4 = %d; parked in SpotType = %s;", spotID4, p4.SpotType
            );
        }
        else {
            System.out.printf(
                "\nTestParkThreeCarsInMEDIUMSpotAndFourthInLARGESpot(): " +
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

    public static boolean Test_ParkFirstInMEDIUM_ParkSecondInLARGE_UnparkFirst_ParkThirdInMEDIUM() {
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

        // 1. Park Car 1 - MEDIUM SPOT
        int spotID1 = 0;
        IVehicle car1 = new Car();
        Size[] carSizes1 = car1.getSize();
        if (carSizes1.length > 0) {
            for (int i = 0; i < carSizes1.length; i++) {
                spotID1 = manager.park(carSizes1[i]);
                if (spotID1 != -1) {
                    break;
                }
            }
        }
        ParkingSpot p1 = lot.LotStructureMap.get(spotID1);
        // VERIFY ------------------------------------
        if (spotID1 == -1 || p1.SpotType != Size.MEDIUM) {
            System.out.printf(
                "\nTest_ParkFirstInMEDIUM_ParkSecondInLARGE_UnparkFirst_ParkThirdInMEDIUM(): " +
                "FAIL : spotID1 = %d; SpotType = %s;",
                spotID1, p1.SpotType
            );

            // CLEANUP
            lot.debugClearSingletonInstanceForTesting();
            return pass;
        }

        // 2. Park Car 2 - LARGE SPOT
        int spotID2 = 0;
        IVehicle car2 = new Car();
        Size[] carSizes2 = car2.getSize();
        if (carSizes2.length > 0) {
            for (int i = 0; i < carSizes2.length; i++) {
                spotID2 = manager.park(carSizes2[i]);
                if (spotID2 != -1) {
                    break;
                }
            }
        }
        ParkingSpot p2 = lot.LotStructureMap.get(spotID2);
        // VERIFY ------------------------------------
        if (spotID2 == -1 || p2.SpotType != Size.LARGE) {
            System.out.printf(
                "\nTest_ParkFirstInMEDIUM_ParkSecondInLARGE_UnparkFirst_ParkThirdInMEDIUM(): " +
                "FAIL : spotID2 = %d; SpotType = %s;",
                spotID2, p2.SpotType
            );

            // CLEANUP
            lot.debugClearSingletonInstanceForTesting();
            return pass;
        }

        // 3. FAIL To Park Car 3
        int spotID3 = 0;
        IVehicle car3 = new Car();
        Size[] carSizes3 = car3.getSize();
        if (carSizes3.length > 0) {
            for (int i = 0; i < carSizes3.length; i++) {
                spotID3 = manager.park(carSizes3[i]);
                if (spotID3 != -1) {
                    break;
                }
            }
        }
        // VERIFY ------------------------------------
        if (spotID3 != -1) {
            System.out.printf(
                "\nTest_ParkFirstInMEDIUM_ParkSecondInLARGE_UnparkFirst_ParkThirdInMEDIUM(): " +
                "FAIL : spotID3 = %d;",
                spotID3
            );

            // CLEANUP
            lot.debugClearSingletonInstanceForTesting();
            return pass;
        }

        // 4. Unpark Car 1
        if (!manager.unpark(spotID1)) {
            System.out.printf(
                "\nTest_ParkFirstInMEDIUM_ParkSecondInLARGE_UnparkFirst_ParkThirdInMEDIUM(): " +
                "FAIL : Unable to unpark spotID1: %d",
                spotID1
            );

            // CLEANUP
            lot.debugClearSingletonInstanceForTesting();
            return pass;
        }

        // 1. Try Parking Car 3 Again!!
        for (int i = 0; i < carSizes3.length; i++) {
            spotID3 = manager.park(carSizes3[i]);
            if (spotID3 != -1) {
                break;
            }
        }
        ParkingSpot p3 = lot.LotStructureMap.get(spotID3);
        // VERIFY ------------------------------------
        if (spotID3 == -1 || p3.SpotType != Size.MEDIUM) {
            System.out.printf(
                "\nTest_ParkFirstInMEDIUM_ParkSecondInLARGE_UnparkFirst_ParkThirdInMEDIUM(): " +
                "FAIL : spotID3 = %d; SpotType = %s;",
                spotID3, p3.SpotType
            );

            // CLEANUP
            lot.debugClearSingletonInstanceForTesting();
            return pass;
        } else {
            System.out.printf(
                "\nTest_ParkFirstInMEDIUM_ParkSecondInLARGE_UnparkFirst_ParkThirdInMEDIUM(): " +
                "PASS : spotID3 = %d; SpotType = %s;",
                spotID3, p3.SpotType
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