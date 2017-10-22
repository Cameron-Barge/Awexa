
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

object postlogin extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*1.2*/dashboard/*1.11*/{_display_(Seq[Any](format.raw/*1.12*/("""


  """),format.raw/*4.3*/("""<p> Post Login </p>

  <a class ="btn btn-default" href =""""),_display_(/*6.39*/routes/*6.45*/.LoginController.logout()),format.raw/*6.70*/("""">Logout</a><br>

  <a class ="btn btn-default" href =""""),_display_(/*8.39*/routes/*8.45*/.DashboardController.addParent()),format.raw/*8.77*/("""">No parents</a><br>

  <a class ="btn btn-default" href =""""),_display_(/*10.39*/routes/*10.45*/.DashboardController.parentRequest()),format.raw/*10.81*/("""">Parent View</a><br>

  <a class ="btn btn-default" href =""""),_display_(/*12.39*/routes/*12.45*/.DashboardController.childView()),format.raw/*12.77*/("""">Child View</a>

""")))}),format.raw/*14.2*/("""
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
                  DATE: Sat Oct 21 15:41:08 EDT 2017
                  SOURCE: /Users/joshuabarge/Documents/Awexa/Awexa-Web/awexa/app/views/postlogin.scala.html
                  HASH: 4f93b91cf5d9121fa006edbb8559f2d1649f99d0
                  MATRIX: 1034->1|1051->10|1089->11|1120->16|1205->75|1219->81|1264->106|1346->162|1360->168|1412->200|1499->260|1514->266|1571->302|1659->363|1674->369|1727->401|1776->420
                  LINES: 33->1|33->1|33->1|36->4|38->6|38->6|38->6|40->8|40->8|40->8|42->10|42->10|42->10|44->12|44->12|44->12|46->14
                  -- GENERATED --
              */
          