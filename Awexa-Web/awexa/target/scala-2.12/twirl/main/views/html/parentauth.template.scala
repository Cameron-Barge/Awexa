
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

object parentauth extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*1.2*/dashboard/*1.11*/{_display_(Seq[Any](format.raw/*1.12*/("""


  """),format.raw/*4.3*/("""<p> Parent Auth </p>



  <form class ="form-horizontal" role ="form" action =""""),_display_(/*8.57*/routes/*8.63*/.DashboardController.parentAuth()),format.raw/*8.96*/("""" method = "post">
    <div class ="form-group">
      <input type ="password"  name ="pass" placeholder ="Parent Password">
    </div>
    <div class ="form-group">
      <button type ="submit" class ="btn btn-primary">Login</button>
    </div>
  </form>

  <a class ="btn btn-default" href =""""),_display_(/*17.39*/routes/*17.45*/.DashboardController.postLogin()),format.raw/*17.77*/(""""> Return </a><br>
  <a class ="btn btn-default" href =""""),_display_(/*18.39*/routes/*18.45*/.LoginController.logout()),format.raw/*18.70*/(""""> Logout </a><br>


""")))}),format.raw/*21.2*/("""
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
                  SOURCE: J:/GitHub/Awexa/Awexa-Web/awexa/app/views/parentauth.scala.html
                  HASH: 9e4f95087c05c94b60e000384e520f890a1178ae
                  MATRIX: 1035->1|1052->10|1090->11|1124->19|1234->103|1248->109|1301->142|1632->446|1647->452|1700->484|1785->542|1800->548|1846->573|1901->598
                  LINES: 33->1|33->1|33->1|36->4|40->8|40->8|40->8|49->17|49->17|49->17|50->18|50->18|50->18|53->21
                  -- GENERATED --
              */
          