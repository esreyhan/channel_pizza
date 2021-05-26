<template>
 <div class="card">
    <div class="row">
        <div class="col-md cart">
            <div class="title">
                <div class="row">
                    <div class="col-4">
                        <h4><b>Shopping Cart</b></h4>
                    </div>
                    <div class="col-6 align-self-center text-right text-muted">  </div>
                    <div  @mouseover="hover = true" @click="clear()" id="hover" class="col-2 align-self-center text-right text-muted"> Clear Basket </div>
                    
                </div>
            </div>

            <div v-for="item in cart" :key="item.product.id" class="row border-top border-bottom">
                <div class="row main align-items-center">
                    <div class="col-2"><img class="img-fluid" :src="require('../assets/' +item.product.image)"></div>
                    <div class="col-6">
                        <div class="row text-muted">{{item.product.title}}</div>
                        <div class="row">{{item.product.description}}</div>
                    </div>
                    <div class="col" style="margin-left:40px"> {{item.quantity}} </div>
                    <div class="col"> $ {{item.product.price}} <span class="close">&#10005;</span></div>
                </div>
            </div>
        </div>
        </div> 

        <div class="col-md-4 summary">
            <div>
                <h5><b>Summary</b></h5>
            </div>
            <hr>
            <div class="row">
                <div class="col" style="padding-left:0;">Total Items </div>
                <div class="col text-right">{{cartItemCount}}</div>
            </div>
            <div class="row" style="border-top: 1px solid rgba(0,0,0,.1); padding: 2vh 0;">
                <div class="col">TOTAL PRICE</div>
                <div class="col text-right"> $ {{total}}</div>
            </div> <router-link :to="{name:'ProductList'}"> <button class="btn">CONTINUE SHOPPING</button> </router-link> <button id="btcheckout" class="btn"  @click="checkOut()">CHECKOUT</button> 
        </div>
    </div>
</template>
<script>

import {mapState} from 'vuex'
import {mapActions} from 'vuex'
/**
 * The component shows items added to the cart. 
 * @author Enis Sinan Reyhan <enissinanreyhan@gmail.com>
 */
/** 
 * @vue-data {boolean} hover - boolean object for hover
 * @vue-data {order} order - empty objet is set for data binding in the form
 * @vue-computed {array} cart - added product list is returned from vuex state
 * @vue-computed {Number} cartItemCount - total number of items is returned from vuex getter
 * @vue-computed {Number} total - total price is returned from vuex getter
 * @vue-data {String} userId - Userid is mapped with vuex store
 * @vue-data {String} cart - Cart vuex object is mapped 
 */
export default {
     name: 'Product Card',
     
      data () {
          return {
              hover: false,
        order:{
          oderitems:[],
          quantity:[],
          total:null,
          userid:''
          
        }
      }
      },

    computed: { cart() {
          return this.$store.state.cart;
      }, 
 
      cartItemCount() {
      return this.$store.getters.cartItemCount;
    },
  
    total () {
        return this.$store.getters.total
    },
   
    ...mapState({
        userid: state => state.auth.id,
        cart: state => state.cart
      
      })
    },
 
    methods :{ 
        ...mapActions({
           regOrder: 'addOrder',
           clear: 'cartClear'
        }),

        /**
     * redirect method is called upon click of continue shopping button
     */
        redirect() {
             
          this.$router.replace({
                name: 'Confirmation Page'
              }) 
            
        },

    /**
     * The signin is a requirement for adding the order. 
     * This alert is called when the user information is not present in vuex store, upon click of checkout link and checkOut method. 
     */   
        
         showAlert() {
    const options = {title: 'Sign In Required', size: 'sm'}
    this.$dialogs.alert('Please sign in or register to proceed to the checkout', options)
    .then(res => {
      console.log(res) // {ok: true|false|undefined}
    })
  },

  /**
   * checkOut method is called upon click of checkout link. 
   * Orderitems and quantity arrays are organized respectively with items and their quantities and order object is prepared for axios call. 
   * redirect method is called upon successful axios call made in vuex action: addOrder through method regOrder. 
   */
       async checkOut(){
            let orderitems = []
            let quantity = []
            var i;
            for(i=0;i<this.cart.length;i++) {
                orderitems.push(this.cart[i].product.id)
                quantity.push(this.cart[i].quantity)
            }
            
       
           
            
           this.order.orderitems= orderitems;
           this.order.quantity = quantity;
            this.order.total= this.total;
            this.order.userid = this.userid
            
            if(this.userid){
            await this.regOrder(this.order).then(() => {
                    this.redirect()}).catch(error => {
     console.log(error.response.data.error)
            }) } else {
                    this.showAlert()
             }
  
        

        },


    }
      
}

