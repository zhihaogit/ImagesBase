import { defineStore } from "pinia";
import { loginApi, userInfoApi } from '@/apis/user';
import Cookies from 'js-cookie'
import { UserInfoInterface } from "@/constants/interface/UserInterface";

export default defineStore('userStore', {
  state: () => ({
    token: '' as string,
    userInfo: {} as UserInfoInterface,
  }),

  actions: {
    async loginRequest(param: string) {
      try {
        const result = await loginApi(param);
        this.token = result.data.data.token;
        Cookies.set('token', this.token);
        await this.userInfoRequest();
        return result;
      } catch (error) {
        return error;
      }
    },

    async userInfoRequest() {
      try {
        const result = await userInfoApi();
        this.userInfo = result.data.data;
        return result;
      } catch (error) {
        return error;
      }
    },
  }
});
