package module5;

import java.util.Date;

public interface API {
    int MAX_ROOMS = 5; //public static final
    Room[] findRooms(int price, int persons, String city);
}

class BookingComAPI implements API {
    private ImplDAO roomsDAO = new ImplDAO("Rooms on BookingCom");
    private Room[] rooms = new Room[MAX_ROOMS]; // массив комнат, выбраных из бд
    {
        rooms[0] = new Room(100, 10, 1, new Date(117, 5-1, 1), "Хибара", "Шепетовка");
        rooms[1] = new Room(101, 15, 1, new Date(117, 5-1, 1), "Берлога", "Шепетовка");
        rooms[2] = new Room(102, 20, 2, new Date(117, 5-1, 1), "Берлога", "Шепетовка");
        rooms[3] = new Room(103, 25, 1, new Date(117, 5-1, 1), "На краю Света", "Шепетовка");
        rooms[4] = new Room(104, 35, 2, new Date(117, 5-1, 1), "На краю Света", "Шепетовка");
        for (int i = 0; i < MAX_ROOMS; i++)
            roomsDAO.save(rooms[i]);
    }
    private Room[] auxArr = new Room[MAX_ROOMS + 1]; //вспомогательный маасиив для rooms[], в кот. нулевая ссылка обозначает конец массива

    @Override
    public Room[] findRooms(int price, int persons, String city) { //price:0 значит выдает все имеющиеся комнаты
        System.out.println("Searching rooms on BookingCom...");
        Room r;
        roomsDAO.seekStart();
        int i = 0;
        while ((r = roomsDAO.loadNext()) != null) {
            if ((r.getPrice() == price && r.getPersons() == persons
                    && r.getCityName().equals(city)) || price == 0) {
                rooms[i].assign(r);
                auxArr[i] = rooms[i];
                ++i;
            }
        }
        auxArr[i] = null;
        return auxArr;
    }
}

class TripAdvisorAPI implements API {
    private ImplDAO roomsDAO = new ImplDAO("Rooms on TripAdvisor");
    private Room[] rooms = new Room[MAX_ROOMS];
    {
        rooms[0] = new Room(200, 10, 1, new Date(117, 5-1, 1), "Риц", "Шепетовка");
        rooms[1] = new Room(201, 5, 1, new Date(117, 5-1, 1), "Плаза", "Шепетовка");
        rooms[2] = new Room(202, 7, 2, new Date(117, 5-1, 1), "Плаза", "Шепетовка");
        rooms[3] = new Room(203, 25, 1, new Date(117, 5-1, 1), "National", "Шепетовка");
        rooms[4] = new Room(204, 30, 2, new Date(117, 5-1, 1), "National", "Шепетовка");
        for (int i = 0; i < MAX_ROOMS; i++)
            roomsDAO.save(rooms[i]);
    }
    private Room[] auxArr = new Room[MAX_ROOMS + 1];

    @Override
    public Room[] findRooms(int price, int persons, String city) {
        System.out.println("Searching rooms on TripAdvisor...");
        Room r;
        roomsDAO.seekStart();
        int i = 0;
        while ((r = roomsDAO.loadNext()) != null) {
            if ((r.getPrice() == price && r.getPersons() == persons
                    && r.getCityName().equals(city)) || price == 0) {
                rooms[i].assign(r);
                auxArr[i] = rooms[i];
                ++i;
            }
        }
        auxArr[i] = null;
        return auxArr;
    }
}

class GoogleAPI implements API {
    private ImplDAO roomsDAO = new ImplDAO("Rooms on Google");
    private Room[] rooms = new Room[MAX_ROOMS];
    {
        rooms[0] = new Room(300, 10, 1, new Date(117, 5-1, 1), "Хибара", "Шепетовка");
        rooms[1] = new Room(301, 15, 1, new Date(117, 5-1, 1), "Берлога", "Шепетовка");
        rooms[2] = new Room(302, 20, 2, new Date(117, 5-1, 1), "Берлога", "Шепетовка");
        rooms[3] = new Room(303, 25, 1, new Date(117, 5-1, 1), "National", "Шепетовка");
        rooms[4] = new Room(304, 30, 2, new Date(117, 5-1, 1), "National", "Шепетовка");
        for (int i = 0; i < MAX_ROOMS; i++)
            roomsDAO.save(rooms[i]);
    }
    private Room[] auxArr = new Room[MAX_ROOMS + 1];

    @Override
    public Room[] findRooms(int price, int persons, String city) {
        System.out.println("Searching rooms on Google...");
        Room r;
        roomsDAO.seekStart();
        int i = 0;
        while ((r = roomsDAO.loadNext()) != null) {
            if ((r.getPrice() == price && r.getPersons() == persons
                    && r.getCityName().equals(city)) || price == 0) {
                rooms[i].assign(r);
                auxArr[i] = rooms[i];
                ++i;
            }
        }
        auxArr[i] = null;
        return auxArr;
    }

}