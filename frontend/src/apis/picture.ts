import request from '@/utils/request';

/**
 * 图片列表查询
 *
 * @param data - string
 * @returns 
 */
export const getAllPicturesApi = () => request({
  url: '/picture/list',
  method: 'get',
});

/**
 * 单个图片查询
 *
 * @returns 
 */
export const getOnePicturesApi = (pictureId: string) => request({
  url: `/view/${pictureId}`,
  method: 'get',
});
