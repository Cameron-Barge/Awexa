
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
                  DATE: Sat Oct 21 15:41:08 EDT 2017
                  SOURCE: /Users/joshuabarge/Documents/Awexa/Awexa-Web/awexa/app/views/dashboard.scala.html
                  HASH: 10edbcec154a71a08bc600552d5351f179a59097
                  MATRIX: 950->1|1060->16|1087->17|1160->116|1191->121|1291->195|1305->201|1366->242|1449->299|1463->305|1523->344|1577->455|1609->460|1661->486|1689->493|1722->499|1763->513|1778->519|1843->563
                  LINES: 28->1|33->1|34->2|37->5|38->6|39->7|39->7|39->7|40->8|40->8|40->8|43->12|44->13|45->14|45->14|47->16|47->16|47->16|47->16
                  -- GENERATED --
              */
          