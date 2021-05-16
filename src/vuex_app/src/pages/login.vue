<template>
 <div class="container register-form">

  <form @submit.prevent="submit">
  <div class="form-group">
    <label for="exampleInputEmail1">Username</label>
    <input type="username" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Enter email" v-model = "form.username">
    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" id="password" placeholder="Password" v-model="form.password">
  </div>
 
  <button type="submit" class="btn btn-primary">Submit</button>
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
          console.log(this.authorized);
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
          this.redirect()
         })
           

              
            
          }

        
          
        
      

      }
     

    
  }
</script>