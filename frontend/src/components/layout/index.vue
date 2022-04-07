<template>
  <el-container class="layout-container">
    <el-aside
      width="200px"
      class="layout-aside"
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
      <el-header
        height="56px"
        class="main-container"
      >
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
import { storeToRefs } from 'pinia';
import { ElMessage } from 'element-plus';

const router = useRouter();
const route = useRoute();
const userStore = userStoreStart();

const { userInfo } = storeToRefs(userStore);

const activePath = ref(route.path);

const activeRoutes = computed(() => routes.filter(route => route.meta.isMenuShow));

const logout = () => {
  userStore.logoutRequest()
    .then(() => {
      Cookies.remove('token');
      router.replace(RouterNameEnum.LOGIN);
    })
    .catch(() => {
      ElMessage.error("退出登录失败");
    });
};
</script>

<style scoped>
.layout-container {
  height: 100%;
}

.layout-aside {
  background-color: rgb(238, 241, 246);
}

.main-container {
  text-align: right;
  font-size: 12px;
}

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
