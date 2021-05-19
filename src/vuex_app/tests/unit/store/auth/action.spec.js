import auth from '@/store/auth'
import { _ } from 'core-js'

const actions = auth.actions;
let url = ''
let body = {}
jest.mock('axios',() => ({

    post:(_url, _body) => {
        switch (_url) {
            case 'http://localhost:8080/api/messages/user':
                return new Promise((response) => {
                    url= _url
                    body=_body
                    const mock_data = {data:{"id":"ab2","username":"az","password":'bz'}}
                    response(mock_data)
                })
            case 'http://localhost:8080/api/messages/addUser':
                return new Promise((response) => {
                    url= _url
                    body=_body
                    const mock_data = {data:{"id":"bc3","username":"ax","password":'bx'}}
                    response(mock_data)
                })
            default:
              return Promise.reject(new Error('not found'))
          }
        
    }
}))


describe('Actions with response', () => {

    test('commit is made with username and password', async () => {
    const commit = jest.fn();
    const mock_userdata = {"username":"az","password":'bz'}
    await actions.signIn({commit},mock_userdata)
    expect(url).toBe("http://localhost:8080/api/messages/user")
    expect(body).toBe(mock_userdata)
    expect(commit).toHaveBeenCalledWith('SET_USER', 'az')
    expect(commit).toHaveBeenCalledWith('SET_ID', 'ab2')

});
test('registration information is sent and user info is returned and commit is made upon registration', async () => {
    const commit = jest.fn();
    const mock_userdata = {"username":"ax","password":'bx',"address":"a -b postcode: x"};
    await actions.register({commit},mock_userdata)
    expect(url).toBe("http://localhost:8080/api/messages/addUser")
    expect(body).toBe(mock_userdata)
    expect(commit).toHaveBeenCalledWith('SET_USER', 'ax')
    expect(commit).toHaveBeenCalledWith('SET_ID', 'bc3')
});
test('Logout is committed upon call', async () => {
    const commit = jest.fn();
    await actions.signout({commit});
    expect(commit).toHaveBeenCalledWith('LOG_OUT');
})
})