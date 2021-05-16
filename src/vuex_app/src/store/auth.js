import axios from 'axios'


export default {
    namespaced:true,
    state: {
        id: null,
        user:null

    },
    getters: {

        authenticated (state) {
            return state.id
        },

        user (state) {
            return state.user
        }

    },
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
        async signIn ({commit}, credentials) {

            let response = await axios.post('http://localhost:8080/api/messages/user', credentials)
            if (response.data != null){
                commit('SET_USER',response.data.username)
                commit('SET_ID',response.data.id)
            } else {
                commit('SET_ID',null),
                commit('SET_USER',null)

            }
            },  
        async register ({commit}, information) {
            let response = await axios.post('http://localhost:8080/api/messages/addUser', information)
            if (response.data != null){
                commit('SET_USER',response.data.username)
                commit('SET_ID',response.data.id)
            } else {
                commit('SET_ID',null),
                commit('SET_USER',null)

            }
        
        },

        signout ({commit}) {
            commit('LOG_OUT')
        }
        
        }
    }
