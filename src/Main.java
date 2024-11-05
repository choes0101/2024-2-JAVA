import java.util.Scanner;

// Vehicle 클래스: 차량의 정보를 관리
class Vehicle {
  String plateNumber; // 차량 번호
  String vehicleType; // 차량 종류 (소형차, 대형차 등)

  Vehicle(String plateNumber, String vehicleType) {
    this.plateNumber = plateNumber;
    this.vehicleType = vehicleType;
  }

  String getPlateNumber() {
    return plateNumber;
  }

  String getVehicleType() {
    return vehicleType;
  }

  public String toString() {
    return "차량 번호='" + plateNumber + "', 차량 종류='" + vehicleType + "'";
  }
}

// ParkingSpot 클래스: 주차 공간 관리
class ParkingSpot {
  int spotNumber; // 주차 공간 번호
  Vehicle vehicle; // 주차된 차량

  ParkingSpot(int spotNumber) {
    this.spotNumber = spotNumber;
    this.vehicle = null; // 주차 공간이 비어있음을 나타냄
  }

  boolean isAvailable() {
    return vehicle == null;
  }

  void parkVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
  }

  void removeVehicle() {
    this.vehicle = null;
  }

  Vehicle getVehicle() {
    return vehicle;
  }

  public String toString() {
    return "주차 공간 번호=" + spotNumber + ", 차량=" + (vehicle == null ? "비어 있음" : vehicle.getPlateNumber());
  }
}

// ParkingLot 클래스: 주차장 관리
class ParkingLot {
  ParkingSpot[] spots; // 주차 공간 배열
  String[] records; // 차량 번호와 기록

  ParkingLot(int numSpots) {
    spots = new ParkingSpot[numSpots];
    records = new String[numSpots];

    for (int i = 0; i < numSpots; i++) {
      spots[i] = new ParkingSpot(i + 1);
    }
  }

  void parkVehicle(Vehicle vehicle) {
    for (int i = 0; i < spots.length; i++) {
      if (spots[i].isAvailable()) {
        spots[i].parkVehicle(vehicle);
        records[i] = "차량 " + vehicle.getPlateNumber() + "이(가) " + (i + 1) + "번 주차 공간에 주차되었습니다.";
        System.out.println(records[i]);
        return;
      }
    }
    System.out.println("주차할 수 있는 공간이 없습니다: " + vehicle.getPlateNumber());
  }

  void removeVehicle(String plateNumber) {
    for (int i = 0; i < spots.length; i++) {
      if (spots[i].getVehicle() != null && spots[i].getVehicle().getPlateNumber().equals(plateNumber)) {
        System.out.println("차량 " + plateNumber + "이(가) " + (i + 1) + "번 주차 공간에서 출차되었습니다.");
        spots[i].removeVehicle();
        records[i] = null; // 기록을 지움
        return;
      }
    }
    System.out.println("차량 " + plateNumber + "을(를) 찾을 수 없습니다.");
  }

  void displayAvailableSpots() {
    for (int i = 0; i < spots.length; i++) {
      System.out.println(spots[i]);
    }
  }
}

// ParkingMain 클래스: 사용자 입력 처리 및 프로그램 실행
public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ParkingLot parkingLot = new ParkingLot(3); // 3개의 주차 공간이 있는 주차장

    while (true) {
      System.out.println("메뉴를 선택하세요: ");
      System.out.println("1. 차량 주차");
      System.out.println("2. 차량 출차");
      System.out.println("3. 주차 공간 상태 확인");
      System.out.println("4. 종료");
      int choice = scanner.nextInt();

      if (choice == 1) { // 차량 주차
        System.out.println("차량 번호를 입력하세요: ");
        String plateNumber = scanner.next();
        System.out.println("차량 종류를 입력하세요(소형차/대형차): ");
        String vehicleType = scanner.next();
        Vehicle vehicle = new Vehicle(plateNumber, vehicleType);
        parkingLot.parkVehicle(vehicle);
      } else if (choice == 2) { // 차량 출차
        System.out.println("출차할 차량 번호를 입력하세요: ");
        String plateNumber = scanner.next();
        parkingLot.removeVehicle(plateNumber);
      } else if (choice == 3) { // 주차 공간 상태 확인
        parkingLot.displayAvailableSpots();
      } else if (choice == 4) { // 프로그램 종료
        System.out.println("프로그램을 종료합니다.");
        break;
      } else {
        System.out.println("잘못된 입력입니다. 다시 시도하세요.");
      }
    }

    scanner.close();
  }
}
