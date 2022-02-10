import request from '../utils/request';

export const loginApi = (data: string) => {
  return request({
    headers: {
      'Content-Type': 'text/plain',
      'Authorization': `Basic ${data}`
    },
    url: '/user/login',
    method: 'post',
    data,
  })
}
