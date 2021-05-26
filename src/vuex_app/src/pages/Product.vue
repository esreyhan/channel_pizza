<template>
<div class ="row mt-5" v-if="product"> 
    <div class = "col-4">
        <img :src="require('../assets/' + product.image)" class="w-100"/>
    </div>
    <div class="col-8">
        <h1> {{product.title}}</h1>
        <h3> $ {{product.price}} </h3>
        <input id="#quantity_input" type="text" class="text-center col-1 mr-2 p-1" value="quantity" v-model="quantity"/> 
        <button class="btn btn-primary" style="margin-left:6px" @click="addToCart"> Add to Cart </button>
        <p class="mt-4"> {{product.description}} </p>
    </div>
</div>
</template>
<script>

/**
 * @author Enis Sinan Reyhan <enissinanreyhan@gmail.com>
 * This is a separate page for the details of the product. 
 */

/**
 * @vue-data {Number}quantity - 1 is returned by vue instance
 * @vue-prop {String} id - product id is passed from parent component ProductList
 * @vue-computed {object} product - product object is returned from vuex store
 */
export default {
    
    data() {

        return { 
            quantity:1
        }
    },
    
/**
 * The property id is transferred from product list page. 
 */
props:['id'],

 //The product with the respective id is set in vuex store.
 
mounted() {
    this.$store.dispatch('getProduct',this.id)
},
computed: {

    product() {
        return this.$store.state.product;
    }

}, methods:{
/**
 * The products are added to cart in vuex store with the called action upon submit button: addProductToCart
 * 
 */
        addToCart(){
            this.$store.dispatch('addProductToCart',{
                product: this.product,
                quantity:parseInt(this.quantity)
            })
        }
    }
}
</script>

<style>

</style>