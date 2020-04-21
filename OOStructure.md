# OO Design Structure

##### Reference
https://leetcode.com/discuss/interview-question/object-oriented-design/124739/Parking-Lot-Design-Using-OO-Design/209225

---

## ParkingSpot Class
 #### Attributes:
 - spotID int
 - isAvailable bool
 - level int
 - rowNumber int
 - spotNumber int
 - spotType Size

## Size Class
 #### Attributes:
 - size enum // __Small, Compact, Large__

---

## IParkingLot Interface
 #### Methods:
 - getAllSpots() ParkingSpot[]
 - getSpotsBySize(Size) ParkingSpot[]
 - updateLot(spotID, isAvailable)

## ParkingLot Class implements IParkingLot
 #### Attributes:
 - lotStructure Array[][]ParkingSpot
 #### Methods:
 - getAllSpots() ParkingSpot[]
 - getSpotsBySize(Size) ParkingSpot[]
 - updateLot(spotID, isAvailable)
 - ParkingLot( \
        totalLevels int, \
        rowsPerLevel int, \
        spotsPerRow int) \
// constructor - use __Singleton__ Object; produces __lotStructure__

```
Note: During "ParkingLot" initialization, "ParkingSpot" will be
multiplied by all size types (defined in "Size" Class),
to accommodate equal number of all sizes.

Sample ParkingLot:

Levels = 1
RowsPerLevel = 3
SpotsPerRow = 3 (3 x SMALL, 3 x COMPACT, 3 x LARGE)

    0       1       2       3           4       5          6       7       8
  ---------------------------------------------------------------------------
0 SMALL | SMALL | SMALL | COMPACT | COMPACT | COMPACT | LARGE | LARGE | LARGE
  ---------------------------------------------------------------------------
1 SMALL | SMALL | SMALL | COMPACT | COMPACT | COMPACT | LARGE | LARGE | LARGE
  ---------------------------------------------------------------------------
2 SMALL | SMALL | SMALL | COMPACT | COMPACT | COMPACT | LARGE | LARGE | LARGE
  ---------------------------------------------------------------------------

```

---

## IParkingManager Interface
 #### Methods:
 - park(Size) spotID
 - unpark(spotID)

## ParkingManager Class implements IParkingManager
 #### Methods:
 - ParkingManager(IParkingLot) \
 // ParkingManager takes in __IParkingLot__ and stores reference to \
 // IParkingLot. \
 // \
 // This class handles interaction between __ParkingLot & Vehicle__.

 - park(Size) spotID \
 // Park func takes in __Vehicle Size__ & fetches matching required \
 // size parking spots & allocates parking spot to vehicle, \
 // updating the __isAvailable=FALSE__ for that parking spot.
 // \
 // So next time when there is a query to park, only the spots \
 // with __isAvailable=TRUE__ are returned. \
 // \
 // Updates to __lotStructure__ are done using the __updateLot__ func \
 // provided by the __IParkingLot__ interface.

 - unpark(spotID) \
 // Unpark func takes in __spotID__ and updates __isAvailable=TRUE__ \
 // for that parking spot. \
 // \
 // Updates to __lotStructure__ are done using the __updateLot__ func \
 // provided by the __IParkingLot__ interface.

---

## IVehicle Interface
 #### Methods:
 - getSize() Size
 - getSpotsNeeded() int

### Motorcycle Class implements Vehicle
 #### Attributes:
 - licensePlate String
 - spotsNeeded int
 #### Methods:
 - getSize() Size
 - getSpotsNeeded() int

### Car Class implements Vehicle
 #### Attributes:
 - licensePlate String
 - spotsNeeded int
 #### Methods:
 - getSize() Size
 - getSpotsNeeded() int

### Bus Class implements Vehicle
 #### Attributes:
 - licensePlate String
 - spotsNeeded int
 #### Methods:
 - getSize() Size
 - getSpotsNeeded() int