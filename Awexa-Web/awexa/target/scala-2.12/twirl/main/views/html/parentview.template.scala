
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

object parentview extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*1.2*/dashboard/*1.11*/{_display_(Seq[Any](format.raw/*1.12*/("""


  """),format.raw/*4.3*/("""<p> Parent View </p>

  <a class ="btn btn-default" href =""""),_display_(/*6.39*/routes/*6.45*/.DashboardController.addChore()),format.raw/*6.76*/(""""> New Chore </a><br>
  <a class ="btn btn-default" href =""""),_display_(/*7.39*/routes/*7.45*/.DashboardController.addReward()),format.raw/*7.77*/(""""> New Reward </a><br>

  <a class ="btn btn-default" href =""""),_display_(/*9.39*/routes/*9.45*/.DashboardController.postLogin()),format.raw/*9.77*/(""""> Return </a><br>
  <a class ="btn btn-default" href =""""),_display_(/*10.39*/routes/*10.45*/.LoginController.logout()),format.raw/*10.70*/(""""> Logout </a><br>


""")))}),format.raw/*13.2*/("""
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
                  SOURCE: J:/GitHub/Awexa/Awexa-Web/awexa/app/views/parentview.scala.html
                  HASH: 1adc68bfdd5175b8df4582b312d339e68ca6ebe8
                  MATRIX: 1035->1|1052->10|1090->11|1124->19|1212->81|1226->87|1277->118|1364->179|1378->185|1430->217|1520->281|1534->287|1586->319|1671->377|1686->383|1732->408|1787->433
                  LINES: 33->1|33->1|33->1|36->4|38->6|38->6|38->6|39->7|39->7|39->7|41->9|41->9|41->9|42->10|42->10|42->10|45->13
                  -- GENERATED --
              */
          