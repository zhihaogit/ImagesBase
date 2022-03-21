import request from '@/utils/request';

/**
 * 获取最近一周 top5使用量图片
 *
 * @returns 
 */
export const getTop5WeeklyApi = () => request({
  url: '/picture_stat/top5_weak',
  method: 'GET',
});
