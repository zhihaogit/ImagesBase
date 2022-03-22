<template>
  <h1>{{ textTitle }}</h1>
  <div
    id="top5_weekly_chart"
    ref="top5WeeklyChartRef"
  />
</template>
<script setup name="top5Weekly" lang="ts">
import * as echarts from 'echarts';
import StatStoreStart from '@/store/stat';
import { onMounted, onUnmounted, ref } from 'vue';
import { Top5WeeklyInterface } from '@/constants/interface/Top5WeeklyInterface';

const statStore = StatStoreStart();
const textTitle = "最近7天TOP5使用量图片：";
const chart = ref();
const top5WeeklyChartRef = ref();

onMounted(() => {
  chart.value = echarts.init(top5WeeklyChartRef.value);
  statStore.getTop5WeeklyRequest()
    .then((data): void | PromiseLike<void> => {
      const dataCopy = data as Map<Date, Top5WeeklyInterface>;
      const yAxis = Object.keys(dataCopy).sort() as string[];
      const seriesData = Object.values(dataCopy)
        .reduce((a, v) => ([
          ...a,
          ...v,
        ]), [])
        .reduce((a: { [x: string]: Array<Top5WeeklyInterface>; }, v: Top5WeeklyInterface) => {
          a[v.pictureId] = a[v.pictureId]
            ? [
              ...a[v.pictureId],
              v
            ] : [
              v
            ];
          return a;
        }, {});
      const series = Object.entries(seriesData).map(([, v]) => {
        const vCopy = v as Array<Top5WeeklyInterface>;
        return {
          name: vCopy[0]?.pictureName,
          type: 'bar',
          stack: 'total',
          label: {
            show: true
          },
          emphasis: {
            focus: 'series'
          },
          data: vCopy.map((_: Top5WeeklyInterface) => _.useTimes),
        };
      });
      const option = {
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'shadow'
          }
        },
        legend: {},
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        },
        xAxis: {
          type: 'value'
        },
        yAxis: {
          type: 'category',
          data: yAxis,
        },
        series,
      };
      chart.value.setOption(option);
    });
});

onUnmounted(() => {
  chart.value = null;
});
</script>

<style scoped>
#top5_weekly_chart {
  width: 100%;
  height: 400px;
}
</style>
