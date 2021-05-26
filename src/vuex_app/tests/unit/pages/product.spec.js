import {mount, shallowMount} from '@vue/test-utils'
import Product from '@/pages/product.vue'
import {createLocalVue} from '@vue/test-utils'
import Vuex from 'vuex'

/**
 * Test class for Product page. Vue.js unit test are used. 
 * It is checked whether the product information is get from vuex store and addtocart button functions.  
 * @author Enis Sinan Reyhan <enissinanreyhan@gmail.com>
 */

const localVue = createLocalVue()
localVue.use(Vuex)
const title1 = "italian__"
const price = 5
const description = "description____"
describe('Product.vue', () => {
    const    state = {
        cart: [],
        product:{id:"a1","title":title1,"price":price,type:"italian", "image": "neapolitan.jpg","description":description},
        authenticated:'ab2',
        user:'user'
      }
    const actions = {
        getProduct: () => {}
    }
  const  store = new Vuex.Store({
          state,
          actions,
      
        });

  const wrapper = mount(Product, {
       
      stubs: ['router-link', 'router-view'],
      store,
      localVue
   
  });
  const mock_addtoCart= jest.fn()
  const quantity = "1"
  wrapper.setData({quantity:quantity})
  wrapper.setMethods({addToCart:mock_addtoCart})
  test('is a vue instance', () => {
        
    expect(wrapper.isVueInstance()).toBeTruthy()
})
test('item is rendered by the vuex store', () => {
    //title 1
    expect(wrapper.text()).toContain(title1)

    //quantity is rendered as 1 by default
    expect(wrapper.find('input').element.value).toEqual(quantity);
    // price
    expect(wrapper.text()).toContain(price)
    //descriotion is rendered 
    expect(wrapper.text()).toContain(description)
    // single image is rendered
    const img = wrapper.findAll('.w-100');
    expect(img.length).toBe(1);
})
test('AddtoCart function is triggered by the add button', async () => {
await wrapper.find('button').trigger('click');
expect(mock_addtoCart).toHaveBeenCalled();

})
})