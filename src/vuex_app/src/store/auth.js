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
        user:null,
        admin:null

    },
    /**
     * @getter {String} authenticated=id Returns id
     * @getter {String} user=user Return user
     * @getter {String} admin=admin Return admnin
     */
    getters: {

        authenticated (state) {
            return state.id
        },

        user (state) {
            return state.user
        },
        admin (state) {
            return state.admin
        }

    },
    /**
     * @mutator {String} SET_ID=id Sets the user id
     * @mutator {String} SET_USER=username Sets the user 
     * @mutator {none} LOG_OUT=id,user clears the user and id information
     * @mutator {String} SET_ADMIN =admin sets the admin property
     */
    
    mutations: {
        SET_ID(state,id) {
            state.id= id
        },
        SET_USER(state,username){
            state.user = username
        },
        SET_ADMIN(state,adminuser){
            state.admin = adminuser
        },
        LOG_OUT (state) {
            state.id = null,
            state.user = null
            state.admin = null
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
                commit('SET_ADMIN',response.data.admin)
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
