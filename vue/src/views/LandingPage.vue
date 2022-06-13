<template>
  <div id="landingPageBackground">
    <template>
      <div class="carousel-container">
        
        <b-carousel
            id="carousel-1"
            v-model="slide"
            :interval="4000"
            indicators
            background="#ababab"
            img-width="1024"
            img-height="480"
            style="text-shadow: 1px 1px 2px #333;"
            @sliding-start="onSlideStart"
            @sliding-end="onSlideEnd"
        >
          <!-- Text slides with image -->
          <b-carousel-slide
              img-src="https://cyclingmagazine.ca/wp-content/uploads/2020/05/brands_banner-1024x480.jpg"
          ></b-carousel-slide>
          <b-carousel-slide
              img-src="https://digitsole.com/wp-content/uploads/2018/03/different-type-cyclists.jpg">
          </b-carousel-slide>
          <b-carousel-slide
              img-src="http://cdn.shopify.com/s/files/1/0235/4757/articles/The-Big-Deal-About-29-Inch-Wheels_1024x1024.jpg?v=1613706732"></b-carousel-slide>
          <b-carousel-slide
              img-src="https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/german-cyclist-piet-van-kempen-circles-the-track-at-wembley-news-photo-3166150-1541536330.jpg"></b-carousel-slide>

          <b-carousel-slide>
            <template #img>
              <img
                  class="d-block img-fluid w-100"
                  width="1024"
                  height="480"
                  src="https://digitsole.com/wp-content/uploads/2018/03/different-type-cyclists.jpg"
                  alt="image slot"
              >
            </template>
          </b-carousel-slide>
      
          <div class="get-local-trails">
            <div id="welcome"><h1 >Welcome to TEchCycle!</h1></div>
            <h3>Explore your backyard</h3><br>
            <input type="text" name=address v-model="address" placeholder="Enter an address..." id="search-box"><br>
            <b-button id="btn" type="submit" class="btn save" :disabled="address === ''" v-on:click="getTrails()" variant="dark">Search Trails</b-button>
            <b-button id="btn" type="submit" class="btn save" :disabled="address === ''" v-on:click="getSegments()" variant="dark">Search Strava Segments</b-button>
        </div>

        </b-carousel>
      </div>
    </template>
    <!-- <trail-api/>
    <activities activities="activities"></activities> 
      -->

  </div>
</template>

<script>

// import activityService from "@/services/ActivityService";
// import Activities from "@/components/Activities";
// import TrailApi from "@/components/TrailApi";
import activityService from "@/services/ActivityService";
export default {
  name: "landing-page",
  // components: {TrailApi, Activities},
  data() {
    return {
      activities: [],
      address: '',
    }
  },
  created() {
    this.retrieveActivities();
  },
  methods: {
    retrieveActivities() {
      activityService.getPublicActivities().then(response => {
        this.$store.commit("SET_PUBLIC_ACTIVITIES", response.data)
        this.activities = response.data
      })
      if (this.$store.token !== '') {
        activityService.getUserActivity().then(response => {
          this.$store.commit("SET_USER_ACTIVITIES", response.data)
        })
      }
    },

    getTrails()
    {
      this.$router.push({name: 'trails', params: {address: this.address}})
    },
    getSegments()
    {
      this.$router.push({name: 'segments', params: {address:this.address}})
    }
  }
}
</script>

<style scoped>


#welcome {
  position: absolute;
  width: 100%;
  top: 10%;
  z-index: 20;
}

h1 {
  font-size: 100px;
  font-weight: bolder;
  color: white;
  text-shadow: 5px 5px #000000;

}

h3 {
  font-weight: bolder;
  font-size: 45px;
  color: white;
  text-shadow: 3px 3px #000000;
  top: 30%;
  margin-top: 16%;
}

#btn {
  margin: 15px;
  padding: 15px 60px;
  border-radius: 10px;
  background-color: transparent;
  border: none;
  font-size: 22px;

}

#btn:hover {
  background-color: black;
  box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
}
#btn::before{
  content: "🚴";
}

.get-local-trails {
  position:absolute;
  width: 100%;
}

.carousel-container {
  position: relative;
  display: inline-block;
  height: 100vh !important;
  width: 100vw !important;
  text-align: center;
  /* line-height: 9; */
  

}

#search-box {
  border-radius: 50px;
  height: 5rem;
  width: 40rem;
  text-align: center;
  box-shadow: 0 0 30px #000;
  border: none;
  font-size: 30px;
  
}

#search-box:hover {
  border: none;
  cursor: pointer;
}




.btn-save {
  color: white;
}

/*#landingPageBackground {*/
/*!*  display: grid;*!*/
/*!*  place-content: center;*!*/

/*!*  background-size: cover;*!*/
/*!*  align-items: center;*!*/
/*!*  justify-items: center;*!*/
/*!*}*!*/

</style>
<!--class="container" :style="{'backgroundImage': 'url(' + require('./../assets/Lback77.jpg') + ')' }"-->