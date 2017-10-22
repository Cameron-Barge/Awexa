
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

object login extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message:String)(error : String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.34*/("""

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
      <p> """),_display_(/*13.12*/error),format.raw/*13.17*/(""" """),format.raw/*13.18*/("""</p>
      <button type ="submit" class ="btn btn-primary">Login</button>
      <button type="reset" class ="btn btn-danger">Cancel</button>
      <a class ="btn btn-default" href =""""),_display_(/*16.43*/routes/*16.49*/.LoginController.getRegistration()),format.raw/*16.83*/("""">Register</a>



    </div>
  </form>
""")))}),format.raw/*22.2*/("""
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
                  DATE: Sat Oct 21 22:20:01 EDT 2017
                  SOURCE: /Users/joshuabarge/Documents/Awexa/Awexa-Web/awexa/app/views/login.scala.html
                  HASH: 4272e98abc075e9c99b6dfcd0af9a84f8f45905a
                  MATRIX: 955->1|1082->33|1110->36|1137->55|1176->57|1205->60|1235->65|1262->72|1290->73|1377->134|1391->140|1435->164|1738->440|1764->445|1793->446|2003->629|2018->635|2073->669|2143->709
                  LINES: 28->1|33->1|35->3|35->3|35->3|36->4|36->4|36->4|36->4|37->5|37->5|37->5|45->13|45->13|45->13|48->16|48->16|48->16|54->22
                  -- GENERATED --
              */
          