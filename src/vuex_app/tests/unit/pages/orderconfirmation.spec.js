import {mount, shallowMount} from '@vue/test-utils'
import Orderconfirmation from '@/pages/Orderconfirmation.vue'
import {createLocalVue} from '@vue/test-utils'
import Vuex from 'vuex'
const localVue = createLocalVue()
localVue.use(Vuex)

describe('Orderconfirmation.vue', () => {
  const title1 = "italian__";
  const title2 = "local___";
  const price1 = 3
  const price2 = 2
  const quantity1 = 2
  const quantity2=1
  const itemTotal = 8
    const wrapper = mount(Orderconfirmation, {
        mocks: {
          $store: {
            state: {
                cart: [{"product": {id:"a1",title:title1,"image": "neapolitan.jpg", "price":price1}, "quantity":quantity1},{"product": {id:"a3",title:title2,type:"local","image": "neapolitan.jpg", "price":price2}, "quantity":quantity2}],
                authenticated:'ab2',
                user:'user'
            }, 
            getters:{
                cart:() => [],
                total: itemTotal
            }
          }
        },
       
        localVue
      })
      test('is a vue instance', () => {
        
        expect(wrapper.isVueInstance()).toBeTruthy()
    }),
    test('cart is rendered by the vuex getter', () => {
    
      expect(wrapper.vm.cart).toHaveLength(2)
  }),
  test('items are rendered as a list by the vuex store', () => {
    
    //title 1
    expect(wrapper.text()).toContain(title1)
    //title 2
    expect(wrapper.text()).toContain(title2)

    //quantity 1
    expect(wrapper.text()).toContain(quantity1)
    // quantity 2
    expect(wrapper.text()).toContain(quantity2)
    //price 1
    expect(wrapper.text()).toContain(price1)
    //price 2
    expect(wrapper.text()).toContain(price2)
    // two images are rendered
    const img = wrapper.findAll('.img-fluid');
    expect(img.length).toBe(2);
})
test('Total is rendered by getters', () => {

  expect(wrapper.text()).toContain(itemTotal)

})
})