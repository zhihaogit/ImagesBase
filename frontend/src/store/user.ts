import { defineStore } from "pinia";
import {
  loginApi,
} from '@/apis/user';

export default defineStore('userStore', {
  state: ()=> ({
    token: '',
  }),

  actions: {
    async loginRequest(param: string) {
      try {
        const result = await loginApi(param);
        console.log(result);
        // this.token = result;
      } catch (error) {
        return error;
      }
    },
  }
});
