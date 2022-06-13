<template>
  <div id="registerbackground" class="text-center" :style="{'backgroundImage': 'url(' + require('./../assets/mountainbackground.jpg') + ')' }">
    <form class="form-register" @submit.prevent="register" id="form">
      <h1 id="register-text">Create<br>Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <br>
      <label for="username" class="sr-only">Username</label><br>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      /><br>
      <label for="password" class="sr-only">Password</label><br>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      /><br>
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      /><br><br>
      <button class="lets-go" type="submit">
        Let's go!
      </button><br><br><br>
      <router-link id="haveaccount" :to="{ name: 'login' }">Have an account?</router-link><br><br>
    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>
.sr-only {
  font-weight: bold;
}
#register-text {
  font-size: 44px;
  text-shadow: 3px 3px #ffffff;
}

#registerbackground {
  display: grid;
  place-content: center;
  height: 95.75%;
  background-size: cover;
  align-items: center;
  justify-items: center;
}

/*#registerbackground {
  height: 100vh;
  background-size: cover;
  align-items: center;

}*/

#form {
  font-family: 'Nunito', sans-serif;
  display: block;
  padding: 100px 70px 100px 70px;
  text-align: center;
  border: 1px solid black;
  background-color: rgb(50, 243, 233);
  border-radius: 7px;
  box-shadow: 5px 5px black;
}

.lets-go {
  background-color: rgb(0, 0, 0);
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
  -webkit-transition-duration: 0.4s; /* Safari */
  transition-duration: 0.4s;
  border-radius: 5px;
}

.lets-go:hover {
  box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
}

#haveaccount {
  text-decoration: none;
  font-weight: bold;
  color: black;
}

#haveaccount:hover {
  color: gray;
}
</style>
