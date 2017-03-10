package module5;

public interface DAO {
    int MAX_ROOMS = 20; //public static final
    Room save(Room room);
    boolean delete(Room room);
    Room update(Room room);
    Room findById(long id);

    void seekStart();
    Room loadNext();
    void deleteAll();
}

class ImplDAO implements DAO {
    private String name;
    private Room[] dbRooms = new Room[MAX_ROOMS]; //массив, имитирующий таблицу базы данных
    {
        for (int i = 0; i < MAX_ROOMS; i++)
            dbRooms[i] = new Room(0,0,0,null,null,null); //id == 0 признак конца таблицы

    }
    private int index = -1; // used by seekStart(), loadNext(), findById(), update() methods
    private Room theRoom = new Room(0,0,0,null,null,null); //комната, выбраная из таблицы

    public ImplDAO(String name) {
        this.name = name;
    }

    @Override
    public Room save(Room room) {
        System.out.println("Saving to table \"" + name + "\" the " + room);
        int roomsCount = 0;
        while (dbRooms[roomsCount].getId() != 0 && roomsCount < MAX_ROOMS)
            ++roomsCount;
        if (roomsCount == MAX_ROOMS)
            return null; //в массиве максимальное кол-во комнат
        dbRooms[roomsCount].assign(room); //имитация записи в таблицу бд
        return room;
    }

    @Override
    public boolean delete(Room room) {
        System.out.print("Deleting the room from table \"" + name + "\" ... ");
        int i = 0;
        while (dbRooms[i].getId() != 0 && i < MAX_ROOMS) {
            if (dbRooms[i].equals(room) && dbRooms[i].getHotelName().equals(room.getHotelName())) {
                while ((i+1) < MAX_ROOMS && dbRooms[i+1].getId() != 0)
                    dbRooms[i].assign(dbRooms[++i]);
                dbRooms[i].setId(0);
                System.out.println("ok");
                return true;
            }
            i++;
        }
        System.out.println("not found");
        return false;
    }

    @Override
    public Room update(Room room) {
        System.out.println("Updating in table \"" + name + "\" the room " + dbRooms[index]);
        if (index == MAX_ROOMS) return null;
        dbRooms[index].assign(room);
        return room;
    }

    @Override
    public Room findById(long id) {
        System.out.println("Searching table for room with ID:" + id);
        int i = 0;
        while (i < MAX_ROOMS && dbRooms[i].getId() != 0) {
            if (dbRooms[i].getId() == id) {
                index = i;
                return theRoom.assign(dbRooms[i]); //имитация чтения из таблицы бд
            }
            ++i;
        }
        return null;
    }

    @Override
    public void seekStart() {
        index = -1;
    }

    @Override
    public Room loadNext() {
        index++;
        if (index == MAX_ROOMS) return null;
        if (dbRooms[index].getId() == 0) return null;
        return theRoom.assign(dbRooms[index]);
    }

    @Override
    public void deleteAll() {
        int i = 0;
        while (i < MAX_ROOMS  && dbRooms[i].getId() != 0)
            dbRooms[i++].setId(0);
    }
}


