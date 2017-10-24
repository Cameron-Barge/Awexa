package controllers;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.*;
import model.*;
import play.data.Form;
import play.data.FormFactory;


import play.mvc.*;
import javax.inject.*;
import java.io.FileInputStream;
import java.util.Map;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {
    FirebaseServices db = new FirebaseServices();

    @Inject FormFactory formFactory;
    // Get a reference to our posts

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
		return ok(views.html.index.render("Welcome to Awexa", session("connected")!=null));
	}
		
		/**
		 * Returns either pre log-in index page or post log-in dashboard depending on user state
		 * @return Result resulting action
		 */
		public Result getHome() {
			System.out.println(Global.auth);
			if (session("connected") != null) {
				return ok(views.html.postlogin.render(Global.username));
			} else {
				return ok(views.html.index.render("Welcome to Awexa", false));
			}
		}

}
