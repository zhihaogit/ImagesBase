<template>
  <Layout>
    <div style="padding: 8px;">
      <h1 style="margin: 0;">
        最近7天TOP5使用量图片
      </h1>
      <Top5Weekly />
    </div>
  </Layout>
</template>

<script lang="ts" setup name="home">
import Layout from "@/components/layout/index.vue";
import Top5Weekly from "./top5Weekly.vue";
</script>
