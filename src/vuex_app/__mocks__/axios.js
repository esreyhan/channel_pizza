

let url = ''
let body = {}

jest.mock('axios',() => ({

    post: (_url, _body) =>{
        return new Promise((resolve) => {
        url= _url
        body = _body
        data = {"id":1,"title":'Product'}
        })
    },
    get:(_url) => {
        data = [{"id":1,"title":'Product 1'}, {"id":2, "title":'Product 2'}]
    }
})




)


