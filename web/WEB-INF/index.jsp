<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>实时数据</title>

	<link href="../css/font-awesome.min.css" rel="stylesheet">
	<link href="../css/bootstrap.min.css" rel="stylesheet">
	<link href="../css/bootstrap-datetimepicker.min.css" rel="stylesheet">
	<link href="../css/flexslider.css" rel="stylesheet">
	<link href="../css/templatemo-style.css" rel="stylesheet">

	<!--script-- src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script-->
	<script type="text/javascript" src="../jquery-1.11.3.min.js"></script>

<script type="text/javascript">

    function fn1() {
        //get异步访问
        $.get(
            "DataServlet",
			function (data) {
                alert(123);
                /*document.getElementById("temperature").innerHTML=data.temperature;
            document.getElementById("turbidity").innerHTML=data.currentime;
            document.getElementById("ph").innerHTML=data.currentime;
            document.getElementById("currentime").innerHTML=data.currentime;*/
            },
            "json"
        );
    }

    $("button").click(function () {
		$.post("/cn/fcscanf/web/servlet/NowDataServlet",
		function (data,status) {
            alert("数据: \n" + data + "\n状态: " + status);
        },
		"json"
		);
    });

</script>

  </head>
  <body class="tm-gray-bg">
  	<!-- Header -->
  	<div class="tm-header">
  		<div class="container">
  			<div class="row">
  				<div class="col-lg-6 col-md-4 col-sm-3 tm-site-name-container">
  					<span>
						<a href="#" class="tm-site-name" onclick="fn1()">水质监测数据显示</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href='/data.html' class="tm-site-name">折线显示实时数据</a>&nbsp;&nbsp;&nbsp;&nbsp;
					</span>
  				</div>
	  			<div class="col-lg-6 col-md-8 col-sm-9">
	  				<div class="mobile-menu-icon">
		              <i class="fa fa-bars"></i>
		            </div>
	  			</div>				
  			</div>
  		</div>	  	
  	</div>
	
	<!-- Banner -->
	<section class="tm-banner">
		<!-- Flexslider -->
		<div class="flexslider flexslider-banner">
		  <ul class="slides">
		    <li>
			    <div class="tm-banner-inner">
					<h1 class="tm-banner-title">基于云平台的物联网水质监测预警系统</h1>
				</div>
				<img src="../img/banner-1.jpg" alt="Image" />
		    </li>
		    <li>
			    <div class="tm-banner-inner">
					<h1 class="tm-banner-title">基于云平台的物联网水质监测预警系统</h1>
				</div>
		      <img src="../img/banner-2.jpg" alt="Image" />
		    </li>
		    <li>
			    <div class="tm-banner-inner">
					<h1 class="tm-banner-title">基于云平台的物联网水质监测预警系统</h1>
				</div>
		      <img src="../img/banner-3.jpg" alt="Image" />
		    </li>
		  </ul>
		</div>	
	</section>

	<!-- gray bg -->	
	<section class="container tm-home-section-1" id="more">
		<div class="row">

			<button>nowdata</button>
			<div>
				<form action="ShowDataServlet" method="post"><!-- method可改成get看请求地址 -->
					<input type="submit" value="ShowData"><!--得到历史的数据库数据-->
				</form>
			</div>

			<div class="col-lg-3 col-md-3 col-sm-6">
				<div class="tm-home-box-1 tm-home-box-1-2 tm-home-box-1-center">
					<!--img src="img/index-02.jpg" alt="image" height="335px" width="335px"-->
					<div class="tm-green-gradient-bg tm-city-price-container">
							<p  class="tm-banner-subtitle">温度</p>
						</div>	
						<div class="tm-green-gradient-bg tm-city-price-container">
							<p id="temperature" class="tm-banner-subtitle">0</p>
						</div>	
							
				</div>				
			</div>
			
			<div class="col-lg-3 col-md-3 col-sm-6">
				<div class="tm-home-box-1 tm-home-box-1-2 tm-home-box-1-center">
					<!--img src="img/index-01.jpg" alt="image" height="335px" width="335px"-->
					<div class="tm-green-gradient-bg tm-city-price-container">
							<p  class="tm-banner-subtitle">浊度</p>
						</div>	
						<div class="tm-green-gradient-bg tm-city-price-container">
							<p id="turbidity" class="tm-banner-subtitle">0</p>
						</div>	
							
				</div>				
			</div>
			
			<div class="col-lg-3 col-md-3 col-sm-6">
				<div class="tm-home-box-1 tm-home-box-1-2 tm-home-box-1-center">
					<!--img src="img/index-03.jpg" alt="image" height="335px" width="335px"-->
					<div class="tm-green-gradient-bg tm-city-price-container">
							<p  class="tm-banner-subtitle">PH</p>
						</div>	
						<div class="tm-green-gradient-bg tm-city-price-container">
							<p id="ph" class="tm-banner-subtitle">0</p>
						</div>	
							
				</div>				
			</div>

			<div class="col-lg-3 col-md-3 col-sm-6">
				<div class="tm-home-box-1 tm-home-box-1-2 tm-home-box-1-center">
					<!--img src="img/index-04.jpg" alt="image" height="335px" width="335px"-->
					<div class="tm-green-gradient-bg tm-city-price-container">
							<p class="tm-banner-subtitle">当前时间</p>
						</div>	
						<div class="tm-green-gradient-bg tm-city-price-container">
							<p id="currentme" class="tm-banner-subtitle">0</p>
						</div>

				</div>				
			</div>

			<div class="col-lg-3 col-md-3 col-sm-6">
				<div class="tm-home-box-1 tm-home-box-1-2 tm-home-box-1-center">
					<div >
						</div>	
						<div >
						</div>	
							
				</div>				
			</div>
			
		</div>
	
		
			
				
				
				
			
	</section>		
	
	
	<footer class="tm-black-bg">
		<div class="container">
			<div class="row">
			</div>
		</div>		
	</footer>
	<script type="text/javascript" src="../js/jquery-1.11.2.min.js"></script>      		<!-- jQuery -->
  	<script type="text/javascript" src="../js/moment.js"></script>							<!-- moment.js -->
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>					<!-- bootstrap js -->
	<script type="text/javascript" src="../js/bootstrap-datetimepicker.min.js"></script>	<!-- bootstrap date time picker js, http://eonasdan.github.io/bootstrap-datetimepicker/ -->
	<script type="text/javascript" src="../js/jquery.flexslider-min.js"></script>
