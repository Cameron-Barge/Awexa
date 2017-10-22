
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
"""),format.raw/*4.1*/("""<section id="contact" class="contactus margin-top-120">
  <div class="container">
    <div class="row">
      <div class="col-sm-12">
        <div class="main_contact sections">
          <div class="head_title text-center">
            <h1>"""),_display_(/*10.18*/message),format.raw/*10.25*/("""</h1>
          </div>

          <div class="row">
            <div class="contact_contant">
              <div class="col-sm-6 col-xs-12">
                <div class="single_message_right_info">
                  <ul>
                    <li><i class="fa fa-map-marker"></i> <span>23 Mulholland Drive, Suite 721. Los Angeles 10010
                                               100 S. Main Street. Los Angeles 90012</span></li>

                    <li><i class="fa fa-mobile-phone"></i> <span>+1-670-567-5590</span></li>

                  </ul>

                  <div class="work_socail transition">
                    <a href=""><i class="fa fa-facebook img-circle"></i></a>
                    <a href=""><i class="fa fa-twitter img-circle"></i></a>
                    <a href=""><i class="fa fa-google-plus img-circle"></i></a>
                    <a href=""><i class="fa fa-pinterest img-circle"></i></a>
                    <a href=""><i class="fa fa-instagram img-circle"></i></a>
                  </div>
                </div>
              </div><!-- End of col-sm-6 -->

              <div class="col-sm-6 col-xs-12">
                <div class="single_contant_left margin-top-60">
                  <form class ="form-horizontal" role ="form" action =""""),_display_(/*37.73*/routes/*37.79*/.LoginController.login()),format.raw/*37.103*/("""" method = "post">
                    <div class ="form-group">
                      <input type="text"  class="form-control" name="user" placeholder="Username">
                    </div>
                    <div class="form-group">
                      <input type="password"  class="form-control" name="pass" placeholder="Password">
                    </div>
                    <div class="form-group">
                      <p> """),_display_(/*45.28*/error),format.raw/*45.33*/(""" """),format.raw/*45.34*/("""</p>
                      <button type="submit" class="btn btn-primary">Login</button>
                      <button type="reset" class="btn btn-danger">Cancel</button>
                      <a class ="btn btn-default" href=""""),_display_(/*48.58*/routes/*48.64*/.LoginController.getRegistration()),format.raw/*48.98*/("""">Register</a>
                    </div>
                  </form>
                </div>
              </div>
            </div> <!-- End of messsage contant-->
          </div>
        </div>
      </div>
    </div><!-- End of row -->
  </div><!-- End of container -->
</section><!-- End of contact Section -->


""")))}),format.raw/*62.2*/("""
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
                  DATE: Sun Oct 22 18:59:09 EDT 2017
                  SOURCE: J:/GitHub/Awexa/Awexa-Web/awexa/app/views/login.scala.html
                  HASH: 2bcf75242b148ceb37250d0d780fadfe882d3ce0
                  MATRIX: 955->1|1082->33|1112->38|1139->57|1178->59|1206->61|1481->309|1509->316|2834->1614|2849->1620|2895->1644|3368->2090|3394->2095|3423->2096|3680->2326|3695->2332|3750->2366|4111->2697
                  LINES: 28->1|33->1|35->3|35->3|35->3|36->4|42->10|42->10|69->37|69->37|69->37|77->45|77->45|77->45|80->48|80->48|80->48|94->62
                  -- GENERATED --
              */
          