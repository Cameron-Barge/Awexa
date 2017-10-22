
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

object register extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message:String)(error:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.32*/("""

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
    <p> """),_display_(/*15.10*/error),format.raw/*15.15*/(""" """),format.raw/*15.16*/("""</p>
    <div class ="form-group">
      <button type ="submit" class ="btn btn-primary">Register</button>
      <button type="reset" class ="btn btn-danger">Cancel</button>
      <a class ="btn btn-default" href =""""),_display_(/*19.43*/routes/*19.49*/.LoginController.getLogin()),format.raw/*19.76*/("""">Have an account? Login!</a>



    </div>
  </form>
""")))}),format.raw/*25.2*/("""
"""))
      }
    }
  }

  def render(message:String,error:String): play.twirl.api.HtmlFormat.Appendable = apply(message)(error)

  def f:((String) => (String) => play.twirl.api.HtmlFormat.Appendable) = (message) => (error) => apply(message)(error)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sun Oct 22 00:24:08 EDT 2017
                  SOURCE: /Users/joshuabarge/Documents/Awexa/Awexa-Web/awexa/app/views/register.scala.html
                  HASH: a60db25419f3613f8382ed6ac9d8e4a1dfc03efa
                  MATRIX: 958->1|1083->31|1111->34|1138->53|1177->55|1206->58|1236->63|1263->70|1291->71|1378->132|1392->138|1439->165|1832->531|1858->536|1887->537|2130->753|2145->759|2193->786|2278->841
                  LINES: 28->1|33->1|35->3|35->3|35->3|36->4|36->4|36->4|36->4|37->5|37->5|37->5|47->15|47->15|47->15|51->19|51->19|51->19|57->25
                  -- GENERATED --
              */
          