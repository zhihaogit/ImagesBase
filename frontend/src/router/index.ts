import { RouterNameEnum } from '@/constants/enum/RouterNameEnum';
import Cookies from 'js-cookie';
import { createRouter, createWebHistory } from 'vue-router'
import routes from './list';

const router = createRouter({
  history: createWebHistory(),
  routes,
});

router.beforeEach((to, from, next) => {
  if (RouterNameEnum.LOGIN === to.name) {
    Cookies.remove('token');
  }
  next();
});

export default router;
