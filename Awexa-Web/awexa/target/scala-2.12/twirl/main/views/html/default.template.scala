
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

object default extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <link href= """"),_display_(/*5.17*/routes/*5.23*/.Assets.versioned("stylesheets/bootstrap.min.css")),format.raw/*5.73*/("""" rel="stylesheet" type="text/css">
  <script src=""""),_display_(/*6.17*/routes/*6.23*/.Assets.versioned("js/jquery-2.2.4.js")),format.raw/*6.62*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*7.17*/routes/*7.23*/.Assets.versioned("js/bootstrap.min.js")),format.raw/*7.63*/("""" type="text/javascript"></script>
  <title>Awexa</title>
</head>
<body>

</body>
</html>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Wed Oct 18 19:21:26 EDT 2017
                  SOURCE: /Users/joshuabarge/Documents/Awexa/Awexa-Web/awexa/app/views/default.scala.html
                  HASH: c3b36b45a2ae02ea80b1ac7e9f2bc2c785e65af6
                  MATRIX: 1032->0|1139->81|1153->87|1223->137|1301->189|1315->195|1374->234|1451->285|1465->291|1525->331
                  LINES: 33->1|37->5|37->5|37->5|38->6|38->6|38->6|39->7|39->7|39->7
                  -- GENERATED --
              */
          