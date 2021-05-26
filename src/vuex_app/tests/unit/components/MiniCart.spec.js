import {mount, shallowMount} from '@vue/test-utils'
import MiniCart from '@/components/Minicart.vue'
import {createLocalVue} from '@vue/test-utils'
import Vuex from 'vuex'
import {mapState} from 'vuex'
const localVue = createLocalVue()
localVue.use(Vuex)
/**
 * Test class for MiniCart. Vue.js unit test are used. 
 * Two products are added in the vuex store as given. 
 * The test is applied for both cases where user information is present and is not present in the vuex store.  
 * @author Enis Sinan Reyhan <enissinanreyhan@gmail.com>
 */
describe('Minicart.vue', () => {
  const title1 = "italian__";
  const title2 = "local___";
  const price1 = 3
  const price2 = 2
  const quantity1 = 2
  const quantity2=1
  const itemTotal = 8
  const itemCount = 3

  const mutations = {
    usernull: (state) => { state.userid = null},
};
const getters = {
    cart:() => [],
    cartItemCount:itemCount,
    total: itemTotal
}
const state = {
    cart: [{"product": {id:"a1",title:title1,"image": "neapolitan.jpg", "price":price1}, "quantity":quantity1},{"product": {id:"a3",title:title2,type:"local","image": "neapolitan.jpg", "price":price2}, "quantity":quantity2}],
    authenticated:'ab2',
    user:'user',
    userid:'ab3'
};
    const factory = (state) =>{ 
        return mount(MiniCart, {
        data () {
            return {
                hover: false,
                order:{
                  oderitems:[],
                  quantity:[],
                  total:null,
                  userid:''
                  
                }
              }
            },
            computed: {
                ...mapState({
                    userid: state => state.userid,
                    cart: state => state.cart
                
                  }),
                },
        mocks: {
          $store: {
            state,
            getters:{
                cart:() => [],
                cartItemCount:itemCount,
                total: itemTotal
            },
            mutations,
          }
        },
        stubs: ['router-link', 'router-view','vue-bootstrap-typeahead','...mapState'],
        localVue
      })
    }
//order registration axios function is mocked as to return data. 
    const regOrder_mock = async () => { return new Promise((response) => {
        const mock_data={data:{"id":"ab2"}}
        response(mock_data);
  
        })
      }

//mocked function is set in wraopper
const wrapper = factory(state)
wrapper.setMethods({regOrder:regOrder_mock})
//clear function is mocked
const mock_clear = jest.fn()
wrapper.setMethods({clear:mock_clear})
//redirect function is mocked
const mock_redirect = jest.fn()
wrapper.setMethods({redirect:mock_redirect})
//show alert function is mocked
const mock_showAlert= jest.fn()
wrapper.setMethods({showAlert:mock_showAlert})

      test('is a vue instance', () => {
        
        expect(wrapper.isVueInstance()).toBeTruthy()
    }),
    test('cart is rendered by the vuex getter', () => {
    
      expect(wrapper.vm.cart).toHaveLength(2)
  })

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
test('Total and Item Count is rendered by getters', () => {

  expect(wrapper.text()).toContain(itemTotal)
  expect(wrapper.text()).toContain(itemCount)

})
test('Clear function is triggerred by the button', async () => {

await wrapper.find('#hover').trigger('click');
await wrapper.vm.$nextTick() 
expect(mock_clear).toHaveBeenCalled()


})

test ('Order property has been revised as per the items in the cart', async () => {
    await wrapper.find('#btcheckout').trigger('click'); 
    await wrapper.vm.$nextTick();
    expect(wrapper.vm.order).toBeTruthy()
    expect(wrapper.vm.order.orderitems).toHaveLength(2)
    
    

})
test ('redirect function is called as the order is successful',  () =>{
    //as user data is present, redirect function is called with the help of mock register function
    expect(mock_redirect).toHaveBeenCalled()
})

test('Alert function is triggered when the userid is null', async () => {
    const state = {
        cart: [{"product": {id:"a1",title:title1,"image": "neapolitan.jpg", "price":price1}, "quantity":quantity1},{"product": {id:"a3",title:title2,type:"local","image": "neapolitan.jpg", "price":price2}, "quantity":quantity2}],
        authenticated:'',
        user:'',
        userid:''
    };
const wrapper = factory(state)
wrapper.setMethods({regOrder:regOrder_mock})
wrapper.setMethods({clear:mock_clear})
wrapper.setMethods({redirect:mock_redirect})
wrapper.setMethods({showAlert:mock_showAlert})
 await wrapper.find('#btcheckout').trigger('click'); 
 //await wrapper.vm.mocks.store.commit('usernull');
 await wrapper.vm.$nextTick();
 expect(mock_showAlert).toHaveBeenCalled()
})
})