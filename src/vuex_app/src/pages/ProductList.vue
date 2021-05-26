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

import ProductCard from "../components/ProductCard"

/**
 * 
 * This is a page where products are listed. ProductCard custom component is used for listing the products.
 * @author Enis Sinan Reyhan <enissinanreyhan@gmail.com>
 * @vue-computed {array} products - product list is get from vuex store. 
 */
export default {
    /**
     * 
     * ProductCard component is used as to list products
     * @vue-computed {Object} products - return list of products object
     *
     */
    components: {
       ProductCard
    },

//The product list is acquired from web service through vuex store
 
    mounted() {
    this.$store.dispatch('getProducts')
},


    computed : {
        products () {
            return this.$store.state.products;

        },
        
        
    },
    
    
  
}
</script>