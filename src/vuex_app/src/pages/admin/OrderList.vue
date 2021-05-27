<template>
    <div id="container" style="width:90%, padding-left:10 px">

<h1> Products </h1>

<table class="table">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Items id </th>
      <th scope = "col"> quantity </th>
      <th scope="col">Total</th>
      <th scope="col">Userid</th>
      <th scope="col"> Date</th>
    </tr>
  </thead>
  <tbody>
    <tr id="orderrow" v-for="order in orders" :key="order.id">
      <td >{{order.id}}</td>
      <td><ul v-for="id in order.orderitems" :key="id">{{id}} </ul></td>
      <td>  <ul v-for="quantity in order.quantity" :key="quantity" > {{quantity}}</ul> </td>
      <td>{{order.total}}</td>
      <td>{{order.userid}}</td>
      <td>> {{order.date}}</td>
    </tr>
  </tbody>
</table>
</div>
</template>

<script>
/*
getProducts (){   
            axios.get('http://localhost:8080/api/messages/findAllOrders')
.then(response =>{
    this.orders =  response.data
}).catch(error => {
  console.log(error)
})
}
},*/
import axios from 'axios'
export default {
    data(){
        return {
        orders: []
        }
    },
methods: {
    async getProducts (){   
           await axios.get('http://localhost:8080/api/messages/findAllOrders')
.then(response =>{
    this.orders =  response.data
}).catch(error => {
  console.log(error)
})
}
},

        mounted() {
             
        this.getProducts()

        }



}

</script>