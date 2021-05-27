<template>
 
<div id="container" style="width:90%, padding-left:10 px">

<h1> Products </h1>

<table class="table">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Title</th>
      <th scope="col">Description</th>
      <th scope="col">Price</th>
      <th scope="col"> Image Source</th>
      <th scope="col">Type</th>
      <th scope="col">Delete</th>
    </tr>
  </thead>
  <tbody>
    <tr v-for="product in products" :key="product.id">
      <td >{{product.id}}</td>
      <td>{{product.title}}</td>
      <td>{{product.description}}</td>
      <td>{{product.price}}</td>
      <td>> {{product.image}}</td>
      <td>{{product.type}}</td>
      <td> <button id="submitButton" type="button" class="btn btn-success btn-sm" @click="deleteProduct(product.id)">Delete</button> </td>
    </tr>
  </tbody>
</table>

<router-link class="nav-link" :to="'/admin/addproduct'">Add New Product</router-link> 

</div>

</template>
<script>


import axios from 'axios'
/**
 * 
 * This is an admin page for listing products. Vuex store is used for keeping product and user information. 
 * @author Enis Sinan Reyhan <enissinanreyhan@gmail.com>
 * @vue-computed {array} products - product list is get from vuex store. 
 */
export default {
 
      

     mounted() {
    this.$store.dispatch('getProducts')
},


    computed : {
        products () {
            return this.$store.state.products;

        },
        
        
    },
    methods : {
   /**
    * The method make an axios call for deleting the product. 
    * @param {String}id - id of the product to be deleted is returned
    * @returns {void}
    */
      async deleteProduct (id) {
      console.log("product" + id)
      
    await axios.delete('http://localhost:8080/api/messages/deleteProduct/'+id)
.then(response =>{
    if(response.data){
    this.$store.dispatch('getProducts') }
             
}).catch(error => {
  console.log(error)
})

      }
    }
    
}
</script>
