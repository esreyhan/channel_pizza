import {mount, shallowMount} from '@vue/test-utils'
import AddProduct from '@/pages/admin/Addproduct.vue'

/**
 * Test class for Addproduct page Vue.js unit test are used. 
 * It is checked whether the form data is passed as element and the respective functions are called for succesfful and unsuccesful login. 
 * @author Enis Sinan Reyhan <enissinanreyhan@gmail.com>
 */


describe('AddProduct', () => {
    const function_mock = jest.fn()
    const wrapper = mount(AddProduct, {
        data () {
            return {
                form :{title:'',
                description:'',
                price:null,
                image:'',
                type:''
                }
            }
            },
            methods :{submitProduct:function_mock
                 

            },
      
       
        stubs: ['router-link', 'router-view']
     
    });
    test('is a vue instance', async () => {
        
        expect(wrapper.isVueInstance()).toBeTruthy()
    })
    test('inputs are bound to the variables', async () => {
        const text1= wrapper.find('#title')
        const text2= wrapper.find('#description')
        const title = "title"
        const desc = "descriptiopn"
        await text1.setValue(title)
        await text2.setValue(desc)
        await wrapper.find('button').trigger('click');
        
        expect(wrapper.vm.form.title).toBe(title)
        expect(wrapper.vm.form.description).toBe(desc)
        expect(function_mock).toHaveBeenCalled()
        
    })


       
})