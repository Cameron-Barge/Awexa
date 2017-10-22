
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

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /*
 * This template is called from the `index` template. This template
 * handles the rendering of the page header and body tags. It takes
 * two arguments, a `String` for the title of the page and an `Html`
 * object to insert into the body of the page.
 */
  def apply/*7.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*7.32*/("""

"""),format.raw/*9.1*/("""<!DOCTYPE HTML>
<html class="no-js" lang="">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>"""),_display_(/*14.17*/title),format.raw/*14.22*/("""</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        """),format.raw/*18.23*/("""
        """),format.raw/*19.9*/("""<link rel="stylesheet" media="screen" href=""""),_display_(/*19.54*/routes/*19.60*/.Assets.versioned("stylesheets/main.css")),format.raw/*19.101*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*20.59*/routes/*20.65*/.Assets.versioned("images/favicon.png")),format.raw/*20.104*/("""">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">
        <link rel="stylesheet" media="screen" href=""""),_display_(/*22.54*/routes/*22.60*/.Assets.versioned("stylesheets/fonticons.css")),format.raw/*22.106*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(/*23.54*/routes/*23.60*/.Assets.versioned("stylesheets/slider-pro.css")),format.raw/*23.107*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(/*24.54*/routes/*24.60*/.Assets.versioned("stylesheets/font-awesome.min.css")),format.raw/*24.113*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(/*25.54*/routes/*25.60*/.Assets.versioned("stylesheets/bootstrap.min.css")),format.raw/*25.110*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(/*26.54*/routes/*26.60*/.Assets.versioned("stylesheets/plugins.css")),format.raw/*26.104*/("""" />
        <link rel="stylesheet" media="screen" href=""""),_display_(/*27.54*/routes/*27.60*/.Assets.versioned("stylesheets/main.css")),format.raw/*27.101*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(/*28.54*/routes/*28.60*/.Assets.versioned("stylesheets/responsive.css")),format.raw/*28.107*/("""" />
        <script src=""""),_display_(/*29.23*/routes/*29.29*/.Assets.versioned("js/vendor/modernizr-2.8.3-respond-1.4.2.min.js")),format.raw/*29.96*/(""""></script>
    </head>
    <body data-spy="scroll" data-target=".navbar-collapse">
        """),format.raw/*32.44*/("""
        """),format.raw/*33.9*/("""<header id="main_menu" class="header navbar-fixed-top">
            <div class="main_menu_bg">
                <div class="container">
                    <div class="row">
                        <div class="nave_menu">
                            <nav class="navbar navbar-default" id="navmenu">
                                <div class="container-fluid">
                                    <!-- Brand and toggle get grouped for better mobile display -->
                                    <div class="navbar-header">
                                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                                                data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                                            <span class="sr-only">Toggle navigation</span>
                                            <span class="icon-bar"></span>
                                            <span class="icon-bar"></span>
                                            <span class="icon-bar"></span>
                                        </button>
                                        <a class="navbar-brand" href=""""),_display_(/*49.72*/routes/*49.78*/.HomeController.index()),format.raw/*49.101*/("""">
                                            <img src="assets/images/logo.png"/>
                                        </a>
                                    </div>

                                    <!-- Collect the nav links, forms, and other content for toggling -->
                                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                                        <ul class="nav navbar-nav navbar-right">
                                            <li><a href="#">about us</a></li>
                                            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"
                                                                    role="button" aria-haspopup="true">services</a>
                                                <ul class="dropdown-menu">
                                                    <li><a href="#">service page</a></li>
                                                    <li><a href="#">service page two</a></li>
                                                </ul>
                                            </li>
                                            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"
                                                                    role="button" aria-haspopup="true">works</a>
                                                <ul class="dropdown-menu">
                                                    <li><a href="#">work page</a></li>
                                                    <li><a href="#">work page Two</a></li>
                                                </ul>
                                            </li>
                                            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"
                                                                    role="button" aria-haspopup="true">blog</a>
                                                <ul class="dropdown-menu">
                                                    <li><a href="#">blog page</a></li>
                                                    <li><a href="#">singleblog page</a></li>
                                                </ul>
                                            </li>
                                            <li><a href="contact.html">contact</a></li>
                                        </ul>
                                    </div>

                                </div>
                            </nav>
                        </div>
                    </div>

                </div>

            </div>
        </header> <!--End of header -->


        """),format.raw/*95.32*/("""
        """),_display_(/*96.10*/content),format.raw/*96.17*/("""

        """),format.raw/*98.9*/("""<!-- footer Section -->
        <footer id="footer" class="footer">
            <div class="container">
                <div class="main_footer">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="copyright_text text-center">
                                <p class=" wow fadeInRight" data-wow-duration="1s">Copyright 2019 Awexa.
                                All Rights Reserved</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!-- End of container -->
        </footer><!-- End of footer -->

         """),format.raw/*114.22*/("""
        """),format.raw/*115.9*/("""<script src=""""),_display_(/*115.23*/routes/*115.29*/.Assets.versioned("js/vendor/jquery-1.11.2.min.js")),format.raw/*115.80*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*116.23*/routes/*116.29*/.Assets.versioned("js/vendor/bootstrap.min.js")),format.raw/*116.76*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*117.23*/routes/*117.29*/.Assets.versioned("js/jquery.easing.1.3.js")),format.raw/*117.73*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*118.23*/routes/*118.29*/.Assets.versioned("js/masonry/masonry.min.js")),format.raw/*118.75*/("""" type="text/javascript"></script>
        <script type="text/javascript">
                $('.mixcontent').masonry();
        </script>
        <script src=""""),_display_(/*122.23*/routes/*122.29*/.Assets.versioned("js/jquery.sliderPro.min.js")),format.raw/*122.76*/(""""></script>
        <script type="text/javascript">
                $(document).ready(function ($) """),format.raw/*124.48*/("""{"""),format.raw/*124.49*/("""
                    """),format.raw/*125.21*/("""$('#example3').sliderPro("""),format.raw/*125.46*/("""{"""),format.raw/*125.47*/("""
                        """),format.raw/*126.25*/("""width: 960,
                        height: 200,
                        fade: true,
                        arrows: false,
                        buttons: true,
                        fullScreen: false,
                        shuffle: true,
                        smallSize: 500,
                        mediumSize: 1000,
                        largeSize: 3000,
                        thumbnailArrows: true,
                        autoplay: false,
                        thumbnailsContainerSize: 960

                    """),format.raw/*140.21*/("""}"""),format.raw/*140.22*/(""");
                """),format.raw/*141.17*/("""}"""),format.raw/*141.18*/(""");
        </script>
        <script src=""""),_display_(/*143.23*/routes/*143.29*/.Assets.versioned("js/plugins.js")),format.raw/*143.63*/(""""></script>
        <script src=""""),_display_(/*144.23*/routes/*144.29*/.Assets.versioned("js/main.js")),format.raw/*144.60*/(""""></script>
    </body>
</html>
"""))
      }
    }
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sun Oct 22 18:59:09 EDT 2017
                  SOURCE: J:/GitHub/Awexa/Awexa-Web/awexa/app/views/main.scala.html
                  HASH: 3b19e960efddb5ca7e21ca9335ac11cbf7dc0322
                  MATRIX: 1211->266|1336->296|1366->300|1572->479|1598->484|1770->642|1807->652|1879->697|1894->703|1957->744|2046->806|2061->812|2122->851|2305->1007|2320->1013|2388->1059|2472->1116|2487->1122|2556->1169|2640->1226|2655->1232|2730->1285|2814->1342|2829->1348|2901->1398|2985->1455|3000->1461|3066->1505|3152->1564|3167->1570|3230->1611|3314->1668|3329->1674|3398->1721|3453->1749|3468->1755|3556->1822|3679->1952|3716->1962|4952->3171|4967->3177|5012->3200|7827->6078|7865->6089|7893->6096|7932->6108|8649->6808|8687->6818|8729->6832|8745->6838|8818->6889|8904->6947|8920->6953|8989->7000|9075->7058|9091->7064|9157->7108|9243->7166|9259->7172|9327->7218|9518->7381|9534->7387|9603->7434|9733->7535|9763->7536|9814->7558|9868->7583|9898->7584|9953->7610|10526->8154|10556->8155|10605->8175|10635->8176|10708->8221|10724->8227|10780->8261|10843->8296|10859->8302|10912->8333
                  LINES: 33->7|38->7|40->9|45->14|45->14|49->18|50->19|50->19|50->19|50->19|51->20|51->20|51->20|53->22|53->22|53->22|54->23|54->23|54->23|55->24|55->24|55->24|56->25|56->25|56->25|57->26|57->26|57->26|58->27|58->27|58->27|59->28|59->28|59->28|60->29|60->29|60->29|63->32|64->33|80->49|80->49|80->49|125->95|126->96|126->96|128->98|144->114|145->115|145->115|145->115|145->115|146->116|146->116|146->116|147->117|147->117|147->117|148->118|148->118|148->118|152->122|152->122|152->122|154->124|154->124|155->125|155->125|155->125|156->126|170->140|170->140|171->141|171->141|173->143|173->143|173->143|174->144|174->144|174->144
                  -- GENERATED --
              */
          