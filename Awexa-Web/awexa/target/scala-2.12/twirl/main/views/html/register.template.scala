
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
                  <form role="form" action=""""),_display_(/*37.46*/routes/*37.52*/.LoginController.register()),format.raw/*37.79*/("""" method="post">
                    <div class ="form-group">
                      <input type="text" class="form-control" name="user" placeholder="Family Name">
                    </div>
                    <div class ="form-group">
                      <input type="password" class="form-control" name="pass" placeholder="Password">
                    </div>
                    <div class="form-group">
                      <input type="password"  class="form-control" name="pass2" placeholder="Confirm Password">
                    </div>
                    <p> """),_display_(/*47.26*/error),format.raw/*47.31*/(""" """),format.raw/*47.32*/("""</p>
                    <div class="form-group">
                      <button type="submit" class="btn btn-primary">Register</button>
                      <button type="reset" class="btn btn-danger">Cancel</button>
                      <a class ="btn btn-default" href=""""),_display_(/*51.58*/routes/*51.64*/.LoginController.getLogin()),format.raw/*51.91*/("""">Login!</a>
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
""")))}),format.raw/*63.2*/("""
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
                  SOURCE: J:/GitHub/Awexa/Awexa-Web/awexa/app/views/register.scala.html
                  HASH: d232b6fece35ab078db5bf4359cf02107a4e3ba5
                  MATRIX: 958->1|1083->31|1113->36|1140->55|1179->57|1207->59|1482->307|1510->314|2817->1594|2832->1600|2880->1627|3492->2212|3518->2217|3547->2218|3853->2497|3868->2503|3916->2530|4271->2855
                  LINES: 28->1|33->1|35->3|35->3|35->3|36->4|42->10|42->10|69->37|69->37|69->37|79->47|79->47|79->47|83->51|83->51|83->51|95->63
                  -- GENERATED --
              */
          