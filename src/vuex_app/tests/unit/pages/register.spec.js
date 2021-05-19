import {mount, shallowMount} from '@vue/test-utils'
import Register from '@/pages/Register'
import {createLocalVue} from '@vue/test-utils'
import Vuex from 'vuex'
import auth from '@/store/auth'
import { _ } from 'core-js'


const localVue = createLocalVue()
localVue.use(Vuex)
const store = new Vuex.Store()

let url = ''
let body = {}
jest.mock('axios',() => ({
    get: (_url, postcode) =>{
        return new Promise((response) => {
        url= _url + postcode
        const mock_data= {data:{result:{country:"ab",region:"cd"}}}
        response(mock_data);
        
    })
}
}))

describe('Register.vue', () => {
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
    test('is a vue instance', () => {
    
        const wrapper = mount(Register, {
            mocks : {
            $store,
            },
            stubs: ['router-link', 'router-view']
         
        });
        expect(wrapper.isVueInstance()).toBeTruthy()
    });

    test('is a vue instance', async () => {
       const mockmethod = jest.fn() 
        const wrapper = mount(Register, {
            data() {
                return {
                  code: 'abc',
                  countryData: [],
                  regionData:[],
                  postcodes:[]
                }
              },
              methods:{
                postCodeSearch: mockmethod
              },
            mocks : {
            $store,
            },
            stubs: ['router-link', 'router-view']
         
        });
       wrapper.find('#postcode_input').trigger('blur');
       //await wrapper.vm.$nextTick();
       expect(mockmethod).toHaveBeenCalled()
    })

})