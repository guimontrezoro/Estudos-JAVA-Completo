package Entities;

public class Pensionato {
    private Rent[] rooms;

    public Pensionato() {
        rooms = new Rent[10];
    }

    public void rentRoom(int roomNumber, Rent rent) {
        if (roomNumber < 0 || roomNumber > 9) {
            throw new IllegalArgumentException("Room number must be between 0 and 9.");
        }

        if (rooms[roomNumber] != null) {
            throw new IllegalArgumentException("Room already occupied.");
        }

        rooms[roomNumber] = rent;
    }

    public String occupiedRooms() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i] != null) {
                sb.append(i)
                  .append(": ")
                  .append(rooms[i])
                  .append("\n");
            }
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        return occupiedRooms();
    }
}