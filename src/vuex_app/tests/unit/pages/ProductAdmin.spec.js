import {mount, shallowMount} from '@vue/test-utils'
import ProductAdmin from '@/pages/admin/ProductAdmin.vue'

import {createLocalVue} from '@vue/test-utils'
import Vuex from 'vuex'
const localVue = createLocalVue()
localVue.use(Vuex)

/**
 * Test class for ProductAdmin page. Vue.js unit test are used. 
 * It is checked whether product items are rendered correctly. 
 * @author Enis Sinan Reyhan <enissinanreyhan@gmail.com>
 */
describe('ProductAdmin.vue', () => {
    const title1 = "title1"
    const title2 = "title2"
    const title3 ="title3"
    const    state = {
          cart: [],
          products: [{id:"a1",title:title1,type:"italian","image": "neapolitan.jpg"}, {id:"a2", title: title2,type:"beverage","image": "neapolitan.jpg"}, {id:"a3",title:title3,type:"local","image": "neapolitan.jpg"}], 
          authenticated:'ab2',
          user:'user'
        }
        const getters = {
            getProducts:() => []
        }
        
    const  store = new Vuex.Store({
            state,
            getters,
        
          });

    const wrapper = mount(ProductAdmin, {
         
        stubs: ['router-link', 'router-view'],
        store,
        localVue
     
    });
   

test('is a vue instance', () => {
    
    expect(wrapper.isVueInstance()).toBeTruthy()
}),
test('Products are rendered by the vuex getter', () => {

    expect(wrapper.vm.products).toHaveLength(3)
})
test('Products are rendered by the vuex getter/titles are checked for each type', () => {
    expect(wrapper.find('.tr')).toBeTruthy()
    //title 1
    expect(wrapper.text()).toContain(title1)
    //title 2
    expect(wrapper.text()).toContain(title2)
    //title 3
    expect(wrapper.text()).toContain(title3)
})
test('Products are rendered by the vuex getter/titles are checked for each type', async () => {
    const mock_function = jest.fn()
    wrapper.setMethods({deleteProduct: mock_function})
    await wrapper.find('#submitButton').trigger('click')
    expect(mock_function).toHaveBeenCalled()
        //title 1
})

})