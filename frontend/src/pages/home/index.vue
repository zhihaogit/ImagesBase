<template>
  <Layout>
    <div style="padding: 8px;">
      <SumUseTimes />
      <Top5Weekly />
    </div>
  </Layout>
</template>

<script lang="ts" setup name="home">
import Layout from "@/components/layout/index.vue";
import Top5Weekly from "./top5Weekly.vue";
import SumUseTimes from "./sumUseTimes.vue";
</script>
