import java.util.*;

class ParkingLot {
    private int capacity;
    private Map<Integer, Car> slots;
    private Map<String, Integer> regToSlot;
    private Map<String, List<Integer>> colorToSlots;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.slots = new HashMap<>();
        this.regToSlot = new HashMap<>();
        this.colorToSlots = new HashMap<>();
    }

    public String park(String regNum, String color) {
        if (slots.size() >= capacity) {
            return "Sorry, the parking lot is full.";
        }

        int slot = getNearestSlot();
        slots.put(slot, new Car(regNum, color));
        regToSlot.put(regNum, slot);

        colorToSlots.putIfAbsent(color, new ArrayList<>());
        colorToSlots.get(color).add(slot);

        return "Allocated slot number: " + slot;
    }

    public String leave(int slot) {
        if (!slots.containsKey(slot)) {
            return "Slot number " + slot + " is already empty.";
        }

        Car car = slots.remove(slot);
        regToSlot.remove(car.getRegNum());
        colorToSlots.get(car.getColor()).remove(Integer.valueOf(slot));

        return "Slot number " + slot + " is free.";
    }

    public String registrationNumbersForCarsWithColor(String color) {
        if (!colorToSlots.containsKey(color)) {
            return "Not found.";
        }

        List<Integer> slots = colorToSlots.get(color);
        List<String> regNums = new ArrayList<>();
        for (int slot : slots) {
            regNums.add(this.slots.get(slot).getRegNum());
        }

        return String.join(", ", regNums);
    }

    public String slotNumbersForCarsWithColor(String color) {
        if (!colorToSlots.containsKey(color)) {
            return "Not found.";
        }

        List<Integer> slots = colorToSlots.get(color);
        List<String> slotNumbers = new ArrayList<>();
        for (int slot : slots) {
            slotNumbers.add(String.valueOf(slot));
        }

        return String.join(", ", slotNumbers);
    }

    public String slotNumberForRegistrationNumber(String regNum) {
        Integer slot = regToSlot.get(regNum);
        return slot != null ? String.valueOf(slot) : "Not found.";
    }

    private int getNearestSlot() {
        for (int i = 1; i <= capacity; i++) {
            if (!slots.containsKey(i)) {
                return i;
            }
        }
        return -1; // Shouldn't happen due to capacity check in park method
    }

    private static class Car {
        private String regNum;
        private String color;

        public Car(String regNum, String color) {
            this.regNum = regNum;
            this.color = color;
        }

        public String getRegNum() {
            return regNum;
        }

        public String getColor() {
            return color;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = null;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String[] command = scanner.nextLine().split(" ");
            switch (command[0]) {
                case "create_parking_lot":
                    int capacity = Integer.parseInt(command[1]);
                    parkingLot = new ParkingLot(capacity);
                    System.out.println("Created a parking lot with " + capacity + " slots");
                    break;
                case "park":
                    if (parkingLot != null) {
                        String regNum = command[1];
                        String color = command[2];
                        System.out.println(parkingLot.park(regNum, color));
                    } else {
                        System.out.println("Please create a parking lot first.");
                    }
                    break;
                case "leave":
                    if (parkingLot != null) {
                        int slot = Integer.parseInt(command[1]);
                        System.out.println(parkingLot.leave(slot));
                    } else {
                        System.out.println("Please create a parking lot first.");
                    }
                    break;
                case "registration_numbers_for_cars_with_colour":
                    if (parkingLot != null) {
                        String color = command[1];
                        System.out.println(parkingLot.registrationNumbersForCarsWithColor(color));
                    } else {
                        System.out.println("Please create a parking lot first.");
                    }
                    break;
                case "slot_numbers_for_cars_with_colour":
                    if (parkingLot != null) {
                        String color = command[1];
                        System.out.println(parkingLot.slotNumbersForCarsWithColor(color));
                    } else {
                        System.out.println("Please create a parking lot first.");
                    }
                    break;
                case "slot_number_for_registration_number":
                    if (parkingLot != null) {
                        String regNum = command[1];
                        System.out.println(parkingLot.slotNumberForRegistrationNumber(regNum));
                    } else {
                        System.out.println("Please create a parking lot first.");
                    }
                    break;
                case "exit":
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid command.");
            }
        }
    }
}
