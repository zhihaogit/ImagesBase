<template>
  <div class="sum-value__wrapper">
    <h1>{{ textTitle }}</h1>
    <span>{{ sumValue }}</span>
  </div>
</template>

<script setup name="sumUseTimes" lang="ts">
import statStoreStart from '@/store/stat';
import { ref } from '@vue/runtime-dom';

const textTitle = "图片历史使用量："
const sumValue = ref(0);
const statStore = statStoreStart();
statStore.getSumInAllDaysPicturesRequest()
  .then((data) => {
    sumValue.value = data;
  });
</script>

<style scoped>
.sum-value__wrapper span {
  color: aquamarine;
  font-size: 30px;
}
</style>
