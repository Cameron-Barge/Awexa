
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/joshuabarge/Documents/Awexa/Awexa-Web/awexa/conf/routes
// @DATE:Sun Oct 22 00:08:38 EDT 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
