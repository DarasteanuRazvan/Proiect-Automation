package database;


public class DatabaseCallerCRUD {

    public static void main(String[] args) {

        DatabaseProcessCRUD dbOperations = new DatabaseProcessCRUD();

        dbOperations.createHotel();
        dbOperations.readHotel();
        dbOperations.updateHotel();
        dbOperations.deleteHotel();

        dbOperations.executeSQLQuery();
    }
}


