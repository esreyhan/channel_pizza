import {mount, shallowMount} from '@vue/test-utils'
import Home from '@/pages/Home.vue'

describe('Minicart.vue', () => {
    const wrapper = mount(Home, {

stubs: ['router-link', 'router-view']
    })

    test('is a vue instance', () => {
        
        expect(wrapper.isVueInstance()).toBeTruthy()
    })
    test('check whether image is rendered', () => {

    const img = wrapper.findAll('img');
    expect(img.length).toBe(1);

    })
})