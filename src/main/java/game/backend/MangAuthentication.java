package game.backend;

public interface MangAuthentication {

    /**Add user to the DataBase when ask for a registration
     * @param u we add it to the DB if the username exist send and error advertise
     * @return 0-Okey 1-Wrong
     */
    public int addUser (User u);

    /**Check if the login it's correct
     * @param u of this element we have to check if the password and username are the same as in the DB
     * @return 0-Okey 1-Wrong
     *
    * */
    public int checkUser (String u, String p);


}
