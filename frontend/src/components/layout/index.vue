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
        <el-menu
          router
          :default-active="activePath"
        >
          <template
            v-for="item of activeRoutes"
            :key="item.name"
          >
            <el-sub-menu
              v-if="item.children?.length"
              :index="item.path"
            >
              <template #title>
                {{ item.meta.title }}
              </template>
            </el-sub-menu>
            <el-menu-item
              v-else
              :index="item.path"
            >
              <span>{{ item.meta.title }}</span>
            </el-menu-item>
          </template>
        </el-menu>
      </el-scrollbar>
    </el-aside>

    <el-container>
      <el-header style="text-align: right; font-size: 12px">
        <div class="toolbar">
          <span>{{ userInfo.name }}</span>
          <span class="user-logout__separator">|</span>
          <el-button
            type="text"
            @click="logout"
          >
            logout
          </el-button>
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
import userStoreStart from "@/store/user";
import Cookies from 'js-cookie';
import { useRouter, useRoute } from 'vue-router';
import { RouterNameEnum } from '@/constants/enum/RouterNameEnum';
import { ref } from 'vue';

const router = useRouter();
const route = useRoute();
const userStore = userStoreStart();

const activePath = ref(route.path);

const userInfo = computed(() => userStore.userInfo);
const activeRoutes = computed(() => routes.filter(route => route.meta.isMenuShow));

const logout = () => {
  Cookies.remove('token');
  router.push(RouterNameEnum.LOGIN);
};
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

.layout-container .user-logout__separator {
  margin: 0 5px;
}
</style>
