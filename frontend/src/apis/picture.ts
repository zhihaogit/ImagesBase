import request from '@/utils/request';

/**
 * 图片列表查询
 *
 * @param data - string
 * @returns 
 */
export const getAllPicturesApi = () => request({
  url: '/picture_info/list',
  method: 'GET',
});

/**
 * 单个图片查询
 *
 * @returns 
 */
export const getOnePicturesApi = (pictureId: string) => request({
  url: `/view/${pictureId}`,
  method: 'GET',
});

/**
 * 删除单个图片
 *
 * @param pictureId 
 * @returns 
 */
export const removeOnePictureApi = (pictureId: string) => request({
  url: `/picture/${pictureId}`,
  method: 'DELETE',
});
