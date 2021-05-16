<template>
<div class ="row mt-5" v-if="product"> 
    <div class = "col-4">
        <img :src="require('../assets/' + product.image)" class="w-100"/>
    </div>
    <div class="col-8">
        <h1> {{product.title}}</h1>
        <h3> $ {{product.price}} </h3>
        <input type="text" class="text-center col-1 mr-2 p-1" value="quantity" v-model="quantity"/> 
        <button class="btn btn-primary" style="margin-left:6px" @click="addToCart"> Add to Cart </button>
        <p class="mt-4"> {{product.description}} </p>
    </div>
</div>
</template>
<script>
export default {
    
    data() {

        return { 
            quantity:1
        }
    },
    

props:['id'],
mounted() {
    this.$store.dispatch('getProduct',this.id)
},
computed: {
    product() {
        return this.$store.state.product;
    }

}, methods:{
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