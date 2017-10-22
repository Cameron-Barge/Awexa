package model;

public class Global {
    public static boolean waiting = true;

    public static String familyName = "";

    //Login
    public static String loginUser = "";
    public static String loginPass = "";
    public static boolean auth = false;


    public static void reset(){
        Global.waiting = true;
        Global.familyName = "";
        Global.loginPass = "";
        Global.loginUser = "";
        Global.auth = false;
    }
}
