
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/joshuabarge/Documents/Awexa/Awexa-Web/awexa/conf/routes
// @DATE:Sat Oct 21 15:49:12 EDT 2017


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
