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
                                <input id="code" autocomplete = "off" v-model="code" type="text" class="form-control" placeholder="Post Code *" @blur="postCodeSearch"/>
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
export default  {/*components: {
        VueBootstrapTypeahead
        
    },*/

    

    data() {

        return {

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
        console.log(this.code)
   const url = "https://api.postcodes.io/postcodes/" + this.code
   console.log(url)
      axios
      .get(url)
      .then(response => {
        
        this.postcodes[0] = response.data.result;
        console.log(response.data);
        console.log(this.postcodes)
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
    const options = {title: 'Username', size: 'sm'}
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
      console.log("address" + this.code)
       if(!!this.adress_line &&!!this.firstname && !!this.form.username && !!this.form.password&&!!this.lastname&&!!this.code &&!!this.country &&!!this.region) {
        console.log("inside the if clause")
        await axios.get("http://localhost:8080/api/messages/findUserByUsername/" + this.form.username).then((response)=>{
       console.log("Response data" + response)
       if(response.data) {
            this.showAlert2()
            console.log('alert 2 inside')
            
        } else {
            this.submit();
        }
       }).catch(error => {
           console.log(error)
       }) }else {
        this.showAlert()
       }
       
    },


       async submit(){ 
          
            this.form.address = this.code + " " + this.country + " " + this.region + " " + this.adress_line
            this.form.fullname = this.firstname + " " + this.lastname
         await this.register(this.form).then(() => {
             
             this.showSuccessAlert();
             console.log("register function called ---------------------------------")
                
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