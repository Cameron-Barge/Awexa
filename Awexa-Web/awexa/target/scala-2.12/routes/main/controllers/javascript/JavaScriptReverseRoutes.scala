
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/joshuabarge/Documents/Awexa/Awexa-Web/awexa/conf/routes
// @DATE:Sat Oct 21 15:49:12 EDT 2017

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:14
  class ReverseDashboardController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:20
    def addParent: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DashboardController.addParent",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "newparent"})
        }
      """
    )
  
    // @LINE:22
    def parentView: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DashboardController.parentView",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "parent"})
        }
      """
    )
  
    // @LINE:25
    def parentAuth: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DashboardController.parentAuth",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "parentauth"})
        }
      """
    )
  
    // @LINE:27
    def addChore: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DashboardController.addChore",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "newchore"})
        }
      """
    )
  
    // @LINE:24
    def parentRequest: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DashboardController.parentRequest",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "parentauth"})
        }
      """
    )
  
    // @LINE:29
    def addReward: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DashboardController.addReward",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "newreward"})
        }
      """
    )
  
    // @LINE:18
    def childView: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DashboardController.childView",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "child"})
        }
      """
    )
  
    // @LINE:14
    def postLogin: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DashboardController.postLogin",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "postLogin"})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:8
  class ReverseLoginController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def getLogin: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LoginController.getLogin",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
        }
      """
    )
  
    // @LINE:11
    def getRegistration: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LoginController.getRegistration",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "register"})
        }
      """
    )
  
    // @LINE:16
    def logout: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LoginController.logout",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
        }
      """
    )
  
    // @LINE:8
    def login: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LoginController.login",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
        }
      """
    )
  
  }

  // @LINE:31
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:31
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
