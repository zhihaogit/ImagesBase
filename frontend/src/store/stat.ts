import { getTop5WeeklyApi } from "@/apis/stat";
import { Top5WeeklyInterface } from "@/constants/interface/Top5WeeklyInterface";
import { defineStore } from "pinia";

export default defineStore('statStore', {
  actions: {
    async getTop5WeeklyRequest() {
      try {
        const res = await getTop5WeeklyApi();
        const data: Map<Date, Top5WeeklyInterface> = res.data.data;
        const nameIdMap: Map<string, string> = new Map();
        const temp = [
          ...Object.values(data)
            .reduce((a, v) => {
              v.forEach((it: Top5WeeklyInterface) => {
                nameIdMap.set(it.pictureId, it.pictureName);
                a.add(it.pictureId)
              });
              return a;
            }, new Set())
        ];
        return Object.entries(data).reduce((a, [k, v]) => ({
          ...a,
          [k]: temp
            .map((id) =>
              v.find((_: Top5WeeklyInterface) => _.pictureId === id) || {
                useTimes: 0,
                pictureId: id,
                useDate: k,
                pictureName: nameIdMap.get(id),
              })
        }), {}) as Map<Date, Top5WeeklyInterface>;
      } catch (error) {
        return error;
      }
    },
  }
});
