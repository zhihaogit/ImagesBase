import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  {
    path: '/',
    redirect: "/home"
  },
  {
    path: '/home',
    name: 'home',
    component: () => import('./pages/home/index.vue')
  },
  {
    path: '/upload',
    name: 'upload',
    component: () => import('./pages/upload/index.vue')
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('./pages/login/index.vue')
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
