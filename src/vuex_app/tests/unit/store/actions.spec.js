import {getProducts,getProduct,addProductToCart,addOrder,cartClear}  from '@/store/actions'
import { _ } from 'core-js'

let url = ''
let body = {}
jest.mock('axios',() => ({

    post: (_url, _body) =>{
        return new Promise((response) => {
        url= _url
        body = _body
        const mock_data= {data:{"id": "60a3cd325c87da218e63b658",
    "orderitems": [
        "1",
        "2"
    ]}}
        response(mock_data);
        })
    },
    get:(_url) => {
        switch (_url) {
            case 'http://localhost:8080/api/messages/findAllItems':
                return new Promise((response) => {
                    url= _url
                    const mock_data = {data:[{"id":1,"title":'Product'},{"id":1,"title":'Product'}]}
                    response(mock_data)
                })
            case 'http://localhost:8080/api/messages/findItemById/1':
                return new Promise((response) => {
                    url= _url
                    const mock_data = {data:{"id":1,"title":'Product'}}
                    response(mock_data)
                })
            default:
              return Promise.reject(new Error('not found'))
          }
        
        }
})
)

describe('Actions', () => {

    test('product list is returned', async () => {
    const commit = jest.fn();
    await getProducts({commit})
    const data = [{"id":1,"title":'Product'},{"id":1,"title":'Product'}]
    expect(url).toBe("http://localhost:8080/api/messages/findAllItems")
    expect(commit).toHaveBeenCalledWith('SET_PRODUCTS', data)

        
    
        
});

test('product is returned with getProduct function', async () => {
    const commit = jest.fn();
    await getProduct({commit},1);
    const data = {"id":1,"title":'Product'};
    expect(url).toBe("http://localhost:8080/api/messages/findItemById/1");
    expect(commit).toHaveBeenCalledWith('SET_PRODUCT', data)
});
test('addtoProductCard functions commits product and its quantity', () => {
    const commit = jest.fn();
    const product = {"id":1,"title":'Product'};
    const quantity = 2
    addProductToCart({commit},{product,quantity});
    
    expect(commit).toHaveBeenCalledWith('ADD_TO_CART', {product,quantity})
});
test('addOrder function is committing after axios call', async () => {
    const commit = jest.fn();
    const cartInfo = {"orderitems": ["1","2"]};
    await addOrder({commit},cartInfo);
    const order = {"id": "60a3cd325c87da218e63b658",
    "orderitems": [
        "1",
        "2"
    ]};
    
  expect(url).toBe('http://localhost:8080/api/messages/addOrder');
  expect(body).toBe(cartInfo);
expect(commit).toHaveBeenCalledWith('SET_ORDER', order)
});
test('cartClear function commits CART_CLEAR mutation', async () => {
    const commit = jest.fn();
    cartClear({commit});
    expect(commit).toHaveBeenCalled()
});
})

