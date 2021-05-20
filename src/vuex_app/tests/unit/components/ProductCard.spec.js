import {mount, shallowMount} from '@vue/test-utils'
import ProductCard from '@/components/ProductCard'
import {createLocalVue} from '@vue/test-utils'
import Vuex from 'vuex'
const localVue = createLocalVue()
localVue.use(Vuex)




describe('ProductCard.vue', () => {

    
    const    state = {
        cart: [],
        authenticated:'ab2',
        user:'user'
      }

  const  store = new Vuex.Store({
          state,
          /*
          modules: {
            auth: {
              actions,
              mutations,
              getters: auth.getters,
              namespaced: true
            }
          }*/
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
//values shown by product card is tested in parent element, here is tested again
test('item is rendered by the vuex store', () => {
    //title 1
    expect(wrapper.text()).toContain(title1)

    // price
    expect(wrapper.text()).toContain(price)
    //descriotion is rendered 
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