
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.18*/("""

"""),_display_(/*3.2*/main("Awexa")/*3.15*/ {_display_(Seq[Any](format.raw/*3.17*/("""
    """),format.raw/*4.5*/("""<p> """),_display_(/*4.10*/message),format.raw/*4.17*/(""" """),format.raw/*4.18*/("""</p>

    <a class ="btn btn-default" href =""""),_display_(/*6.41*/routes/*6.47*/.LoginController.getLogin()),format.raw/*6.74*/("""">Login</a>
    <a class ="btn btn-default" href =""""),_display_(/*7.41*/routes/*7.47*/.LoginController.getRegistration()),format.raw/*7.81*/("""">Register</a>

""")))}),format.raw/*9.2*/("""
"""))
      }
    }
  }

  def render(message:String): play.twirl.api.HtmlFormat.Appendable = apply(message)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (message) => apply(message)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sat Oct 21 15:19:28 EDT 2017
                  SOURCE: /Users/joshuabarge/Documents/Awexa/Awexa-Web/awexa/app/views/index.scala.html
                  HASH: ee8f64c3a3802936aec7f9d4073a6c6f00c1e593
                  MATRIX: 948->1|1059->17|1087->20|1108->33|1147->35|1178->40|1209->45|1236->52|1264->53|1336->99|1350->105|1397->132|1475->184|1489->190|1543->224|1589->241
                  LINES: 28->1|33->1|35->3|35->3|35->3|36->4|36->4|36->4|36->4|38->6|38->6|38->6|39->7|39->7|39->7|41->9
                  -- GENERATED --
              */
          