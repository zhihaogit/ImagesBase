import { defineStore } from "pinia";
import { getAllPicturesApi, getOnePicturesApi } from '@/apis/picture';
import { PictureInterface } from "@/constants/interface/PictureInterface";
import { UploadFile } from "element-plus/es/components/upload/src/upload.type";

export default defineStore('pictureStore', {
  state: () => ({
    picturesList: [] as PictureInterface[],
  }),

  getters: {
    picturesUrlList: state => state.picturesList.map(_ => ({
      name: _.pictureName,
      url: `/api/view/${_.pictureId}`,
    })) as UploadFile[],
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
        const result = await getOnePicturesApi(pictureId);
        return result;
      } catch (error) {
        return error;
      }
    },
  }
});
