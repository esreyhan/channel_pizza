<template>
    <div> 
      <nav class="navbar navbar-expand-sm navbar-light navbar-jw">
    <button
      class="navbar-toggler"
      type="button"
      data-toggle="collapse"
      data-target="#appnav"
      aria-controls="appnav"
      aria-expanded="false"
      aria-label="Toggle navigation"
    >
      <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="#">
      <img src="../assets/brand.png" alt="logo" width="50" height="50"/> 
    </a>

    <div class="collapse navbar-collapse" id="appnav">
      <div class="nav navbar-nav">
    <router-link style = "margin-left:20px" :to="{name:'Home'}" class="nav-item nav-link" active-class="active" exact>   Home </router-link>  
   <router-link style = "margin-left:20px" :to="{name:'ProductList'}" class="nav-item nav-link" active-class="active" exact>   Menu </router-link>
     <router-link style = "margin-left:20px" :to="{name:'Minicart'}" class="nav-item nav-link" active-class="active" exact> Cart </router-link>

    <span style = "margin-left:20px" class="nav-item nav-link" active-class="active" exact v-if="authenticated">
    {{user}}
    </span>
    <a style = "margin-left:20px" v-if="authenticated" id="logOut" href="#" class="nav-item nav-link" active-class="active" exact @click="logout()"> Log Out </a>
    
  <template v-else>
  <router-link style = "margin-left:20px" :to="{name:'Login'}" class="nav-item nav-link" active-class="active" exact> Sign-in </router-link>
   <router-link style = "margin-left:20px" :to="{name:'Register'}" class="nav-item nav-link" active-class="active" exact> Register </router-link>

  </template>

 </div>
    </div>
  </nav>


</div>
</template>

<script>


import { mapGetters} from 'vuex'
import { mapActions} from 'vuex'
/**
 *Header component for the application. Vuex store is used both for authentication and product cart information
 * @author Enis Sinan Reyhan <enissinanreyhan@gmail.com>
 * @vue-event {none} logout - vuex signout method is called 
 * @vue-computed {array} cart - cart is returned as list of products 
 * @vue-computed {String} authenticated - user id is get from vuex store getter authenticated 
 * @vue-computed {String} user - username is get from vuex store getter user
 */ 
export default {
  computed : {
    cart() {
      return this.$store.cart;
    },
   
    ...mapGetters ({
      authenticated:'auth/authenticated',
      user:'auth/user'

    })


  },

  methods: {
      ...mapActions({
           logout: 'auth/signout',
        }),

  }
    }

</script>