</script>
<style scoped>

body {
    background: #ddd;
    min-height: 100vh;
    vertical-align: middle;
    display: flex;
    font-family: sans-serif;
    font-size: 0.8rem;
    font-weight: bold
}

.title {
    margin-bottom: 5vh
}
#hover:hover {
text-decoration: underline;
}

.card {
    margin: auto;
    max-width: 950px;
    width: 90%;
    box-shadow: 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    border-radius: 1rem;
    border: transparent
}

@media(max-width:767px) {
    .card {
        margin: 3vh auto
    }
}

.cart {
    background-color: #fff;
    padding: 4vh 5vh;
    border-bottom-left-radius: 1rem;
    border-top-left-radius: 1rem
}

@media(max-width:767px) {
    .cart {
        padding: 4vh;
        border-bottom-left-radius: unset;
        border-top-right-radius: 1rem
    }
}

.summary {
    background-color: #ddd;
    border-top-right-radius: 1rem;
    border-bottom-right-radius: 1rem;
    padding: 4vh;
    color: rgb(65, 65, 65)
}

@media(max-width:767px) {
    .summary {
        border-top-right-radius: unset;
        border-bottom-left-radius: 1rem
    }
}

.summary .col-2 {
    padding: 0
}

.summary .col-10 {
    padding: 0
}

.row {
    margin: 0
}

.title b {
    font-size: 1.5rem
}

.main {
    margin: 0;
    padding: 2vh 0;
    width: 100%
}

.col-2,
.col {
    padding: 0 1vh
}

a {
    padding: 0 1vh
}

.close {
    margin-left: auto;
    font-size: 0.7rem
}

img {
    width: 3.5rem
}

.back-to-shop {
    margin-top: 4.5rem
}

h5 {
    margin-top: 4vh
}

hr {
    margin-top: 1.25rem
}

form {
    padding: 2vh 0
}

select {
    border: 1px solid rgba(0, 0, 0, 0.137);
    padding: 1.5vh 1vh;
    margin-bottom: 4vh;
    outline: none;
    width: 100%;
    background-color: rgb(247, 247, 247)
}

input {
    border: 1px solid rgba(0, 0, 0, 0.137);
    padding: 1vh;
    margin-bottom: 4vh;
    outline: none;
    width: 100%;
    background-color: rgb(247, 247, 247)
}

input:focus::-webkit-input-placeholder {
    color: transparent
}

.btn {
    background-color: #000;
    border-color: #000;
    color: white;
    width: 100%;
    font-size: 0.7rem;
    margin-top: 4vh;
    padding: 1vh;
    border-radius: 0
}

.btn:focus {
    box-shadow: none;
    outline: none;
    box-shadow: none;
    color: white;
    -webkit-box-shadow: none;
    -webkit-user-select: none;
    transition: none
}

.btn:hover {
    color: white
}

a {
    color: black
}

a:hover {
    color: black;
    text-decoration: none
}

#code {
    background-image: linear-gradient(to left, rgba(255, 255, 255, 0.253), rgba(255, 255, 255, 0.185)), url("https://img.icons8.com/small/16/000000/long-arrow-right.png");
    background-repeat: no-repeat;
    background-position-x: 95%;
    background-position-y: center
}
</style>