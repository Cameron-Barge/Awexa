
// @GENERATOR:play-routes-compiler
// @SOURCE:J:/GitHub/Awexa/Awexa-Web/awexa/conf/routes
// @DATE:Sun Oct 22 18:59:09 EDT 2017


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
