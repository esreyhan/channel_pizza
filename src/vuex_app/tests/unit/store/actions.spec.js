import {getProducts}  from '@/store/actions'

let url = ''
let body = {}
jest.mock('axios',() => ({

    post: (_url, _body) =>{
        return new Promise((resolve) => {
        url= _url
        body = _body
        
        resolve({data:{"id":1,"title":'Product'}})
        })
    },
    get:(_url) => {
        return new Promise((response) => {
        url= _url
        const mock_data = {data:[{"id":1,"title":'Product'},{"id":1,"title":'Product'}]}
        response(mock_data)
    })
        }
})




)

describe('Actions', () => {

    test('product list is returned', async () => {
    const commit = jest.fn()
    await getProducts({commit})
    const data = [{"id":1,"title":'Product'},{"id":1,"title":'Product'}]
    expect(url).toBe("http://localhost:8080/api/messages/findAllItems")
    expect(commit).toHaveBeenCalledWith('SET_PRODUCTS', data)

        
    
        
})
})

