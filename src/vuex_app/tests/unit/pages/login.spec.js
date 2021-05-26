import {mount, shallowMount} from '@vue/test-utils'
import Login from '@/pages/login.vue'
import {createLocalVue} from '@vue/test-utils'
import Vuex from 'vuex'
import VueRouter from 'vue-router'
import auth from '@/store/auth'

/**
 * Test class for Login page Vue.js unit test are used. 
 * It is checked whether the form data is passed as element and the respective functions are called for succesfful and unsuccesful login. 
 * @author Enis Sinan Reyhan <enissinanreyhan@gmail.com>
 */
describe('Actions', () => {
    const redirect_mock = jest.fn()
            const signIn_mock = async () => { return new Promise((response) => {
                const mock_data={data:{"username":"ab"}}
                response(mock_data);
        
                })

            }
    const wrapper = mount(Login, {
        data () {
            return {
              form:{
                username:'',
                password:'',
                
              },
              loginfailed:false
            }
            },
            methods :{redirect:redirect_mock,
                    signIn:signIn_mock

            },
      
       
        stubs: ['router-link', 'router-view']
     
    });
       
    
        test('is a vue instance', () => {
        
            expect(wrapper.isVueInstance()).toBeTruthy()
        })
        test('inputs are bound to the variables', async () => {
            const textUsername = wrapper.find('#username')
            const textPassword = wrapper.find('#password')
            const username = "username"
            const password = "password"
            await textUsername.setValue(username)
            await textPassword.setValue(password)
            await wrapper.find('#submit').trigger('click');
            expect(wrapper.find('#username').element.value).toBe(username)
            expect(wrapper.find('#password').element.value).toBe(password)
        })
        //redirect function is called upon successful login
        test('test with mocked redirect and signin', async () => {
            
           /* wrapper.setMethods({redirect:redirect_mock})
            wrapper.setMethods({signIn:signIn_mock})
            wrapper.setMethods({submit:submit_mock})*/
            await wrapper.find("form").trigger("submit.prevent")
            await wrapper.vm.$nextTick() 
            expect(redirect_mock).toHaveBeenCalled()
        })

        // the incorrect login message is shown on the template 
        test('test with authorization failed ', async () => {
            const submit_mock = jest.fn()
            /* wrapper.setMethods({redirect:redirect_mock})
             wrapper.setMethods({signIn:signIn_mock})*/
             wrapper.setMethods({submit:submit_mock})
             await wrapper.find("form").trigger("submit.prevent")
             await wrapper.setData({ loginfailed:true })
             await wrapper.vm.$nextTick() 
             expect(wrapper.text()).toContain("Login information is incorrect")
         })

})


