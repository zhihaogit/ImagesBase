import request from '@/utils/request';

/**
 * 登录接口
 *
 * @param data - string
 * @returns 
 */
export const loginApi = (data: string) => request({
  headers: {
    'Content-Type': 'text/plain',
    'Authorization': `Basic ${data}`
  },
  url: '/user/login',
  method: 'POST',
  data,
});

/**
 * 获取用户信息
 *
 * @returns 
 */
export const userInfoApi = () => request({
  url: '/user/info',
  method: 'GET',
});

/**
 * 登出接口
 *
 * @param data - string
 * @returns 
 */
 export const logoutApi = () => request({
  url: '/user/logout',
  method: 'GET',
});
