import {mount, shallowMount} from '@vue/test-utils'
import Register from '@/pages/Register'
import {createLocalVue} from '@vue/test-utils'
import Vuex from 'vuex'
import auth from '@/store/auth'
import { _ } from 'core-js'
import axios from 'axios'

const localVue = createLocalVue()
localVue.use(Vuex)
const store = new Vuex.Store()

let url = ''
let body = {}

/**
 * This is a test caase for Register page. Vue.js unit tests are used. 
 * The rest api axios calls are mocked in line with the respective scenarios. 
 * It is checked whether the respective functions are called in accordance with the relevant scenarios. 
 * @author Enis Sinan Reyhan <enissinanreyhan@gmail.com>
 */
jest.mock('axios',() => ({
  
    get: (_url) =>{
       
        switch (_url) {
            //postcode call for autocomplete
            case 'https://api.postcodes.io/postcodes/abc':
                return new Promise((response) => {
                url= _url 
                const mock_data= {data:{result:{country:"ab",region:"cd"}}}
                response(mock_data);
        
                })

            //username call returning existing username
            case 'http://localhost:8080/api/messages/findUserByUsername/def':
                return new Promise((response) => {
                    url= _url 
                    
                    const mock_data= {data:{username:"def","password": "12345"}}
                    response(mock_data);
                })

            //username call with a null response 
            case 'http://localhost:8080/api/messages/findUserByUsername/abc':
                    return new Promise((response) => {
                        url= _url 
                        
                        const mock_data= null
                        response({"data":mock_data});
                    })
            default:
                return Promise.reject(new Error('not found'))
        
    }
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
let wrapper=null;
beforeEach(() => {
wrapper = mount(Register, {
    data() {
        return {

            adress_line:'',
            code: 'abc',
            region:'',
            country:'',
            countryData: [],
            regionData:[],
            postcodes:[],
            region:'',
            firstname:'',
            lastname:'',
            form:{
              username:null,
              password:null,
              address:null,
              fullname:null
        }
      }
    },

    mocks : {
    $store,
    },
    stubs: ['router-link', 'router-view','vue-bootstrap-typeahead']
 
});
})
    test('is a vue instance', () => {
 
        expect(wrapper.isVueInstance()).toBeTruthy()
    });

    test('postcode search method is called', async () => {
        const mockmethod = jest.fn() 
      wrapper.setMethods({postCodeSearch:mockmethod})
       wrapper.find('#code').trigger('blur');
       expect(mockmethod).toHaveBeenCalled();
       
    })
    
    test('postcode search method changes the respective variables', async () => {
    
        await wrapper.find('#code').trigger('blur');
        expect(wrapper.vm.postcodes).toHaveLength(1);
        expect(wrapper.vm.regionData).toHaveLength(1);
        expect(wrapper.vm.regionData[0]).toBe("cd");
        expect(wrapper.vm.countryData).toHaveLength(1);
        expect(wrapper.vm.countryData[0]).toBe("ab");
        
        
     });
     
     test('alert is triggered when form data is empty', async () => {
       
        //case input fields are not fulfilled 
        const mock_function = jest.fn()
        wrapper.setMethods({showAlert:mock_function});
        const mock_function2 = jest.fn();
        wrapper.setMethods({showAlert2:mock_function2});
        const mock_function3 = jest.fn();
        wrapper.setMethods({showSuccessAlert:mock_function3});
        await wrapper.find('.btnSubmit').trigger('click');
        //missing fields alert function is called
        expect(mock_function).toHaveBeenCalled();
        //if(!!this.adress_line &&!!this.firstname && !!this.form.username && !!this.form.password&&!!this.lastname&&!!this.code &&!!this.country &&!!this.region)
        
});

test('alert is triggered when form data is full but the username exists', async () => {
   
    wrapper.setData({code: 'a'});
    wrapper.setData({ country:'c'});
    wrapper.setData({adress_line:'a b c d'});
    wrapper.setData({firstname: 'a'});
    wrapper.setData({lastname:'b'});
    wrapper.setData({ form:{
        //when username 'def is called in mock axios, a user object is returned
        username:'def',
        password:'y',
        address:null,
        fullname:'a b'
        
      }});
    wrapper.setData({ country:'c'});
    wrapper.setData({region:'r'})
    //case input fields are fulfilled 
    const mock_function = jest.fn()
    wrapper.setMethods({showAlert:mock_function});
    const mock_function2 = jest.fn();
    wrapper.setMethods({showAlert2:mock_function2});
    await wrapper.find('.btnSubmit').trigger('click');
    //as all fields are full the alert for missing data is not called
    expect(mock_function).not.toHaveBeenCalled();
    //as mock axios function returns a value alert 2 is  called
    expect(mock_function2).toHaveBeenCalled();
    //if(!!this.adress_line &&!!this.firstname && !!this.form.username && !!this.form.password&&!!this.lastname&&!!this.code &&!!this.country &&!!this.region)
    
})
test('fullname and adress is fulfilled and submit call is made', async () => {
    wrapper.setData({code: 'a'});
    wrapper.setData({ country:'c'});
    wrapper.setData({adress_line:'a b c d'});
    wrapper.setData({firstname: 'a'});
    wrapper.setData({lastname:'b'});
    wrapper.setData({ form:{
        //when 'abc' is passed on axios for username call,  object is not returned 
        username:'abc',
        password:'y',
        address:null,
        fullname:null
        
      }});
    wrapper.setData({ country:'c'});
    wrapper.setData({region:'r'})
    
    
    const mock_function3 = jest.fn();
    const mock_function = jest.fn()
    wrapper.setMethods({showAlert:mock_function});
    const mock_function2 = jest.fn();
    wrapper.setMethods({showAlert2:mock_function2});
    wrapper.setMethods({register: mock_function3})
    await wrapper.find('.btnSubmit').trigger('click')

    expect(wrapper.vm.form.address).toBeTruthy()
    expect(wrapper.vm.form.address).toBe(wrapper.vm.code + " " + wrapper.vm.country + " " + wrapper.vm.region + " " + wrapper.vm.adress_line)
     //Fullname is fulfilled within the submit method
    expect(wrapper.vm.form.fullname).toBe(wrapper.vm.firstname + " " + wrapper.vm.lastname)
    //register action is called from vuex store
    expect(mock_function3).toHaveBeenCalled()
    
})
})
