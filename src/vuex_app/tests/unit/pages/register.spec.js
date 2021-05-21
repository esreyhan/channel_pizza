import {mount, shallowMount} from '@vue/test-utils'
import Register from '@/pages/Register'
import {createLocalVue} from '@vue/test-utils'
import Vuex from 'vuex'
import auth from '@/store/auth'
import { _ } from 'core-js'
import axios from 'axios'
//import 'v-slim-dialog/dist/v-slim-dialog.css'
//import SlimDialog from 'v-slim-dialog'

const localVue = createLocalVue()
localVue.use(Vuex)
const store = new Vuex.Store()

let url = ''
let body = {}
jest.mock('axios',() => ({
   /* post: async (_url, _body) =>{
        try {
            return new Promise((response) => {
                console.log("inside post" + _url)
                url = _url
                body = _body
                const mock_data = {
                data: {
                "id": "ab23",
                    "username": "def", "password": "123"
                }
                }
                response(mock_data)
            })
        }
        catch (error) {
            console.log(error)
        }
},*/
    get: (_url) =>{
       
        switch (_url) {
            
            case 'https://api.postcodes.io/postcodes/abc':
                return new Promise((response) => {
                url= _url 
                const mock_data= {data:{result:{country:"ab",region:"cd"}}}
                response(mock_data);
        
                })
            case 'http://localhost:8080/api/messages/findUserByUsername/def':
                return new Promise((response) => {
                    url= _url 
                    
                    const mock_data= {data:{username:"def","password": "12345"}}
                    response(mock_data);
                })
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
    test('is a vue instance', () => {
    
        const wrapper = mount(Register, {
            mocks : {
            $store,
            },
            stubs: ['router-link', 'router-view']
         
        });
        expect(wrapper.isVueInstance()).toBeTruthy()
    });

    test('postcode search method is called', async () => {
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
       wrapper.find('#code').trigger('blur');
       //await wrapper.vm.$nextTick();
       expect(mockmethod).toHaveBeenCalled();
       
    })
    const wrapper = mount(Register, {
        data() {
            return {
              code: 'abc',
              countryData: [],
              regionData:[],
              postcodes:[]
            }
          },
        
        mocks : {
        $store,
        },
        stubs: ['router-link', 'router-view','vue-bootstrap-typeahead']
     
    });
    test('postcode search method changes the respective variables', async () => {
        
        await wrapper.find('#code').trigger('blur');
        expect(wrapper.vm.postcodes).toHaveLength(1);
        expect(wrapper.vm.regionData).toHaveLength(1);
        expect(wrapper.vm.regionData[0]).toBe("cd");
        expect(wrapper.vm.countryData).toHaveLength(1);
        expect(wrapper.vm.countryData[0]).toBe("ab");
        
        
     });
     
     test('alert is triggered when form data is empty', async () => {
        const wrapper = shallowMount(Register, {
            data() {
                return {
                  code: '',
                  region:'',
                  country:'',
                  countryData: [],
                  regionData:[],
                  postcodes:[],
                  form:{
                    username:null,
                    password:null,
                    address:null,
                    fullname:null
                    
                  },
                }
              },
            
            mocks : {
            $store
            },
            stubs: ['router-link', 'router-view','vue-bootstrap-typeahead']
         
        });
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
    const wrapper = shallowMount(Register, {
        data() {
            return {
                code: 'a',
                  region:'b',
                  country:'c',
                  adress_line:'a b c d',
                  firstname: 'a',
                  lastname:'b',
                  form:{
                    username:'def',
                    password:'y',
                    address:null,
                    fullname:'a b'
                    
                  }
                }
            
          },
        
        mocks : {
        $store
        },
        stubs: ['router-link', 'router-view','vue-bootstrap-typeahead']
     
    });
    //case input fields are not fulfilled 
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
    const mock_function3 = jest.fn();
   /* const register_mock = async () =>{
        let response = await axios.post('http://localhost:8080/api/messages/user', "")
        
    }*/
    

 const $store = {
        state:{
            cart:[]
        }, 
        getters : {
            authenticated: () => ({}),
            'auth/authenticated': null,
            user: () => ({}),
            'auth/user': null

        },
       
}

    const wrapper = shallowMount(Register, {
        data() {
            return {
                code: 'a',
                  region:'b',
                  country:'c',
                  adress_line:'a b c d',
                  firstname: 'a',
                  lastname:'b',
                  form:{
                      //a username which is  not registered is defined
                    username:'abc',
                    password:'y',
                    address:null,
                    fullname:'a b'
                    
                  }
                }
            
          },
          methods: {
            register: mock_function3,
          },
        mocks : {
        $store
        },
        stubs: ['router-link', 'router-view','vue-bootstrap-typeahead'],
     
    });
    //case input fields are not fulfilled 
    const mock_function = jest.fn()
    wrapper.setMethods({showAlert:mock_function});
    const mock_function2 = jest.fn();
    wrapper.setMethods({showAlert2:mock_function2});
    await wrapper.find('.btnSubmit').trigger('click')
    //wrapper.setMethods({register:register_mock});
   //wrapper.setMethods({showSuccessAlert:mock_function3});
    //adress is fulfilled within the submit method
    expect(wrapper.vm.form.address).toBeTruthy()
    expect(wrapper.vm.form.address).toBe(wrapper.vm.code + " " + wrapper.vm.country + " " + wrapper.vm.region + " " + wrapper.vm.adress_line)
     //Fullname is fulfilled within the submit method
    expect(wrapper.vm.form.fullname).toBe(wrapper.vm.firstname + " " + wrapper.vm.lastname)
    //register action is called from vuex store
    expect(mock_function3).toHaveBeenCalled()
    
})
})
