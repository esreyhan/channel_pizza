import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'

import 'bootstrap'
import Home from "./pages/Home.vue"
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'
import Minicart from "./components/Minicart.vue"
import Product from "./pages/Product.vue"
import ProductList from "./pages/ProductList.vue"
import ConfirmationPage from "./pages/Orderconfirmation.vue"
import Register from './pages/Register.vue'
import store from "./store"
import Login from "./pages/login.vue"
import axios from 'axios'
import VueAxios from 'vue-axios'

import VueSimpleAlert from "vue-simple-alert";
import 'v-slim-dialog/dist/v-slim-dialog.css'
import SlimDialog from 'v-slim-dialog'

Vue.use(SlimDialog)
Vue.use(VueSimpleAlert);

import VueBootstrapTypeahead from 'vue-bootstrap-typeahead'
Vue.component('vue-bootstrap-typeahead', VueBootstrapTypeahead)

Vue.use(VueAxios,axios)
Vue.use(BootstrapVue)
// Optionally install the BootstrapVue icon components plugin
Vue.use(IconsPlugin)

const routes = [{path:'/',
component:Home,
name:'Home'}, 

{path:'/minicart',
component:Minicart,
name:'Minicart'},

{path: '/product/:id',
component: Product,
name: 'product',
props:true

},
{path:'/productlist',
component:ProductList,
name:'ProductList'},

{path:'/login',
component:Login,
name:'Login'},

{path:'confirmation',
component:ConfirmationPage,
name:'Confirmation Page'},
{path:'/register',
component:Register,
name:'Register'

}


]

const router  = new VueRouter({routes:routes, mode:'history'})
Vue.use(VueRouter)
Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app')
