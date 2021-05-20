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
export default {
    components: {
       ProductCard
    }, 
    computed : {
        products () {
            return this.$store.state.products;

        },
        mounted() {
    return this.$store.dispatch('getProducts')
},
        
    },
    
    
  
}
</script>