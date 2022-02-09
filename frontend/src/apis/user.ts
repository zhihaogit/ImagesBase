import request from '../utils/request';

const getUrl = (url: string) => `/user${url}`;

export const loginApi = (data: string) => {
  return request({
    headers: {
      'Content-Type': 'text/plain',
      'Authorization': `Basic ${data}`
    },
    url: getUrl('/login'),
    method: 'post',
    data,
  })
}
