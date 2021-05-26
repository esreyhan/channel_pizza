/**
 *The vuex 'getters' object.
 * @module
 * @name Vuex - Getters 
 * @type {object}
 * 
 * @getter {Number} cartItemCount=item Returns total number of items.
 * @getter {Number} total=item Returns total price.
 * @getter {array} products=products Returns list of products.
 */


export const cartItemCount = function(state) {
    return state.cart.reduce((acc, item) =>  acc + item.quantity,0)
}

export const total = function(state) {
    return state.cart.reduce((acc, item) => Math.round((acc + item.product.price * item.quantity)*100) / 100, 0)
}
export const products = function(state) {
    return state.cart.products
}