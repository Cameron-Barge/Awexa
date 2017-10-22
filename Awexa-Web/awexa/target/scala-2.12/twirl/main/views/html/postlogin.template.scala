
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

object postlogin extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(familyName: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.22*/("""
"""),_display_(/*2.2*/dashboard/*2.11*/{_display_(Seq[Any](format.raw/*2.12*/("""


  """),format.raw/*5.3*/("""<p> Post Login - """),_display_(/*5.21*/familyName),format.raw/*5.31*/(""" """),format.raw/*5.32*/("""</p>

  <a class ="btn btn-default" href =""""),_display_(/*7.39*/routes/*7.45*/.LoginController.logout()),format.raw/*7.70*/("""">Logout</a><br>

  <a class ="btn btn-default" href =""""),_display_(/*9.39*/routes/*9.45*/.DashboardController.addParent()),format.raw/*9.77*/("""">No parents</a><br>

  <a class ="btn btn-default" href =""""),_display_(/*11.39*/routes/*11.45*/.DashboardController.parentRequest()),format.raw/*11.81*/("""">Parent View</a><br>

  <a class ="btn btn-default" href =""""),_display_(/*13.39*/routes/*13.45*/.DashboardController.childView()),format.raw/*13.77*/("""">Child View</a>

""")))}),format.raw/*15.2*/("""
"""))
      }
    }
  }

  def render(familyName:String): play.twirl.api.HtmlFormat.Appendable = apply(familyName)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (familyName) => apply(familyName)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sun Oct 22 18:59:09 EDT 2017
                  SOURCE: J:/GitHub/Awexa/Awexa-Web/awexa/app/views/postlogin.scala.html
                  HASH: c9e4f5fd6339abf1b543d4d086d0ac5360acc462
                  MATRIX: 952->1|1067->21|1095->24|1112->33|1150->34|1184->42|1228->60|1258->70|1286->71|1358->117|1372->123|1417->148|1501->206|1515->212|1567->244|1656->306|1671->312|1728->348|1818->411|1833->417|1886->449|1937->470
                  LINES: 28->1|33->1|34->2|34->2|34->2|37->5|37->5|37->5|37->5|39->7|39->7|39->7|41->9|41->9|41->9|43->11|43->11|43->11|45->13|45->13|45->13|47->15
                  -- GENERATED --
              */
          