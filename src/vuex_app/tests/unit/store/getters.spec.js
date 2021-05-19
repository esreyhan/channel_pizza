import {cartItemCount,total} from '@/store/getters'

describe('Getters', () => {
    const state = {
        cart:[{"product":{"id":1,"title":'Product',"price":4},"quantity":2},{"product":{"id":1,"title":'Product',"price":2},"quantity":1}]
      }
      test('Returns total number of items', () => {
        expect(cartItemCount(state)).toBe(3);


      });
      test('Returns total amount by calculating the price and quantity', () => {
        expect(total(state)).toBe(10);
      })
})