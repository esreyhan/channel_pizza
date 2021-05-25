<template>
 <div class="container register-form">

  <form @submit.prevent="submit">
  <div class="form-group">
    <label for="exampleInputEmail1">Username</label>
    <input id="username" type="username" class="form-control" aria-describedby="emailHelp" placeholder="Enter Username" v-model = "form.username">
    <small id="emailHelp" class="form-text text-muted">We'll never share your information with anyone else.</small>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input id="password" type="password" class="form-control"  placeholder="Password" v-model="form.password">
  </div>
 
  <button type="submit" id="submit" class="btn btn-primary">Submit</button>
</form>
<br>
<div v-if="loginfailed">
  Login failed : Login information is incorrect
</div>

        </div>

</template>

<script>
/**
 * This is a login page for user signin. 
 * 
 * Vuex store is used for keeping product and user information. 
 */
import {mapActions} from 'vuex'
import {mapState} from 'vuex'
  export default {
    name:'signin',
    
   
       data () {
      return {
        form:{
          username:'',
          password:'',
          
        },
        loginfailed:false
      }
      },
      computed: {
        ...mapState({
        authorized: state => state.auth.user
      
      })
      },
      methods: {
        ...mapActions({
            signIn: 'auth/signIn',
            authenticated:'auth/authenticated',
            user:'auth/authenticated'
        }),
       redirect () {
        /**
         * The user data is checked in the function upon submit button.
         * If registration is successful, the user is redirected to the ProductList component. 
         */
          if(this.authorized) {
          this.$router.replace({
                name: 'ProductList'
              }) 
              } else {
                this.loginfailed = true
          }

        },

        /**
         * if the axios call in the signIn vuex actions is successful, the redirect function is called. 
         */
        async submit(){ 
          /**
           * @param {object} takes form object as a parameter. 
           */
         await this.signIn(this.form).then(() =>{
          this.redirect()
         })
         
           

              
            
          }

        
          
        
      

      }
     

    
  }
</script>