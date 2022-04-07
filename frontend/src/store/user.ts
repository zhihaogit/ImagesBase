import { defineStore } from "pinia";
import { loginApi, logoutApi, userInfoApi } from '@/apis/user';
import Cookies from 'js-cookie'
import { UserInfoInterface } from "@/constants/interface/UserInterface";
import { ElMessage } from "element-plus";
import { RouterNameEnum } from "@/constants/enum/RouterNameEnum";
import router from "@/router";

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
        return Promise.reject(error);
      }
    },

    async userInfoRequest() {
      try {
        const result = await userInfoApi();
        this.userInfo = result.data.data;
        return result;
      } catch (error) {
        ElMessage.error("获取用户信息失败");
        await logoutApi();
        Cookies.remove('token');
        router.replace(RouterNameEnum.LOGIN);
        return Promise.reject(error);
      }
    },

    async logoutRequest() {
      try {
        return await logoutApi();
      } catch (error) {
        return Promise.reject(error);
      }
    },
  }
});
