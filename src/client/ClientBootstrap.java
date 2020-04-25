package client;

public class ClientBootstrap {

    public static void Run() {
        int totalTests = 0;
        int totalPassed = 0;
        int totalFailed = 0;

        if (TestMotorcycle.TestParkThreeMotorcyclesAndNotFourth()) {
            totalTests += 1;
            totalPassed += 1;
        } else {
            totalTests += 1;
            totalFailed += 1;
        }

        if (TestMotorcycle.TestParkNoneMotorcycles()) {
            totalTests += 1;
            totalPassed += 1;
        } else {
            totalTests += 1;
            totalFailed += 1;
        }

        System.out.printf(
            "\nTOTAL TESTS : %d; TOTAL PASSED : %d; TOTAL FAILED : %d",
            totalTests, totalPassed, totalFailed
        );
    }

}