<template>
     <div class="col-sm">
        <div style="margin-left:20px;" >
            <div class="card text-left" style="width: 13rem;">
                <img class="w-100 p-3" :src="require('../assets/' +product.image)" style="height: 15vw; " alt/> 
                     <div class="card-body">
                        <h4 class="card-title">
                        <router-link class="cartheader" :to="{name:'product', params:{id:product.id}}"> {{product.title}} </router-link>
                        </h4>
                        <strong> ${{product.price}} </strong>
                        <p class="card-text"> {{product.description}}</p>
                     </div>
            
            <div class = "px-4 pb-3">
            <button class="btn btn-secondary" @click="addToCart"> Add to Chart </button>
            </div>
            </div>
        </div>
        </div>
</template>
<script>
/**
 * @author Enis Sinan Reyhan <enissinanreyhan@gmail.com>
 * 
 * The component shows product details. The component's parent component is ProductList.  
 */
export default {

    props:["product"], 

    /**
     * addToCart method is called when Add To Chart link is clicked. 
     * @param {product} product - The product object
     * @param {int} quantity - quantity for the product 
     */
    methods:{
        addToCart(){
            this.$store.dispatch('addProductToCart',{
                product: this.product,
                quantity:1
            })
        }
    }
    
}
</script>
