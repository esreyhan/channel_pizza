import auth from '@/store/auth'
const mutations = auth.mutations;
describe('Mutations', () => {
    const state = {
        id: null,
        username:null
      }
test('Sets the user id', () => {
    
    
    const id = "ab1";
    mutations.SET_ID(state,id);
    expect(state.id).toBe(id);
  });
  test('Sets the username', () => {
    
    
    const username = "ab1";
    mutations.SET_USER(state,username);
    expect(state.user).toBe(username);
  });
  test('User information is set to null upon call', () => {
    
    mutations.LOG_OUT (state);
    expect(state.user).not.toBeTruthy;
    expect(state.id).not.toBeTruthy;
  });
})