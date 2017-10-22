
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._

object dashboard extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.17*/("""
"""),format.raw/*2.1*/("""<!DOCTYPE html>
<html lang="en">
  <head>
    """),format.raw/*5.58*/("""
    """),format.raw/*6.5*/("""<title>Dashboard</title>
    <link rel="stylesheet" media="screen" href=""""),_display_(/*7.50*/routes/*7.56*/.Assets.versioned("stylesheets/main.css")),format.raw/*7.97*/("""">
    <link rel="shortcut icon" type="image/png" href=""""),_display_(/*8.55*/routes/*8.61*/.Assets.versioned("images/favicon.png")),format.raw/*8.100*/("""">
  </head>
  <body>
    """),format.raw/*12.27*/("""
    """),format.raw/*13.5*/("""<h1> Dashboard </h1>
    """),_display_(/*14.6*/content),format.raw/*14.13*/("""

    """),format.raw/*16.5*/("""<script src=""""),_display_(/*16.19*/routes/*16.25*/.Assets.versioned("../../public/js/main.js")),format.raw/*16.69*/("""" type="text/javascript"></script>
  </body>
</html>
"""))
      }
    }
  }

  def render(content:Html): play.twirl.api.HtmlFormat.Appendable = apply(content)

  def f:((Html) => play.twirl.api.HtmlFormat.Appendable) = (content) => apply(content)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sun Oct 22 18:59:09 EDT 2017
                  SOURCE: J:/GitHub/Awexa/Awexa-Web/awexa/app/views/dashboard.scala.html
                  HASH: b4a6a9c1ba5fe48a0fbf800939bacc292001f231
                  MATRIX: 950->1|1060->16|1088->18|1164->120|1196->126|1297->201|1311->207|1372->248|1456->306|1470->312|1530->351|1587->466|1620->472|1673->499|1701->506|1736->514|1777->528|1792->534|1857->578
                  LINES: 28->1|33->1|34->2|37->5|38->6|39->7|39->7|39->7|40->8|40->8|40->8|43->12|44->13|45->14|45->14|47->16|47->16|47->16|47->16
                  -- GENERATED --
              */
          