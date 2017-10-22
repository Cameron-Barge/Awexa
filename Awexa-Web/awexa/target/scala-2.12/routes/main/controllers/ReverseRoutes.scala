
// @GENERATOR:play-routes-compiler
// @SOURCE:J:/GitHub/Awexa/Awexa-Web/awexa/conf/routes
// @DATE:Sun Oct 22 18:59:09 EDT 2017

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:14
  class ReverseDashboardController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:20
    def addParent(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "newparent")
    }
  
    // @LINE:22
    def parentView(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "parent")
    }
  
    // @LINE:25
    def parentAuth(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "parentauth")
    }
  
    // @LINE:27
    def addChore(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "newchore")
    }
  
    // @LINE:24
    def parentRequest(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "parentauth")
    }
  
    // @LINE:29
    def addReward(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "newreward")
    }
  
    // @LINE:18
    def childView(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "child")
    }
  
    // @LINE:14
    def postLogin(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "postLogin")
    }
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:8
  class ReverseLoginController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def getRegistration(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "register")
    }
  
    // @LINE:16
    def logout(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "logout")
    }
  
    // @LINE:12
    def register(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "register")
    }
  
    // @LINE:9
    def getLogin(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "login")
    }
  
    // @LINE:8
    def login(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "login")
    }
  
  }

  // @LINE:31
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:31
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
