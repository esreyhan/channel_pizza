import {mount, shallowMount} from '@vue/test-utils'
import AppHeader from '@/components/AppHeader.vue'
import {createLocalVue} from '@vue/test-utils'
import Vuex from 'vuex'
import VueRouter from 'vue-router'
import auth from '@/store/auth'

const localVue = createLocalVue()
localVue.use(Vuex)
const store = new Vuex.Store()


/**
 * Test class for appheader. Vue.js unit test are used. 
 * @author Enis Sinan Reyhan <enissinanreyhan@gmail.com>
 */
describe('Appheader.vue', () => {
    const $store = {
        state:{
            cart:[]
        }, 
        getters : {
            authenticated: () => ({}),
            'auth/authenticated': null,
            user: () => ({}),
            'auth/user': null

        }
}
    const factory = ($store) =>{ 
        return mount(AppHeader, {
            mocks : {
            $store,
            },
            stubs: ['router-link', 'router-view'],
         localVue
        });
    }
    /**
     * Test method: Method checks whether a vue instance is created or not
     */
    test('is a vue instance', () => {
        const wrapper = factory($store)
        
        expect(wrapper.isVueInstance()).toBeTruthy()
    }),

    
    //Test method: Verifies whether the username and logout tab is rendered or not when user is present in vuex store. 
     
    test('renders the username and logout tab', () =>{
        const user = 'user'
        const $store = {
            state:{
                cart:[]
            }, 
            getters : {
                authenticated: () => ({}),
                'auth/authenticated': "ab2",
                user: () => ({}),
                'auth/user': user

            }
    }
    const wrapper = factory($store)
 
    expect(wrapper.html()).toContain(user&'logout')
    }
    );

    
     //test method: checks whether login and register tabs are rendered when the user information is not present in vuex store. 
     
    test('renders the login and register tabs', () =>{
        const user = 'user'
        const $store = {
            state:{
                cart:[]
            }, 
            getters : {
                authenticated: () => ({}),
                'auth/authenticated': null,
                user: () => ({}),
                'auth/user': null

            }
    }
    const wrapper = factory($store)
    expect(wrapper.html()).toContain('login'&'register')
    }
    );
    
    
    test('calls the logout function when the logout button is clicked ', () =>{
        const user = 'user'
        const $store = {
            state:{
                cart:[]
            }, 
            getters : {
                authenticated: () => ({}),
                'auth/authenticated': true,
                user: () => ({}),
                'auth/user': user

            }
    }
    const wrapper = factory($store)
    const logout = jest.fn();
    wrapper.setMethods({
        logout:logout
    });
    wrapper.find('#logOut').trigger('click');

    expect(logout).toHaveBeenCalled()
    }
    );
    /**
     * Test method
     * 
     */
    test('calls the auth module action signout when logout is called', () => {
       

        
        let actions
        let state
        let store
        beforeEach(() => {
            state = {
              cart: [],
              authenticated:'ab2',
              user:'user'
            }
    
            actions = {
                signout: jest.fn()
              }
              store = new Vuex.Store({
                modules: {
                  auth: {
                    state,
                    actions,
                    mutations,
                    getters: auth.getters,
                    namespaced: true
                  }
                }
              });
              const wrapper = mount(AppHeader, {
             
                stubs: ['router-link', 'router-view'],
                store,
                localVue
             
            });
            wrapper.find('#logOut').trigger('click');
    
            expect(mock_action).toHaveBeenCalled();
        }
        );
    
});
})
