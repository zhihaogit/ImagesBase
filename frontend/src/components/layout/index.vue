<template>
  <el-container
    class="layout-container-demo"
    style="height: 100%"
  >
    <el-aside
      width="200px"
      style="background-color: rgb(238, 241, 246)"
    >
      <el-scrollbar>
        <el-menu :default-openeds="['1', '3']">
          <el-sub-menu index="1">
            <template #title>
              <el-icon />Navigator One
            </template>
            <el-menu-item-group>
              <template #title>
                Group 1
              </template>
              <el-menu-item index="1-1">
                Option 1
              </el-menu-item>
              <el-menu-item index="1-2">
                Option 2
              </el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="Group 2">
              <el-menu-item index="1-3">
                Option 3
              </el-menu-item>
            </el-menu-item-group>
            <el-sub-menu index="1-4">
              <template #title>
                Option4
              </template>
              <el-menu-item index="1-4-1">
                Option 4-1
              </el-menu-item>
            </el-sub-menu>
          </el-sub-menu>
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

<style scoped>
.layout-container-demo .el-header {
  position: relative;
  background-color: rgb(238, 241, 246);
  color: var(--el-text-color-primary);
}

.layout-container-demo .el-aside {
  width: 240px;
  color: var(--el-text-color-primary);
  background: #fff !important;
  border-right: solid 1px #e6e6e6;
  box-sizing: border-box;
}

.layout-container-demo .el-menu {
  border-right: none;
}

.layout-container-demo .el-main {
  padding: 0;
}

.layout-container-demo .toolbar {
  position: absolute;
  display: inline-flex;
  align-items: center;
  top: 50%;
  right: 20px;
  transform: translateY(-50%);
}
</style>
