import axios from "axios"
/**
 * Actions file for vuex store for products and cart 
 *@module
 * @name Vuex - Actions 
 *
 *
 *@type{object}
 *@author Enis Sinan Reyhan <enissinanreyhan@gmail.com>
 */

export const getProducts = async function({commit}) {
await axios.get('http://localhost:8080/api/messages/findAllItems')
.then(response =>{
    commit('SET_PRODUCTS', response.data)
})
}
/**
 * Gets the product id and makes an axios call and commits the product in vuex store. 
 *
 * @method getProduct = SET_PRODUCT
 * @param {String} productId - Product Id
 * @returns {void}
 */
export const getProduct = async function ({commit}, productId ) {
await axios.get('http://localhost:8080/api/messages/findItemById/'+ productId).then(response => {
    commit('SET_PRODUCT',response.data);
})
}
/**
 * The method gets product and quantity and forwards the information for commit 
 * 
 * @method addProductToCart = ADD_TO_CART
 * @param {object} commit - commit object for vuex store
 * @param {object} product - A custom object with quantity
 * @returns {void}
 */
export const addProductToCart = function({commit}, {product, quantity}) {
    commit('ADD_TO_CART',{product,quantity});

}
/**
 * 
 * Method makes an axios call and send the order information through web service 
 * 
 * @method addOrder = SET_ORDER
 * @param {object} commit - commit object for vuex store
 * @param {object} cartinfo - a custom object containing detals of the order
 * @returns {void}
 */
export const addOrder= async function({commit}, cartinfo ) {
    await axios.post('http://localhost:8080/api/messages/addOrder',cartinfo).then(response => {   
    commit('SET_ORDER',response.data);
    }).catch((error) =>{console.log(error)})
    };

/**
 *
 * @method cartClear = CART_CLEAR
 *@param {object} commit - clears the cart with clear commit 
 *@returns {void}
 */
export const cartClear = function({commit}) {
    commit('CART_CLEAR')

}