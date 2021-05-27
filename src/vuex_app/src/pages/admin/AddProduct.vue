<template>
<table class="table">
  <thead>
    <tr>
      
      <th scope="col" >Title</th>
      <th scope="col">Description</th>
      <th scope="col">Price</th>
      <th scope="col"> Image Source </th>
      <th scope="col">Type</th>
     
    </tr>
  </thead>
  <tbody>
    <tr>
    <td>
      <input id="title" v-model = "form.title"/>
    </td>
    <td>
      <input id="description" v-model = "form.description"/>
    </td>
    <td>
      <input id="price" v-model = "form.price"/> 

    </td>
    <td>
      <input id="image" v-model = "form.image"/>
    </td>
    <td>
      <input id="type" v-model = "form.type" /> 
    </td>

      <td> <button id="submitbutton" type="button" class="btn btn-success btn-sm" @click="submitProduct()">Submit</button> </td>
    </tr>
  </tbody>
</table>
</template>

<script>


import axios from 'axios'
/**
 * 
 * This is a login page for user signin. Vuex store is used for keeping product and user information. 
 * @author Enis Sinan Reyhan <enissinanreyhan@gmail.com>
 * @data {object}form - details regarding the product is included in the form object
 */
  export default {

    data() {
      return {
        form :{title:'',
        description:'',
        price:null,
        image:'',
        type:''
        }


      }

    },

    methods: {

      /**
       * the product is sent to the backend via webserver 
       */
      async submitProduct() {

        await axios.post('http://localhost:8080/api/messages/addProduct',this.form).then (   
          this.$store.dispatch('getProducts'),
         this.$router.replace({
                name: 'ProductsAdmin'
              })
            

    
    ).catch((error) =>{console.log(error)})
    }

      
    }


  }
</script>
