
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

object addreward extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*1.2*/dashboard/*1.11*/{_display_(Seq[Any](format.raw/*1.12*/("""


  """),format.raw/*4.3*/("""<p> Add Reward </p>


  <a class ="btn btn-default" href =""""),_display_(/*7.39*/routes/*7.45*/.DashboardController.parentView()),format.raw/*7.78*/(""""> Return </a><br>
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
                  DATE: Sat Oct 21 15:49:12 EDT 2017
                  SOURCE: /Users/joshuabarge/Documents/Awexa/Awexa-Web/awexa/app/views/addreward.scala.html
                  HASH: 0051509543dcfba5cafae5e5b68c4ffb612dcd9c
                  MATRIX: 1034->1|1051->10|1089->11|1120->16|1206->76|1220->82|1273->115|1356->172|1370->178|1415->203|1467->225
                  LINES: 33->1|33->1|33->1|36->4|39->7|39->7|39->7|40->8|40->8|40->8|43->11
                  -- GENERATED --
              */
          