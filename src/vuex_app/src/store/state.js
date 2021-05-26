/**
 * The vuex state object
 * @module
 * @name Vuex - State
 * 
 * @type {object}
 * 
 * @property {array} products - keeps the product list.
 * @property {object} product - keeps the specific product, which is relevant. 
 * @property {array} cart - keeps the products and their quantities 
 * @property {object} order - keeps the products and quantities as array
 */

export default {
    products:[],
    product: null,
    cart:[],
    order:[]
}