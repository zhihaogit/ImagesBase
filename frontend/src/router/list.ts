import { RouterNameEnum } from '@/constants/enum/RouterNameEnum';

export default [
  {
    path: '/',
    redirect: {
      name: RouterNameEnum.HOME
    },
    meta: {
      title: '主页',
      isMenuShow: false,
    }
  },
  {
    path: '/home',
    name: RouterNameEnum.HOME,
    component: () => import('../pages/home/index.vue'),
    meta: {
      title: '主页',
      isMenuShow: true,
    }
  },
  {
    path: '/upload',
    name: RouterNameEnum.UPLOAD,
    component: () => import('../pages/upload/index.vue'),
    meta: {
      title: '图片上传',
      isMenuShow: true,
    }
  },
  {
    path: '/login',
    name: RouterNameEnum.LOGIN,
    component: () => import('../pages/login/index.vue'),
    meta: {
      title: '登录',
      isMenuShow: false,
    }
  },
];
