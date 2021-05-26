import axios from 'axios'
/**
 * Single vuexs file for User information module
 *@module
 * @name Vuex - User
 *
 *
 *@type{object}
 *@author Enis Sinan Reyhan <enissinanreyhan@gmail.com>
 */

export default {
    namespaced:true,

    /**
     * @property {String} id - keeps the userid
     * @property {String} user - keeps the username
     */
    state: {
        id: null,
        user:null

    },
    /**
     * @getter {String} authenticated=id Returns id
     * @getter {String} user=user Return user
     */
    getters: {

        authenticated (state) {
            return state.id
        },

        user (state) {
            return state.user
        }

    },
    /**
     * @mutator {String} SET_ID=id Sets the user id
     * @mutator {String} SET_USER=username Sets the user 
     * @mutator {none} LOG_OUT=id,user clears the user and id information
     */
    
    mutations: {
        SET_ID(state,id) {
            state.id= id
        },
        SET_USER(state,username){
            state.user = username
        },
        LOG_OUT (state) {
            state.id = null,
            state.user = null
        }
        
    },
    actions: {
        /**
         * Checks the user information, if successful, commits the data 
        * @method signIn
        * @param {object} credentials - user information 
        * @returns {void}
         */
        async signIn ({commit}, credentials) {

            let response = await axios.post('http://localhost:8080/api/messages/user', credentials)
            
            if (response.data != null){
                commit('SET_USER',response.data.username)
                commit('SET_ID',response.data.id)
            } 
            },  

        /**
         * Checks the user information, if successful, commits the data 
        * @method register
        * @param {object} information - user information 
        * @returns {void}
         */
        async register ({commit}, information) {
            let response = await axios.post('http://localhost:8080/api/messages/addUser', information)
            if (response.data != null){
                commit('SET_USER',response.data.username)
                commit('SET_ID',response.data.id)
            } 
        
        },
         /**
         * Checks the user information, if successful, commits the data 
        * @method logOut
        * @returns {void}
         */
        signout ({commit}) {
            commit('LOG_OUT')
        }
        
        }
    }
