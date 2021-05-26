import {mount, shallowMount} from '@vue/test-utils'
import ProductCard from '@/components/ProductCard'
import {createLocalVue} from '@vue/test-utils'
import Vuex from 'vuex'
const localVue = createLocalVue()
localVue.use(Vuex)

/**
 * Test class for ProductCard. Vue.js unit test are used. 
 * It is checked whether the item is rendered and add to cart function is called 
 * @author Enis Sinan Reyhan <enissinanreyhan@gmail.com>
 */


describe('ProductCard.vue', () => {

    
    const    state = {
        cart: [],
        authenticated:'ab2',
        user:'user'
      }

  const  store = new Vuex.Store({
          state,

        });
        const title1 = "italian__"
        const price = 5
        const description = "description____"
  const wrapper = mount(ProductCard, {
      propsData : {
        product:{id:"a1","title":title1,"price":price, type:"italian", image: "neapolitan.jpg","description":description}
      },
      store,
      localVue,
      stubs: ['router-link', 'router-view','vue-bootstrap-typeahead']

   
  })
  const mock_addtoCart= jest.fn()
  
  wrapper.setMethods({addToCart:mock_addtoCart})
  test('is a vue instance', () => {
        
    expect(wrapper.isVueInstance()).toBeTruthy()
}) 
//values are shown by the product cart or not 
test('item is rendered by the vuex store', () => {
    //title 1
    expect(wrapper.text()).toContain(title1)

    // price
    expect(wrapper.text()).toContain(price)
    //description is rendered 
    expect(wrapper.text()).toContain(description)
    // single image is rendered
    const img = wrapper.findAll('img');
    expect(img.length).toBe(1);
})

test('AddtoCart function is triggered by the add button', async () => {
await wrapper.find('button').trigger('click');
expect(mock_addtoCart).toHaveBeenCalled();

})
})