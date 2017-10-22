
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

object newparent extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message : String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.20*/("""
"""),_display_(/*2.2*/dashboard/*2.11*/{_display_(Seq[Any](format.raw/*2.12*/("""

  """),format.raw/*4.3*/("""<p> """),_display_(/*4.8*/message),format.raw/*4.15*/(""" """),format.raw/*4.16*/("""</p>
  <p> New Parent </p>


  <a class ="btn btn-default" href =""""),_display_(/*8.39*/routes/*8.45*/.DashboardController.postLogin()),format.raw/*8.77*/(""""> Return </a><br>
  <a class ="btn btn-default" href =""""),_display_(/*9.39*/routes/*9.45*/.LoginController.logout()),format.raw/*9.70*/(""""> Logout </a><br>


""")))}),format.raw/*12.2*/("""
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
                  DATE: Sun Oct 22 18:59:09 EDT 2017
                  SOURCE: J:/GitHub/Awexa/Awexa-Web/awexa/app/views/newparent.scala.html
                  HASH: aff96708accf17a1939b8eb080ae0b4ae2a62186
                  MATRIX: 952->1|1065->19|1093->22|1110->31|1148->32|1180->38|1210->43|1237->50|1265->51|1362->122|1376->128|1428->160|1512->218|1526->224|1571->249|1626->274
                  LINES: 28->1|33->1|34->2|34->2|34->2|36->4|36->4|36->4|36->4|40->8|40->8|40->8|41->9|41->9|41->9|44->12
                  -- GENERATED --
              */
          