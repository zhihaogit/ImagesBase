import { defineStore } from "pinia";
import {
  loginApi,
} from '@/apis/user';
import Cookies from 'js-cookie'

export default defineStore('userStore', {
  state: ()=> ({
    token: '',
  }),

  actions: {
    async loginRequest(param: string) {
      try {
        const result = await loginApi(param);
        this.token = result.data.data.token;
        Cookies.set('token', this.token);
        return result;
      } catch (error) {
        return error;
      }
    },
  }
});
