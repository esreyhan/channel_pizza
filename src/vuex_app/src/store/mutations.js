/**
 * The module 'setters' object.
 * @module
 * @name Vuex - Setters
 * @type {object}
 * 
 * @mutator {array} SET_PRODUCTS=products Sets the state product list property.
 * @mutator {object} SET_PRODUCT=product Sets the state product property.
 * @mutator {object} ADD_TO_CART=product Sets the state product and also updates product's quantity. Takes into account that the same type object is in the cart. 
 * @mutator {object} SET_ORDER=order Sets the order object in the state 
 * @mutator {none} CART_CLEAR=cart - clears the cart in the state 
 */


export const SET_PRODUCTS = (state, products) => {
    state.products  = products;
} 
export const SET_PRODUCT = (state,product) => {
    state.product = product
}

export const ADD_TO_CART = (state,{product,quantity}) => {
    let productInCart = state.cart.find(item =>{
        return item.product.id === product.id
    })

    if(productInCart) {
        productInCart.quantity += quantity;
        return;
    }
    state.cart.push({product,quantity})
}

export const SET_ORDER = (state,order) => {
    state.order = order
}

export const CART_CLEAR = (state) => {
    state.cart= []
}

