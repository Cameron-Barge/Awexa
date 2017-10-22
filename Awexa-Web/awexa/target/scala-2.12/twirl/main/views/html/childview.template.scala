
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

object childview extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*1.2*/dashboard/*1.11*/{_display_(Seq[Any](format.raw/*1.12*/("""


  """),format.raw/*4.3*/("""<p> Child View </p>


  <a class ="btn btn-default" href =""""),_display_(/*7.39*/routes/*7.45*/.DashboardController.postLogin()),format.raw/*7.77*/(""""> Return </a><br>
  <a class ="btn btn-default" href =""""),_display_(/*8.39*/routes/*8.45*/.LoginController.logout()),format.raw/*8.70*/(""""> Logout </a><br>


""")))}),format.raw/*11.2*/("""
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sun Oct 22 18:59:09 EDT 2017
                  SOURCE: J:/GitHub/Awexa/Awexa-Web/awexa/app/views/childview.scala.html
                  HASH: 29917ae98dacbce11d56fc2e219bbc98bbc24bb6
                  MATRIX: 1034->1|1051->10|1089->11|1123->19|1212->82|1226->88|1278->120|1362->178|1376->184|1421->209|1476->234
                  LINES: 33->1|33->1|33->1|36->4|39->7|39->7|39->7|40->8|40->8|40->8|43->11
                  -- GENERATED --
              */
          