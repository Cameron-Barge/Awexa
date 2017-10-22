
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

object register extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.18*/("""

"""),_display_(/*3.2*/main("Awexa Login")/*3.21*/ {_display_(Seq[Any](format.raw/*3.23*/("""
  """),format.raw/*4.3*/("""<p> """),_display_(/*4.8*/message),format.raw/*4.15*/(""" """),format.raw/*4.16*/("""</p>
  <form class ="form-horizontal" role ="form" action =""""),_display_(/*5.57*/routes/*5.63*/.LoginController.register()),format.raw/*5.90*/("""" method = "post">
    <div class ="form-group">
      <input type ="text"  name ="user" placeholder ="Family Name">
    </div>
    <div class ="form-group">
      <input type ="password"  name ="pass" placeholder ="Password">
    </div>
    <div class ="form-group">
      <input type ="password"  name ="pass2" placeholder ="Confirm Password">
    </div>
    <div class ="form-group">
      <button type ="submit" class ="btn btn-primary">Register</button>
      <button type="reset" class ="btn btn-danger">Cancel</button>
      <a class ="btn btn-default" href =""""),_display_(/*18.43*/routes/*18.49*/.LoginController.getLogin()),format.raw/*18.76*/("""">Have an account? Login!</a>



    </div>
  </form>
""")))}),format.raw/*24.2*/("""
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
                  DATE: Sun Oct 22 00:10:05 EDT 2017
                  SOURCE: /Users/joshuabarge/Documents/Awexa/Awexa-Web/awexa/app/views/register.scala.html
                  HASH: cef0a4977d87613e0543a363578345b1163ad9a9
                  MATRIX: 951->1|1062->17|1090->20|1117->39|1156->41|1185->44|1215->49|1242->56|1270->57|1357->118|1371->124|1418->151|2013->719|2028->725|2076->752|2161->807
                  LINES: 28->1|33->1|35->3|35->3|35->3|36->4|36->4|36->4|36->4|37->5|37->5|37->5|50->18|50->18|50->18|56->24
                  -- GENERATED --
              */
          