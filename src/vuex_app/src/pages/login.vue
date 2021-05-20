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
          
          if(this.authorized) {
          this.$router.replace({
                name: 'ProductList'
              }) 
              } else {
                this.loginfailed = true
          }

        },
        async submit(){ 
          
         await this.signIn(this.form).then(() =>{
           console.log("submit invoked")
          this.redirect()
         })
         
           

              
            
          }

        
          
        
      

      }
     

    
  }
</script>