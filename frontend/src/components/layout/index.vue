<template>
  <el-container
    class="layout-container"
    style="height: 100%"
  >
    <el-aside
      width="200px"
      style="background-color: rgb(238, 241, 246)"
    >
      <el-scrollbar>
        <el-menu router>
          <template
            v-for="route of activeRoutes"
            :key="route.name"
          >
            <el-sub-menu
              v-if="route.children?.length"
              :index="route.path"
            >
              <template #title>
                {{ route.meta.title }}
              </template>
            </el-sub-menu>
            <el-menu-item
              v-else
              :index="route.path"
            >
              <span>{{ route.meta.title }}</span>
            </el-menu-item>
          </template>
        </el-menu>
      </el-scrollbar>
    </el-aside>

    <el-container>
      <el-header style="text-align: right; font-size: 12px">
        <div class="toolbar">
          <span>Tom</span>
        </div>
      </el-header>

      <el-main>
        <slot />
      </el-main>
    </el-container>
  </el-container>
</template>

<script lang="ts" setup name="layout">
import routes from '@/router/list';
import { computed } from '@vue/runtime-core';

const activeRoutes = computed(() => routes.filter(route => route.meta.isMenuShow));
</script>

<style scoped>
.layout-container .el-header {
  position: relative;
  background-color: rgb(238, 241, 246);
  color: var(--el-text-color-primary);
}

.layout-container .el-aside {
  width: 240px;
  color: var(--el-text-color-primary);
  background: #fff !important;
  border-right: solid 1px #e6e6e6;
  box-sizing: border-box;
}

.layout-container .el-menu {
  border-right: none;
}

.layout-container .el-main {
  padding: 0;
}

.layout-container .toolbar {
  position: absolute;
  display: inline-flex;
  align-items: center;
  top: 50%;
  right: 20px;
  transform: translateY(-50%);
}
</style>
