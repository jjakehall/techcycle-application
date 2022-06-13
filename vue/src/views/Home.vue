<template>
  <div id="homebackground" class="home">
    <div id="centerPage"> 
      </div>
    
        <div class="profile-pic-div">
          <img src="image.jpg" id="photo">
          <input type="file" id="file">
          <label for="file" id="uploadBtn">Choose Photo</label> 
         </div> 
<!--    <a id="link" href="http://www.strava.com/oauth/authorize?client_id=86234&response_type=code&redirect_uri=http://localhost:8080/test&approval_prompt=force&scope=read">LOG IN TO STRAVA</a>-->
 <div id="body">

 </div>
  </div>
</template>

<script>
// const imgDiv = document.querySelector('.profile-pic-div');
// const img = document.querySelector('#photo');
// const file = document.querySelector('#file');
// const uploadBtn = document.querySelector('#uploadBtn');

// imgDiv.addEventListener('mouseenter', function() {
//   uploadBtn.style.display = "block";
// });

// imgDiv.addEventListener('mouseleave', function(){
//   uploadBtn.style.display = "none";
// });

// file.addEventListener('change', function() {
//   const chosenFile = this.files[0];

//   if (chosenFile) {
//     const reader = new FileReader();

//     reader.addEventListener('load', function() {
//       img.setAttribute('src', reader.result);
//     });

//     reader.readAsDataURL(chosenFile);
//   }
// })

export default {
  name: "home",
  data(){
    return {
      address: ''
    }
  },
  methods: {
    getSegments()
    {
      this.$router.push({name: 'segments', params: {address:this.address}})
    }
  }

};
</script>

<style scoped>


#centerPage {
  background-color: white;
  width: 50%;
  height: 60vh;
  margin-left: 25%;
  margin-top: 5%;
  margin-bottom: 100%;
  border-radius: 5%;
  box-shadow: 5px 5px 5px #000;
  background-color: rgb(245, 245, 245);
}

#sidenav {
    border: 2px solid black;
    height: 100%;
    width: 10%;
    position: fixed;
    z-index: 1;
    background-color: white;
    padding-top: 20px;
    padding-bottom: 20px;
    left: 0;
    top: 0;
}

#homebackground {
  background-image: linear-gradient(to bottom, gray, black);
  height: 95.75%;
  line-height: 4;
  background-size: cover;
}

  #heading {
    color: white;

  }

body{
margin:0;
height: 100vh;
width: 100%;
}

img{
  height: 200px;
}

*{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

h1{
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  text-align: center;
  font-size: 30px;
  color: #222;
}

.profile-pic-div {
  height: 200px;
  width: 200px;
  position: absolute;
  top: 26%;
  left: 33%;
  transform: translate(-50%, -50%);
  border-radius: 50%;
  overflow: hidden;
  border: 1px solid gray;
}

#photo{
  height: 100%;
  width: 100%
}

#file{
  display: none;
}

#uploadBtn {
  height: 40px;
  width: 100%;
  position: absolute;
  bottom: 0;
  left: 50%;
  transform: translateX(-50%);
  text-align: center;
  background-color: #000;
  color: #fff;
  line-height: 30px;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  font-size: 15px;
  cursor: pointer;
}




  /* #body {
    margin-top: 60px;
    margin-left: 10px;
    margin-right: 10px;
    display: block;
    background-color: white;
    width: 100%;
    height: 90%;
    bottom: 0;


  } */





</style>








