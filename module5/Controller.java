package module5;

public class Controller {
    private API[] apis = new API[3];
    {
        apis[0] = new BookingComAPI();
        apis[1] = new TripAdvisorAPI();
        apis[2] = new GoogleAPI();
    }

    private ImplDAO requestedRoomsDAO = new ImplDAO("Requested rooms");
    private ImplDAO sameRoomsDAO = new ImplDAO("Same rooms");

    private Room[] rooms  = new Room[ImplDAO.MAX_ROOMS]; //массив комнат, выбраных из бд
    {
        for (int i = 0; i < ImplDAO.MAX_ROOMS; i++)
            rooms[i] = new Room(0,0,0,null,null,null);
    }

    private Room[] auxArr = new Room[ImplDAO.MAX_ROOMS + 1]; //вспомагательный массив для rooms[], в кот. нулевая ссылка обозначает конец массива

    private void loadAllFromDAO(ImplDAO dao) {
        Room r;
        dao.seekStart();
        int i = 0;
        while ((r = dao.loadNext()) != null ) {
            rooms[i].assign(r);
            auxArr[i] = rooms[i];
            ++i;
        }
        auxArr[i] = null;
    }

    public Room[] requestRooms(int price, int persons, String city) {
        Room[] rooms;
        requestedRoomsDAO.deleteAll();
        for (int i = 0; i < 3; i++) {
            rooms = apis[i].findRooms(price, persons, city);
            int ii = 0;
            while (rooms[ii] != null)
                requestedRoomsDAO.save(rooms[ii++]);
        }
        loadAllFromDAO(requestedRoomsDAO);
        return auxArr;
    }

    public Room[] check(API api1, API api2) {
        Room[] rooms1 = api1.findRooms(0,1,null); // выбираем все имеющиеся комнаты
        Room[] rooms2 = api2.findRooms(0,1,null);
        sameRoomsDAO.deleteAll();
        int i = 0;
        while (rooms1[i] != null) {
            int ii = 0;
            while (rooms2[ii] != null) {
                if (rooms2[ii].equals(rooms1[i])) {
                    sameRoomsDAO.save(rooms1[i]);
                    sameRoomsDAO.save(rooms2[ii]);
                }
                ii++;
            }
            i++;
        }
        loadAllFromDAO(sameRoomsDAO);
        return auxArr;
    }

    public void demoDAO() {
        Room room;
        System.out.println();
        System.out.println("--- DAO demonstration");
        System.out.println("sameRoomsDAO:");
        loadAllFromDAO(sameRoomsDAO);
        module5.Main.printArray(auxArr, false);

        sameRoomsDAO.seekStart();
        int i = 0;
        while ((room = sameRoomsDAO.loadNext()) != null ) {
            if (room.getId() >= 300) {
                long id = room.getId();
                id += 1000;
                room.setId(id);
                sameRoomsDAO.update(room);
            }
        }
        room = sameRoomsDAO.findById(1300);
        room.setCityName("Шепетівка");
        sameRoomsDAO.update(room);
        loadAllFromDAO(sameRoomsDAO);
        module5.Main.printArray(auxArr, false);
        room = sameRoomsDAO.findById(1304);
        while (sameRoomsDAO.delete(room));
        loadAllFromDAO(sameRoomsDAO);
        module5.Main.printArray(auxArr, false);
    }
}
