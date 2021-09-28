<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

<link rel='stylesheet' href="CSS/main/movie.css">
<link rel='stylesheet' href="swiper/swiper.min.css">
<script src="swiper/swiper.min.js"></script>

</head>
<body>

<!-- 
YouTube will not autoplay videos unless muted.  Videos are looped as a playlist.

Note - images are called from YouTube in default high res.  See the following reference for YouTube Video thumbs.

https://stackoverflow.com/questions/12788287/how-to-get-hq-youtube-thumbnails

Simply change the YouTube Video ID in slides.
-->

<!-- Swiper Container . -->

<section class="swiper-container loading">

  <div class="swiper-wrapper">
    <!-- Begin Slide -->
    <div class="swiper-slide">
      <div class="videoWrapper js-videoWrapper">
        <!-- YouTube iFrame Embed  -->

        <iframe class="videoIframe js-videoIframe" src="" frameborder="0" allowTransparency="true" allowfullscreen src="" style="background-image:url(img/main/visual/3.png); background-repeat: no-repeat;background-size: 100%; " allow="autoplay; fullscreen"></iframe>
        <!--  Video Poster - in the form of a button to make it keyboard accessible -->

        <!-- Poster frame in the form of a button to make it keyboard accessible. Background is Youtube Image  -->
        
      </div>
      
    </div>

    <!-- BEGIN SLIDE -->
    <div class="swiper-slide">
      <div class="videoWrapper js-videoWrapper">
        <!-- YouTube iframe. Embed -->

        <iframe class="videoIframe js-videoIframe" src="" frameborder="0" allowTransparency="true" allowfullscreen src="" style="background-image:url(img/main/visual/2.png); background-repeat: no-repeat;background-size: 100%; " allow="autoplay; fullscreen"></iframe>
        <!-- Poster frame in the form of a button to make it keyboard accessible. Background is Youtube Image  -->
        
      </div>
      <!-- Slide Caption -->
      <!-- // End Slide Container -->
    </div>
    <!-- // END  SLIDE ->
    
        <!-- BEGIN SLIDE -->
    <div class="swiper-slide">
      <div class="videoWrapper js-videoWrapper">

        <!-- YouTube iFrame.Embed  -->

        <iframe class="videoIframe js-videoIframe" src="" frameborder="0" allowTransparency="true" allowfullscreen src="" style="background-image:url(img/main/visual/3.png); background-repeat: no-repeat;background-size: 100%; " allow="autoplay; fullscreen"></iframe>
        <!-- Poster frame in the form of a button to make it keyboard accessible. Background is Youtube Image  -->
      </div>
      <!-- Slide Caption -->
      <!-- // End Slide Container -->
    </div>
    <!-- // END  SLIDE ->
    
   <!-- BEGIN SLIDE -->
    <div class="swiper-slide">
      <div class="videoWrapper js-videoWrapper">

        <!-- YouTube iFrame.Embed  -->

        <iframe class="videoIframe js-videoIframe" src="" frameborder="0" allowTransparency="true" allowfullscreensrc="" style="background-image:url(img/main/visual/2.png); background-repeat: no-repeat;background-size: 100%; " allow="autoplay; fullscreen"></iframe>
        <!-- Poster frame in the form of a button to make it keyboard accessible. Background is Youtube Image  -->
      </div>
      <!-- Slide Caption -->
      <!-- // End Slide Container -->
    </div>
    <!-- // END  SLIDE ->

   <!-- BEGIN SLIDE -->
    <div class="swiper-slide">
      <div class="videoWrapper js-videoWrapper">

        <!-- YouTube iFrame.Embed  -->

        <iframe class="videoIframe js-videoIframe"  src="" frameborder="0" allowTransparency="true" allowfullscreen src="" style="background-image:url(img/main/visual/1.png); background-repeat: no-repeat; background-size: 100%; " allow="autoplay; fullscreen"></iframe>
        <!-- Poster frame in the form of a button to make it keyboard accessible. Background is Youtube Image  -->
       
      </div>
      <!-- Slide Caption -->
      <!-- // End Slide Container -->
    </div>
    <!-- // END  SLIDE ->
   <!-- BEGIN SLIDE -->
    <div class="swiper-slide">
      <div class="videoWrapper js-videoWrapper">

        <!-- YouTube iFrame.Embed  -->

        <iframe class="videoIframe js-videoIframe" src="" frameborder="0" allowTransparency="true" allowfullscreen src="" style="background-image:url(img/main/visual/3.png); background-repeat: no-repeat; background-size: 100%;" allow="autoplay; fullscreen"></iframe>
        <!-- Poster frame in the form of a button to make it keyboard accessible. Background is Youtube Image  -->
        
      </div>
      <!-- Slide Caption -->
      <!-- // End Slide Container -->
    </div>
    <!-- // END  SLIDE ->


  <!--  // END SWIPER WRAPPER. -->
  </div>

  <!--  Bullets 
  Uncomment and remove class hidden from css for bullets
  <div class="swiper-pagination"></div>
-->
  <!-- Navigation Arrows -->
  <div class="swiper-button-prev swiper-button-white"></div>
  <div class="swiper-button-next swiper-button-white"></div>
</section>
<script src="js/jquery-3.6.0.min.js"></script>
<script src="js/custom_js/movie.js"></script>



</body>

</html>




