import auth from '@/store/auth'
const getters= auth.getters;

describe('Getters', () => {
    const state = {
        id:"ab1",
        user:"cd"
      };
      const id = "ab1"
      test('Returns user id', () => {
        expect(getters.authenticated(state)).toBe(id)
      });
      test('Returns username', () => {
          const user = "cd"
        expect(getters.user(state)).toBe(user);
      })
    })