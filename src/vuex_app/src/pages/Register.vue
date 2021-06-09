<template>
    
<div class="container register-form">
            <div class="form">
                <div class="note">
                    
                    <p>Registration Form</p>
                </div>
                <form @submit.prevent="submit">
                <div class="form-content">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <input id="username" type="text" class="form-control" placeholder="Your UserName *" value="" v-model="form.username"/>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <input id="password" type="text" class="form-control" placeholder="Your Password *" value="" v-model = "form.password"/>
                            </div>
                           
                        </div>
                        <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <input id="firstname" type="text" class="form-control" placeholder="First Name *" value="" v-model="firstname"/>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <input id="lastname" type="text" class="form-control" placeholder="Last Name *" value="" v-model = "lastname"/>
                            </div>   
                        </div>
                    </div>
                    <div class="row"> </div>
                    <div class="note"> Adress Information </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <vue-bootstrap-typeahead class = "postcode" id="postcode" placeholder="Post Code" v-model="code" :data='codeData' @hit="postCodeSearch" @input="postCodeCorrection"/>
                               
                            </div>
                            <div class="form-group" style="margin:10% 25">
                                <vue-bootstrap-typeahead id="country" placeholder="Country" v-model="country" :data='countryData'/>

                            </div>
                        </div>
                        <div class="col-md-6">
                            <div  style="margin:10% 25">
                                <vue-bootstrap-typeahead id="region" :data='regionData' v-model="region" placeholder="Region"/>
                            </div>
                            <div class="form-group">
                                <input type="text" id= "address_line" class="form-control" placeholder="Adress Line 1" value="" v-model="adress_line"/>
                            </div>
                        </div>
                    </div>
                    <div class="row"> 
                        
                    </div>

                    <button type="button" class="btnSubmit" @click="userCheck()">Submit</button>
                </div>
                </form>
            </div>
        </div>


</template>

<script>


import axios from 'axios'
import {mapActions} from 'vuex'
import {mapState} from 'vuex'

/** 
 * @author Enis Sinan Reyhan <enissinanreyhan@gmail.com>
 * This is a page for registration.
 */

/**
 * @vue-data {String} code - postcode input
 * @vue-data {String} region - region input
 * @vue-data {String} country - country input
 * @vue-data {array} countryData - information get from postCodeSearch method through web service regarding country for autocomplete
 * @vue-data {array} regionData - information get from postCodeSearch method through web service regarding region for autocomplete
 * @vue-data {String} address_line - adress line input
 * @vue-data {String} firstname - firstname input
 * @vue-data {String} lastname - lastname input
 * @vue-data {String} form - the form data which combines all data provided by the user 
 * 
 */
export default  {

    

    data() {

        return {
        
        codeData:[],
        code: '',
        region:'',
        country:'',
        postcodes:[],
        countryData:[],
        regionData:[],
        adress_line:'',
        firstname:'',
        lastname:'',

        form:{
          username:null,
          password:null,
          address:null,
          fullname:null
          
        }

        }
       

    },
   
    computed: {
    
    
        ...mapState({
        authorized: state => state.auth.user
      
      })
      },
    methods: {
    /**
     * class parameters countryData and regionData are set by the method, if the rest service call is successful.
     * 
     */
    postCodeSearch: function() {
        console.log("postCodeSearch" + this.code)
       
   const url = "https://api.postcodes.io/postcodes/" + this.code
  
      axios
      .get(url)
      .then(response => {
        
        this.postcodes[0] = response.data.result;
        
       this.countryData.push(this.postcodes[0].country);
        this.regionData.push(this.postcodes[0].region)
      
      }).catch(error=>{
       console.log(error)
 });
  /**
     * Method for postcode autocomplete
     * 
     */
      },
      postCodeCorrection: function() {
          console.log("postCodeCorrection" + this.code)
          if (this.code) {
          const url = "https://api.postcodes.io/postcodes/" + this.code + "/autocomplete"
          axios
      .get(url)
      .then(response => {
        
        this.codeData = response.data.result;
      
      }).catch(error=>{
       console.log(error)
 });

          }
      },

      ...mapActions({
         register: 'auth/register'
      
    }),
    /**
     *  The alert for the missing fields. 
     * 
     */ 
  showAlert() {
    const options = {title: 'Missing Fields', size: 'sm'}
    this.$dialogs.alert('Please fulfill all fields', options)
    

  },
/**
 * The alert for the existing username
 */
   showAlert2() {
    const options = {title: 'Username', size: 'sm'}
    this.$dialogs.alert('Username Exists', options)
    

  },
/**
 * The alert for succcessful login. User is redirected to menu page. 
 * 
 */
  showSuccessAlert() {
       const options = {title: 'Success', size: 'sm'}
    this.$dialogs.alert('You have successfully signed up', options).then(() =>{
                    this.$router.replace({
                name: 'ProductList'
              })
                })
  },
  /**
   * The user information in the form is checked first. if the username exists, an alert is shown, otherwise, submit method is called. 
   * 
   */
  async userCheck () {
      
       if(!!this.adress_line &&!!this.firstname && !!this.form.username && !!this.form.password&&!!this.lastname&&!!this.code &&!!this.country &&!!this.region) {
        
        await axios.get("http://localhost:8080/api/messages/findUserByUsername/" + this.form.username).then((response)=>{
      //Alert for existing username. 
       if(response.data) {
            this.showAlert2()
         
            
        } else {
            this.submit();
        }
       }).catch(error => {
           console.log(error)
        //Alert for missing fields. 
       }) }else {
        this.showAlert()
       }
       
    },

/**
 * The register action of the auth module of vuex store is called finally, upon all checks. 
 * If the registration is successful, the alert is shown. 
 * 
 */
       async submit(){ 
            this.form.address = this.code + " " + this.country + " " + this.region + " " + this.adress_line
            this.form.fullname = this.firstname + " " + this.lastname
         await this.register(this.form).then(() => {
             
             this.showSuccessAlert();
                
            }).catch(error => {
                console.log("catch" + error.message)
            }) } 
            
              
            
          },
         
    
}

</script>
