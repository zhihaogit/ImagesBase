import axios from 'axios'
import { ElMessage } from 'element-plus'

const instance = axios.create({
  baseURL: '/api',
  timeout: 10000,
  withCredentials: true,
  headers: {
    'Content-Type': 'application/json;charset=UTF-8',
  },
});

// 添加请求拦截器
axios.interceptors.request.use(
  (config) => {
    console.log('req', config)
  // const { authorization } = store.state.app
  //   if (authorization) {
  //     config.headers.Authorization = `Bearer ${authorization.token}`
  //   }
  return config;
  },
  error => Promise.reject(error)
);

// 添加响应拦截器
axios.interceptors.response.use(
  response => response,
  (error) => {
    console.log('res：error', error)
    return Promise.reject(error);
  }
);

export default instance;
