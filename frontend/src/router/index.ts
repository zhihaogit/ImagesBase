import { RouterNameEnum } from '@/constants/enum/RouterNameEnum';
import Cookies from 'js-cookie';
import { createRouter, createWebHistory } from 'vue-router'
import routes from './list';
import userStoreStart from "@/store/user";

const router = createRouter({
  history: createWebHistory(),
  routes,
});

/* eslint-disable  @typescript-eslint/no-explicit-any */
let userStore: any;

router.beforeEach(async (to, from, next) => {
  if (!userStore) {
    userStore = userStoreStart();
  }
  if (RouterNameEnum.LOGIN === to.name) {
    Cookies.remove('token');
  } else if (!Cookies.get('token')) {
    next({ name: RouterNameEnum.LOGIN });
  } else if (Cookies.get('token') && !userStore?.userInfo?.id) {
    await userStore.userInfoRequest();
  }
  next();
});

export default router;
