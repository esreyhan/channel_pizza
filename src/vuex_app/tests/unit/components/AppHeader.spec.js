import {mount, shallowMount} from '@vue/test-utils'
import AppHeader from '@/components/AppHeader.vue'
import {createLocalVue} from '@vue/test-utils'
import Vuex from 'vuex'
import VueRouter from 'vue-router'
import auth from '@/store/auth'

const localVue = createLocalVue()
localVue.use(Vuex)
const store = new Vuex.Store()



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
    test('is a vue instance', () => {
        const wrapper = factory($store)
        
        expect(wrapper.isVueInstance()).toBeTruthy()
    }),
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
    test('calls the logout function when the logout function is clicked ', () =>{
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
