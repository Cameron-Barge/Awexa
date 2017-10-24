package model;

import com.google.firebase.database.DataSnapshot;

public class Global {
    public static boolean waiting = true;

    public static String familyName = "";

    //Login
    public static String loginUser = "";
    public static String loginPass = "";
		public static boolean auth = false;
		public static Family family;

    public static DataSnapshot curRef = null;


    public static void reset(){
				Global.family = null;
        Global.waiting = true;
        Global.familyName = "";
        Global.loginPass = "";
        Global.loginUser = "";
        Global.auth = false;
        Global.curRef = null;
		}
		
}
