<template>
<div>

<div id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active" style="Width:60%,height:60%" >
      <router-link :to="{name:'ProductList'}">
      <img class="d-block w-100" src="https://images.pexels.com/photos/825661/pexels-photo-825661.jpeg?cs=srgb&dl=pexels-brett-jordan-825661.jpg&fm=jpg" alt="First slide">
      </router-link>
    </div>
     <div class="carousel-caption d-none d-md-block">
    <h5>Best Pizza in London</h5>
    <p> Please click for the Menu</p>
  </div>
  
  </div>
</div>

</div>

</template>

<script>


// Local registration
export default {
    components: {
        
    }
}

</script>

<style>
.carousel {
  width:80%;
  height:70%;
}
</style>