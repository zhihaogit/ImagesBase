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

/**
 * 获取历史记录中的使用量总和
 * 
 * @returns 
 */
export const getSumInAllDaysPicturesApi = () => request({
  url: '/picture_stat/sum',
  method: 'GET',
});
