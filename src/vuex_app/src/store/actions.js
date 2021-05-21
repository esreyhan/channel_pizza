import axios from "axios"

export const getProducts = ({commit}) => {
axios.get('http://localhost:8080/api/messages/findAllItems')
.then(response =>{
    commit('SET_PRODUCTS', response.data)
})
}

export const getProduct = async function ({commit}, productId ) {
await axios.get('http://localhost:8080/api/messages/findItemById/'+ productId).then(response => {
    commit('SET_PRODUCT',response.data);
})
}

export const addProductToCart = function({commit}, {product, quantity}) {
    commit('ADD_TO_CART',{product,quantity});

}

export const addOrder= async function({commit}, cartinfo ) {
    await axios.post('http://localhost:8080/api/messages/addOrder',cartinfo).then(response => {   
    commit('SET_ORDER',response.data);
    }).catch((error) =>{console.log(error)})
    };

export const cartClear = function({commit}) {
    commit('CART_CLEAR')

}