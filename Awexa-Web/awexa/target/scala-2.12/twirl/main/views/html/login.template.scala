
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

object login extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.18*/("""

"""),_display_(/*3.2*/main("Awexa Login")/*3.21*/ {_display_(Seq[Any](format.raw/*3.23*/("""
  """),format.raw/*4.3*/("""<p> """),_display_(/*4.8*/message),format.raw/*4.15*/(""" """),format.raw/*4.16*/("""</p>
  <form class ="form-horizontal" role ="form" action =""""),_display_(/*5.57*/routes/*5.63*/.LoginController.login()),format.raw/*5.87*/("""" method = "post">
    <div class ="form-group">
      <input type ="text"  name ="user" placeholder ="Username">
    </div>
    <div class ="form-group">
      <input type ="password"  name ="pass" placeholder ="Password">
    </div>
    <div class ="form-group">
      <button type ="submit" class ="btn btn-primary">Login</button>
      <button type="reset" class ="btn btn-danger">Cancel</button>
      <a class ="btn btn-default" href =""""),_display_(/*15.43*/routes/*15.49*/.LoginController.getRegistration()),format.raw/*15.83*/("""">Register</a>



    </div>
  </form>
""")))}),format.raw/*21.2*/("""
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
                  SOURCE: /Users/joshuabarge/Documents/Awexa/Awexa-Web/awexa/app/views/login.scala.html
                  HASH: 789148e57464e831beef4c28ae06eded43ed045b
                  MATRIX: 948->1|1059->17|1087->20|1114->39|1153->41|1182->44|1212->49|1239->56|1267->57|1354->118|1368->124|1412->148|1882->591|1897->597|1952->631|2022->671
                  LINES: 28->1|33->1|35->3|35->3|35->3|36->4|36->4|36->4|36->4|37->5|37->5|37->5|47->15|47->15|47->15|53->21
                  -- GENERATED --
              */
          