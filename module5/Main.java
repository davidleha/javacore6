package module5;

public class Main {
    public static void main(String[] args) {
        Controller ctrl = new Controller();
        Room[] rooms;

        System.out.println("------ Requesting rooms (price:10, persons:1, city:\"Шепетовка\");");
        rooms = ctrl.requestRooms(10,1,"Шепетовка");
        System.out.println("Requested rooms are:");
        printArray(rooms);

        System.out.println("------ Requesting rooms (price:25, persons:1, city:\"Шепетовка\");");
        rooms = ctrl.requestRooms(25,1,"Шепетовка");
        System.out.println("Requested rooms are:");
        printArray(rooms);

        System.out.println("------ Requesting rooms (price:20, persons:2, city:\"Шепетовка\");");
        rooms = ctrl.requestRooms(20,2,"Шепетовка");
        System.out.println("Requested rooms are:");
        printArray(rooms);

        API apiBookingCom = new BookingComAPI();
        API apiTripAdvisor = new TripAdvisorAPI();
        API apiGoogle = new GoogleAPI();

        System.out.println("------ Checking the same rooms on BookingCom and TripAdvisor");
        rooms = ctrl.check(apiBookingCom, apiTripAdvisor);
        System.out.println("The same rooms are:");
        printArray(rooms);

        System.out.println("------ Checking the same rooms on BookingCom and Google");
        rooms = ctrl.check(apiBookingCom, apiGoogle);
        System.out.println("The same rooms are:");
        printArray(rooms);

        System.out.println("------ Checking the same rooms on TripAdvisor and Google");
        rooms = ctrl.check(apiTripAdvisor, apiGoogle);
        System.out.println("The same rooms are:");
        printArray(rooms);

        ctrl.demoDAO();
    }

    static void printArray(Object[] obj) {
        int i = 0;
        while (obj[i] != null)
            System.out.println(obj[i++]);
        System.out.println();
    }
}
