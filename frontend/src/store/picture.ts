import { defineStore } from "pinia";
import { getAllPicturesApi, getOnePicturesApi, removeOnePictureApi } from '@/apis/picture';
import { PictureInterface, PictureListInterface } from "@/constants/interface/PictureInterface";

export default defineStore('pictureStore', {
  state: () => ({
    picturesList: [] as PictureInterface[],
  }),

  getters: {
    picturesUrlList: state => state.picturesList.map(_ => ({
      name: _.pictureName,
      url: `/api/view/${_.pictureId}?c=1`,
      pictureId: _.pictureId,
    })) as PictureListInterface[],
  },

  actions: {
    async getAllPicturesRequest() {
      try {
        const result = await getAllPicturesApi();
        this.picturesList = result.data;
        return result;
      } catch (error) {
        return error;
      }
    },

    async getOnePicturesRequest(pictureId: string) {
      try {
        return await getOnePicturesApi(pictureId);
      } catch (error) {
        return error;
      }
    },

    async removeOnePictureRequest(pictureId: string) {
      try {
        return await removeOnePictureApi(pictureId);
      } catch (error) {
        return error;
      }
    },
  }
});
