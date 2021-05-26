import axios from "axios"
/**
 * @model 
 *Actions file for vuex store for products and cart 
 *@name Getters
 *@author Enis Sinan Reyhan <enissinanreyhan@gmail.com>
 */
/**
 * The method  gets all products from web service through axios call  and commits product list
 * @param {object} commit - commit object for vuex store
 */
export const getProducts = async function({commit}) {
await axios.get('http://localhost:8080/api/messages/findAllItems')
.then(response =>{
    commit('SET_PRODUCTS', response.data)
})
}
/**
 * Gets the product id and makes an axios call and commits the product in vuex store. 
 * @param {object} commit - commit object for vuex store
 * @param {String} productId - Product Id
 */
export const getProduct = async function ({commit}, productId ) {
await axios.get('http://localhost:8080/api/messages/findItemById/'+ productId).then(response => {
    commit('SET_PRODUCT',response.data);
})
}
/**
 * The method gets product and quantity and forwards the information for commit 
 * 
 * @param {object} commit - commit object for vuex store
 * @param {object} product - A custom object with quantity
 */
export const addProductToCart = function({commit}, {product, quantity}) {
    commit('ADD_TO_CART',{product,quantity});

}
/**
 * 
 * Method makes an axios call and send the order information through web service 
 * @param {object} commit - commit object for vuex store
 * @param {object} cartinfo - a custom object containing detals of the order
 */
export const addOrder= async function({commit}, cartinfo ) {
    await axios.post('http://localhost:8080/api/messages/addOrder',cartinfo).then(response => {   
    commit('SET_ORDER',response.data);
    }).catch((error) =>{console.log(error)})
    };

/**
 * 
 *@param {object} commit - clears the cart with clear commit 
 */
export const cartClear = function({commit}) {
    commit('CART_CLEAR')

}