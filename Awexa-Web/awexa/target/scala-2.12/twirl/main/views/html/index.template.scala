
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.18*/("""

"""),_display_(/*3.2*/main("Awexa")/*3.15*/ {_display_(Seq[Any](format.raw/*3.17*/("""
    """),format.raw/*4.5*/("""<!-- Home Section -->
    <section id="home" class="home">
        <div class="container">
            <div class="row">
                <div class="col-sm-12 ">
                    <div class="main_home_slider text-center">

                        <div class="single_home_slider">
                            <div class="home-overlay"></div>
                            <div class="main_home wow fadeInUp" data-wow-duration="700ms">

                                <h2>"""),_display_(/*15.38*/message),format.raw/*15.45*/("""</h2>
                                <div class="separator"></div>
                                <p class="subtitle">Awexa for Kids <br />
                                    Georgia Tech Convergence Innovation Competition 2017</p>
                                <div class="home_btn">
                                    <a href=""""),_display_(/*20.47*/routes/*20.53*/.LoginController.getLogin()),format.raw/*20.80*/("""" class="btn">Login</a>
                                </div>
                            </div>
                        </div><!-- End of single_home_slider -->

                        <div class="single_home_slider">
                            <div class="home-overlay"></div>
                            <div class="main_home wow fadeInUp" data-wow-duration="700ms">
                                <h2>we are clemo.</h2>
                                <div class="separator"></div>
                                <p class="subtitle">professionals <br />
                                    in the creative industries</p>
                                <div class="home_btn">
                                    <a href="#" class="btn">Learn More</a>
                                </div>
                            </div>
                        </div><!-- End of single_home_slider -->

                        <div class="single_home_slider">
                            <div class="home-overlay"></div>
                            <div class="main_home wow fadeInUp" data-wow-duration="700ms">
                                <h2>we are clemo.</h2>
                                <div class="separator"></div>
                                <p class="subtitle">professionals <br />
                                    in the creative industries</p>
                                <div class="home_btn">
                                    <a href=""""),_display_(/*46.47*/routes/*46.53*/.LoginController.getLogin()),format.raw/*46.80*/("""" class="btn">Login</a>
                                </div>
                            </div>
                        </div><!-- End of single_home_slider -->
                    </div>
                </div>
            </div>
        </div>
    </section><!-- End of Home Section -->


""")))}),format.raw/*57.2*/("""
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
                  SOURCE: J:/GitHub/Awexa/Awexa-Web/awexa/app/views/index.scala.html
                  HASH: 740f40424a29bba8cf08c54997023ac1e0ba2dea
                  MATRIX: 948->1|1059->17|1089->22|1110->35|1149->37|1181->43|1692->527|1720->534|2088->875|2103->881|2151->908|3671->2401|3686->2407|3734->2434|4068->2738
                  LINES: 28->1|33->1|35->3|35->3|35->3|36->4|47->15|47->15|52->20|52->20|52->20|78->46|78->46|78->46|89->57
                  -- GENERATED --
              */
          