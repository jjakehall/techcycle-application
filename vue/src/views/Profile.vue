<template>
  <div class="page-container">




    <div id="user-info">
      <div class="rider-details">
        <h1>{{ currentUser.username }}'s profile</h1>
        <h5 v-show="currentUser.userWeight !== 0">Rider weight: {{currentUser.userWeight}}</h5>
        <h5 v-show="currentUser.userAge !== 0">Rider age: {{currentUser.userAge}}</h5>
        <b-button v-on:click="toggleShowUserForm()">Edit user details</b-button>
        <form id="user-form" v-if="showUserForm === true">
          <input type="number" placeholder="Rider's weight" v-model="user.userWeight" class="user-inputs">
          <input type="number" placeholder="Rider's age" v-model="user.userAge" class="user-inputs">
          <b-button id="user-submit-buttons" v-on:click="addUserInfo()">Submit</b-button>
        </form>
      </div>


      <div class="bike-cards">
        <h4>{{getBikeText()}}</h4>
        <div id="bike-display-form">
          <div class="d-flex flex-shrink-1 justify-content-md-center row row-cols-auto g-10">
            <div class="card border-primary mb-3 " v-for="bike in equipment" v-bind:key="bike.id" style="width: 12rem;">
              <div class="card-body">
                <h5 class="card-title" id="nickname">{{bike.nickname}}</h5>

              </div>
              <ul class="list-group list-group-flush">
                <li class="list-group-item">Brand: {{bike.bikeBrand}}</li>
                <li class="list-group-item">Model: {{bike.bikeModel}} miles</li>
                <li class="list-group-item">Weight: {{bike.bikeWeight}} miles</li>
                <b-button id="delete" v-on:click="deleteBike(bike.equipmentId)">Delete bike</b-button>
              </ul>

            </div>

            <form id="bike-form" v-if="showBikeForm === true">
              <h5 class="bike-form-header" id ="add-bike">Add a bike!</h5>
              <input type="text" placeholder="bike nickname" v-model="newEquipment.nickname" class="bike-input">
              <input type="text" placeholder="bike brand" v-model="newEquipment.bikeBrand" class="bike-input">
              <input type="text" placeholder="bike model" v-model="newEquipment.bikeModel" class="bike-input">
              <input type="number" placeholder="bike weight" v-model="newEquipment.bikeWeight" class="bike-input">
              <button type="button" class ="btn btn-sm" id="btn-bike" v-on:click="addNewBike()">Submit</button>
            </form>
          </div>
        </div>
        <b-button id="bikeBtn" size="sm" v-on:click="toggleShowBikeForm()">Add a new bike!</b-button>
    </div>
    </div>





  </div>
</template>

<script>
import equipmentService from "@/services/EquipmentService";


export default {
  name: "Profile",
  data() {
    return {
      equipment: [],
      newEquipment: {
        nickname: '',
        bikeBrand: '',
        bikeModel: '',
        bikeWeight: ''
      },
      user: {
        userWeight : '',
        userAge: '',
      },
      currentUser : {},
      showBikeForm: false,
      showUserForm: false,
      userActivities : []
    }
  },
  created() {
    equipmentService.getEquipment().then(response => {
      console.log(response.data)
      this.equipment = response.data
    })
    equipmentService.getUserById().then(response => {
      console.log(response.data)
      this.currentUser = response.data
    })

  },
  methods: {
    deleteBike(equipmentId) {
      this.$router.go(this.$router.currentRoute)
      equipmentService.deleteEquipment(equipmentId).then(response => {
        console.log(response)
      })
    },
    addNewBike() {
      equipmentService.createEquipment(this.newEquipment).then(response => {
        console.log(response)
        this.$router.go(this.$router.currentRoute)
      })
    },
    addUserInfo() {
      equipmentService.addUserInfo(this.user).then(response => {
        console.log(response)
        this.$router.go(this.$router.currentRoute)
      })
    },
    toggleShowBikeForm() {
      if(this.showBikeForm === true) {
        this.showBikeForm = false
      } else {
        this.showBikeForm= true;
      }
    },
    toggleShowUserForm() {
      if (this.showUserForm === true) {
        this.showUserForm = false;
      } else {
        this.showUserForm = true;
      }
    },
    getBikeText() {
      if (this.equipment.length === 0) {
        return "You have no bikes to display."
      } else {
        return "My Bikes"
      }
    }
  }
}
</script>

<style scoped>

#nickname{
  color: black !important;
}
#add-bike {
  color: black;
}

.rider-details {
  margin-top: 10px;
  margin-left: 20px;
}



.user-inputs {
  margin: 4px;
  border-radius: 4px;
}

#user-submit-buttons {
  margin: 5px;
}

.rider-details {
  text-align: left;
}

#delete {
  margin: 5px;
}

#user-form {
  display: flex;
  flex-direction: column;
  max-width: 15%;
  min-width: 30%;
  border: solid 1px black;
  padding: 10px;
  border-radius: 5px;
  margin: 10px;
  background-color: rgb(175, 182, 181);
  box-shadow: 5px 5px 20px black;
}

.page-container {
  text-align: center;
  display: flex;
  justify-content: center;
  background: linear-gradient(to bottom, rgb(50, 243, 233), black);

  
}

#bike-form {
  display: flex;
  flex-direction: column;
  justify-items: center;
  max-width: 25%;
  border: 1px solid black;
  padding: 5px;
  border-radius: 5px;
  background-color: rgb(175, 182, 181);
  box-shadow: 5px 5px 20px black;
  margin-bottom: 5px;

}


#user-info {

  
  display: flex;
  flex-direction: column;
  justify-items: center;
  align-content: center;
  min-width: 35%;
  max-height: 62%;
  left: 50%;
  margin: 5%;
  padding: 20px;
  border-radius: 10px;
  background-color: #334147;
  box-shadow: 5px 5px 20px black;
}

.bike-input {
  margin: 4px;

}

.bike-form-header {
  margin-top: 5px;
}

h1 {
  color: white;
}

h5 {
  color: white;
}

h4 {
  color: white;
  margin-top: 10px;
}
</style>