import {SET_PRODUCTS,SET_PRODUCT,CART_CLEAR} from '@/store/mutations'
describe('Mutations', () => {
    const state = {
        products: [],
        product:null,
        cart:[]
      }
test('Add products to the vuex state', () => {
    
    
    const products = [{"id":1,"title":'Product'},{"id":1,"title":'Product'}];
    SET_PRODUCTS(state,products);
    expect(state.products).toBe(products);
  });

  test('Adds a specific product to vuex state', () => {
    const product = {"id":1,"title":'Product'};
    SET_PRODUCT(state,product);
    expect(state.product).toBe(product);
  });
  test('Clears the cart', () => {
    state.cart.push({"id":1,"title":'Product'});
    state.cart.push({"id":1,"title":'Product'});
    CART_CLEAR(state);
    expect(state.cart).toHaveLength(0);

})

})