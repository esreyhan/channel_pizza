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
                                <input type="text" class="form-control" placeholder="Your UserName *" value="" v-model="form.username"/>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Your Password *" value="" v-model = "form.password"/>
                            </div>
                           
                        </div>
                        <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="First Name *" value="" v-model="firstname"/>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Last Name *" value="" v-model = "lastname"/>
                            </div>   
                        </div>
                    </div>
                    <div class="row"> </div>
                    <div class="note"> Adress Information </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <input autocomplete = "off" v-model="code" type="text" class="form-control" placeholder="Post Code *" @blur="postCodeSearch"/>
                            </div>
                            <div class="form-group" style="margin:10% 25">
                                <vue-bootstrap-typeahead placeholder="Country" v-model="country" :data='countryData'/>

                            </div>
                        </div>
                        <div class="col-md-6">
                            <div  style="margin:10% 25">
                                <vue-bootstrap-typeahead :data='regionData' v-model="region" placeholder="Region"/>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Adress Line 1" value="" v-model="adress_line"/>
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
import VueBootstrapTypeahead from 'vue-bootstrap-typeahead'
export default {components: {
        VueBootstrapTypeahead
        
    },

    

    data() {

        return {

        code: '',
        postcodes: [],
        postcode:'',
        region:'',
        country:'',
        countries:[],
        filteredCountry:'',
        dataCountry:'',
        sample: [],
        countryData:[],
        regionData:[],
        dataFields_country:{value:'country'},
        dataFields_region:{value:'region'},
        adress_line:'',
        firstname:'',
        lastname:'',

        form:{
          username:null,
          password:null,
          address:null,
          fullname:null
          
        },
        simpleDialog : false

        }
       

    },
    computed: {
        ...mapState({
        authorized: state => state.auth.user
      
      })
      },
    methods: {
    
    postCodeSearch: function() {
    
      axios
      .get("https://api.postcodes.io/postcodes/" + this.code)
      .then(response => {
        
        this.postcodes[0] = response.data.result;
        this.sample = this.postcodes;
        
        this.countryData.push(this.postcodes[0].country);
        this.regionData.push(this.postcodes[0].region)
        //this.countryData.push(this.postcodes[0].admin_county)
        //this.countryData.push(this.postcodes[0].admin_district)
        //this.countryData.push(this.postcodes[0].admin_ward)
      }).catch(error=>{
       console.log(error)
 })
      },

      ...mapActions({
         register: 'auth/register'
      
    }),
       
  showAlert() {
    const options = {title: 'Missing Fields', size: 'sm'}
    this.$dialogs.alert('Please fulfill all fields', options)
    

  },

   showAlert2() {
    const options = {title: 'Missing Fields', size: 'sm'}
    this.$dialogs.alert('Username Exists', options)
    

  },

  showSuccessAlert() {
       const options = {title: 'Success', size: 'sm'}
    this.$dialogs.alert('You have successfully signed up', options).then(() =>{
                    this.$router.replace({
                name: 'ProductList'
              })
                })
  },
  async userCheck () {
       if(!!this.adress_line &&!!this.firstname && !!this.form.username && !!this.form.password&&!!this.lastname&&!!this.code &&!!this.country &&!!this.region) {
        await axios.get("http://localhost:8080/api/messages/findUserByUsername/" + this.form.username).then((response)=>{
        if(response.data) {
            this.showAlert2();
            console.log(response)
            
        } else {
            this.submit()
        }
       }) }else {
        this.showAlert()
       }
       
    },


       async submit(){ 
          
            this.form.address = this.code + " " + this.country + " " + this.region + " " + this.adress_line
            this.form.fullname = this.firstname + " " + this.lastname
            
         await this.register(this.form).then(() => {
             this.showSuccessAlert()
                
            }).catch(error => {
                console.log("catch" + error.message)
            }) } 
            
              
            
          },
         
    
}

</script>

<style>
/*
.v-dialog--custom {
  width: 10%;
}
/* Desktop */
/*
@media screen and (min-width: 768px) {
  .v-dialog--custom {
    width: 50%;
  }
}*/
</style>