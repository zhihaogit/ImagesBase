import { HttpStatusEnum } from '@/constants/enum/HttpStatusEnum';
import axios from 'axios'
// 按需引用 element-plus的组件，需要同时手动导入组件样式
import { ElMessage } from 'element-plus'
import router from '@/router'
import { RouterNameEnum } from '@/constants/enum/RouterNameEnum';
import Cookies from 'js-cookie'

const instance = axios.create({
  baseURL: '/api',
  timeout: 10000,
  withCredentials: true,
  headers: {
    'Content-Type': 'application/json;charset=UTF-8',
  },
});

// 添加请求拦截器
instance.interceptors.request.use(
  config => {
    const token = Cookies.get('token');
    if (config.headers && token) {
      config.headers.token = token;
    }
    return config;
  },
  error => Promise.reject(error)
);

// 添加响应拦截器
instance.interceptors.response.use(
  response => response,
  error => {
    if (HttpStatusEnum.UNAUTHORIZED === error.response.status) {
      ElMessage.error(error.response.data.msg);
      if (RouterNameEnum.LOGIN !== router.currentRoute.value.name) {
        router.push(RouterNameEnum.LOGIN);
      }
    } else if (HttpStatusEnum.NOT_FOUND === error.response.status) {
      ElMessage.error(error.response.statusText);
    } else {
      ElMessage.error(error.response.statusText);
    }
    return Promise.reject(error);
  }
);

export default instance;
