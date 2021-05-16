import Vuex from 'vuex'
import Vue from 'vue'

Vue.use(Vuex);

import state from "./state";
import * as getters from "./getters"
import * as mutations from "./mutations"
import * as actions from "./actions"
import auth from "./auth"
export default new Vuex.Store({
   
    state,
    getters,
    mutations,
    actions,

    modules : {
        auth, 
    }
    


})