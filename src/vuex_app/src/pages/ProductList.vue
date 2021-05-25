<template>
<div> 
<h1> Italian Pizza </h1>
<div class="d-flex align-items-stretch flex-wrap">
<div v-for="product in products" :key="product.id">
<div v-if = "product.type==='italian'">


 <ProductCard class="productcard" id="pr_i" v-bind:product="product"/> 
</div>
</div>
</div>

<h1> Local Pizza </h1>
<div class="d-flex align-items-stretch flex-wrap">
<div v-for="product in products" :key="product.id">
<div v-if = "product.type==='local'">

 <ProductCard class="productcard" id="pr_l" v-bind:product="product"/> 
</div>
</div>
</div>

<h1> Beverages</h1>
<div class="d-flex align-items-stretch flex-wrap">
<div v-for="product in products" :key="product.id">
<div v-if = "product.type==='beverage'">

 <ProductCard class="productcard" id="pr_b" v-bind:product="product"/> 
</div>
</div>
</div>

</div>

 
</template>
<script>
/**
 * This is a page where products are listed. ProductCard custom component is used for listing the products.
 */
import ProductCard from "../components/ProductCard"
export default {
    components: {
       ProductCard
    },
/**
 * Products are get from rest service with an axios call througj getProducts action in mount stage and kept in vuex store. 
 */
    mounted() {
    this.$store.dispatch('getProducts')
},

/**
 * product list is get from vuex store. 
 */
    computed : {
        products () {
            return this.$store.state.products;

        },
        
        
    },
    
    
  
}
</script>