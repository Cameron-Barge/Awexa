
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/joshuabarge/Documents/Awexa/Awexa-Web/awexa/conf/routes
// @DATE:Sun Oct 22 00:08:38 EDT 2017

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_0: controllers.HomeController,
  // @LINE:8
  LoginController_2: controllers.LoginController,
  // @LINE:14
  DashboardController_3: controllers.DashboardController,
  // @LINE:31
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_0: controllers.HomeController,
    // @LINE:8
    LoginController_2: controllers.LoginController,
    // @LINE:14
    DashboardController_3: controllers.DashboardController,
    // @LINE:31
    Assets_1: controllers.Assets
  ) = this(errorHandler, HomeController_0, LoginController_2, DashboardController_3, Assets_1, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, LoginController_2, DashboardController_3, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.LoginController.login"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.LoginController.getLogin"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """register""", """controllers.LoginController.getRegistration"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """register""", """controllers.LoginController.register"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """postLogin""", """controllers.DashboardController.postLogin"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """logout""", """controllers.LoginController.logout"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """child""", """controllers.DashboardController.childView"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """newparent""", """controllers.DashboardController.addParent"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """parent""", """controllers.DashboardController.parentView"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """parentauth""", """controllers.DashboardController.parentRequest"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """parentauth""", """controllers.DashboardController.parentAuth"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """newchore""", """controllers.DashboardController.addChore"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """newreward""", """controllers.DashboardController.addReward"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_0.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_LoginController_login1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_LoginController_login1_invoker = createInvoker(
    LoginController_2.login,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LoginController",
      "login",
      Nil,
      "POST",
      this.prefix + """login""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_LoginController_getLogin2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_LoginController_getLogin2_invoker = createInvoker(
    LoginController_2.getLogin,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LoginController",
      "getLogin",
      Nil,
      "GET",
      this.prefix + """login""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_LoginController_getRegistration3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("register")))
  )
  private[this] lazy val controllers_LoginController_getRegistration3_invoker = createInvoker(
    LoginController_2.getRegistration,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LoginController",
      "getRegistration",
      Nil,
      "GET",
      this.prefix + """register""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_LoginController_register4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("register")))
  )
  private[this] lazy val controllers_LoginController_register4_invoker = createInvoker(
    LoginController_2.register,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LoginController",
      "register",
      Nil,
      "POST",
      this.prefix + """register""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_DashboardController_postLogin5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("postLogin")))
  )
  private[this] lazy val controllers_DashboardController_postLogin5_invoker = createInvoker(
    DashboardController_3.postLogin,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DashboardController",
      "postLogin",
      Nil,
      "GET",
      this.prefix + """postLogin""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_LoginController_logout6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("logout")))
  )
  private[this] lazy val controllers_LoginController_logout6_invoker = createInvoker(
    LoginController_2.logout,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LoginController",
      "logout",
      Nil,
      "GET",
      this.prefix + """logout""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_DashboardController_childView7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("child")))
  )
  private[this] lazy val controllers_DashboardController_childView7_invoker = createInvoker(
    DashboardController_3.childView,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DashboardController",
      "childView",
      Nil,
      "GET",
      this.prefix + """child""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_DashboardController_addParent8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("newparent")))
  )
  private[this] lazy val controllers_DashboardController_addParent8_invoker = createInvoker(
    DashboardController_3.addParent,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DashboardController",
      "addParent",
      Nil,
      "GET",
      this.prefix + """newparent""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_DashboardController_parentView9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("parent")))
  )
  private[this] lazy val controllers_DashboardController_parentView9_invoker = createInvoker(
    DashboardController_3.parentView,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DashboardController",
      "parentView",
      Nil,
      "GET",
      this.prefix + """parent""",
      """""",
      Seq()
    )
  )

  // @LINE:24
  private[this] lazy val controllers_DashboardController_parentRequest10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("parentauth")))
  )
  private[this] lazy val controllers_DashboardController_parentRequest10_invoker = createInvoker(
    DashboardController_3.parentRequest,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DashboardController",
      "parentRequest",
      Nil,
      "GET",
      this.prefix + """parentauth""",
      """""",
      Seq()
    )
  )

  // @LINE:25
  private[this] lazy val controllers_DashboardController_parentAuth11_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("parentauth")))
  )
  private[this] lazy val controllers_DashboardController_parentAuth11_invoker = createInvoker(
    DashboardController_3.parentAuth,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DashboardController",
      "parentAuth",
      Nil,
      "POST",
      this.prefix + """parentauth""",
      """""",
      Seq()
    )
  )

  // @LINE:27
  private[this] lazy val controllers_DashboardController_addChore12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("newchore")))
  )
  private[this] lazy val controllers_DashboardController_addChore12_invoker = createInvoker(
    DashboardController_3.addChore,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DashboardController",
      "addChore",
      Nil,
      "GET",
      this.prefix + """newchore""",
      """""",
      Seq()
    )
  )

  // @LINE:29
  private[this] lazy val controllers_DashboardController_addReward13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("newreward")))
  )
  private[this] lazy val controllers_DashboardController_addReward13_invoker = createInvoker(
    DashboardController_3.addReward,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DashboardController",
      "addReward",
      Nil,
      "GET",
      this.prefix + """newreward""",
      """""",
      Seq()
    )
  )

  // @LINE:31
  private[this] lazy val controllers_Assets_versioned14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned14_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_0.index)
      }
  
    // @LINE:8
    case controllers_LoginController_login1_route(params@_) =>
      call { 
        controllers_LoginController_login1_invoker.call(LoginController_2.login)
      }
  
    // @LINE:9
    case controllers_LoginController_getLogin2_route(params@_) =>
      call { 
        controllers_LoginController_getLogin2_invoker.call(LoginController_2.getLogin)
      }
  
    // @LINE:11
    case controllers_LoginController_getRegistration3_route(params@_) =>
      call { 
        controllers_LoginController_getRegistration3_invoker.call(LoginController_2.getRegistration)
      }
  
    // @LINE:12
    case controllers_LoginController_register4_route(params@_) =>
      call { 
        controllers_LoginController_register4_invoker.call(LoginController_2.register)
      }
  
    // @LINE:14
    case controllers_DashboardController_postLogin5_route(params@_) =>
      call { 
        controllers_DashboardController_postLogin5_invoker.call(DashboardController_3.postLogin)
      }
  
    // @LINE:16
    case controllers_LoginController_logout6_route(params@_) =>
      call { 
        controllers_LoginController_logout6_invoker.call(LoginController_2.logout)
      }
  
    // @LINE:18
    case controllers_DashboardController_childView7_route(params@_) =>
      call { 
        controllers_DashboardController_childView7_invoker.call(DashboardController_3.childView)
      }
  
    // @LINE:20
    case controllers_DashboardController_addParent8_route(params@_) =>
      call { 
        controllers_DashboardController_addParent8_invoker.call(DashboardController_3.addParent)
      }
  
    // @LINE:22
    case controllers_DashboardController_parentView9_route(params@_) =>
      call { 
        controllers_DashboardController_parentView9_invoker.call(DashboardController_3.parentView)
      }
  
    // @LINE:24
    case controllers_DashboardController_parentRequest10_route(params@_) =>
      call { 
        controllers_DashboardController_parentRequest10_invoker.call(DashboardController_3.parentRequest)
      }
  
    // @LINE:25
    case controllers_DashboardController_parentAuth11_route(params@_) =>
      call { 
        controllers_DashboardController_parentAuth11_invoker.call(DashboardController_3.parentAuth)
      }
  
    // @LINE:27
    case controllers_DashboardController_addChore12_route(params@_) =>
      call { 
        controllers_DashboardController_addChore12_invoker.call(DashboardController_3.addChore)
      }
  
    // @LINE:29
    case controllers_DashboardController_addReward13_route(params@_) =>
      call { 
        controllers_DashboardController_addReward13_invoker.call(DashboardController_3.addReward)
      }
  
    // @LINE:31
    case controllers_Assets_versioned14_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned14_invoker.call(Assets_1.versioned(path, file))
      }
  }
}
