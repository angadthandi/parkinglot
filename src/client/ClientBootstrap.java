package client;

public class ClientBootstrap {

    public static void Run() {
        int totalTests = 0;
        int totalPassed = 0;
        int totalFailed = 0;

        TestMetric motorcycle = TestMotorcycle.Run();
        totalTests += motorcycle.Total;
        totalPassed += motorcycle.Pass;
        totalFailed += motorcycle.Fail;

        TestMetric car = TestCar.Run();
        totalTests += car.Total;
        totalPassed += car.Pass;
        totalFailed += car.Fail;

        TestMetric bus = TestBus.Run();
        totalTests += bus.Total;
        totalPassed += bus.Pass;
        totalFailed += bus.Fail;

        System.out.printf(
            "\nTOTAL TESTS : %d; TOTAL PASSED : %d; TOTAL FAILED : %d",
            totalTests, totalPassed, totalFailed
        );
    }

}