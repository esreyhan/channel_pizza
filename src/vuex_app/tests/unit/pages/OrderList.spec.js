import {mount, shallowMount} from '@vue/test-utils'
import OrderList from '@/pages/admin/OrderList.vue'

import {createLocalVue} from '@vue/test-utils'
import Vuex from 'vuex'
const localVue = createLocalVue()
localVue.use(Vuex)

/**
 * Test class for ProductAdmin page. Vue.js unit test are used. 
 * It is checked whether product items are rendered correctly. 
 * @author Enis Sinan Reyhan <enissinanreyhan@gmail.com>
 */
describe('OrderList.vue', () => {
const title1 = "title1"
const title2 = "title2"
const title3 ="title3"


const id1 = "a1"
const items1= ["b1","b2"]
const quantity1 = [2,4]
const total1= 5.5
const date1 = "1.1.2021"
const userid1 = "test1"
const id2 = "a2"
const items2= ["c1","c2"]
const quantity2 = [3,5]
const total2= 6.5
const date2 = "2.1.2021"
const userid2 = "test2"

const wrapper = mount(OrderList, {
    data () {
        return {
            orders: [{id:id1,orderitems:items1,quantity:quantity1,total:total1,date:date1,userid:userid1}, {id:id2,orderitems:items2,quantity:quantity2,total:total2,date:date2,userid:userid2}], 
        }
    },
    
    stubs: ['router-link', 'router-view','axios'],
  
 
});

   

test('is a vue instance', () => {
    
    expect(wrapper.isVueInstance()).toBeTruthy()
}),
test('Products are rendered by the vuex getter', () => {

    expect(wrapper.vm.orders).toHaveLength(2)
})
test('Products are rendered by the vuex getter/titles are checked for each type', () => {
    //random chosen within different features 
    
    expect(wrapper.find('#orderrow')).toBeTruthy()
 
    expect(wrapper.text()).toContain(id1)

    expect(wrapper.text()).toContain(items1[0])
  
    expect(wrapper.text()).toContain(total1)

    expect(wrapper.text()).toContain(quantity2[1])

    expect(wrapper.text()).toContain(date2)

    expect(wrapper.text()).toContain(userid1)
})


})