<!--
	<script src="js/froogaloop.js"></script>
	<script src="js/jquery.fitvid.js"></script>
-->
   	<script type="text/javascript" src="../js/templatemo-script.js"></script>      		<!-- Templatemo Script -->
	<script>
		// HTML document is loaded. DOM is ready.
		$(function() {

			$('#hotelCarTabs a').click(function (e) {
			  e.preventDefault()
			  $(this).tab('show')
			})

        	$('.date').datetimepicker({
            	format: 'MM/DD/YYYY'
            });
            $('.date-time').datetimepicker();

			// https://css-tricks.com/snippets/jquery/smooth-scrolling/
		  	$('a[href*=#]:not([href=#])').click(function() {
			    if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'') && location.hostname == this.hostname) {
			      var target = $(this.hash);
			      target = target.length ? target : $('[name=' + this.hash.slice(1) +']');
			      if (target.length) {
			        $('html,body').animate({
			          scrollTop: target.offset().top
			        }, 1000);
			        return false;
			      }
			    }
		  	});
		});
		
		// Load Flexslider when everything is loaded.
		$(window).load(function() {	  		
			// Vimeo API nonsense

/*
			  var player = document.getElementById('player_1');
			  $f(player).addEvent('ready', ready);
			 
			  function addEvent(element, eventName, callback) {
			    if (element.addEventListener) {
			      element.addEventListener(eventName, callback, false)
			    } else {
			      element.attachEvent(eventName, callback, false);
			    }
			  }
			 
			  function ready(player_id) {
			    var froogaloop = $f(player_id);
			    froogaloop.addEvent('play', function(data) {
			      $('.flexslider').flexslider("pause");
			    });
			    froogaloop.addEvent('pause', function(data) {
			      $('.flexslider').flexslider("play");
			    });
			  }
*/

			 
			 
			  // Call fitVid before FlexSlider initializes, so the proper initial height can be retrieved.
/*

			  $(".flexslider")
			    .fitVids()
			    .flexslider({
			      animation: "slide",
			      useCSS: false,
			      animationLoop: false,
			      smoothHeight: true,
			      controlNav: false,
			      before: function(slider){
			        $f(player).api('pause');
			      }
			  });
*/


			  

//	For images only
		    $('.flexslider').flexslider({
			    controlNav: false
		    });


	  	});
	</script>
 </body>
 </html>