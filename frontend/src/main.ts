import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import { createPinia } from 'pinia'
// 按需引用 element-plus的组件，需要同时手动导入组件样式
import 'element-plus/es/components/message/style/css'

createApp(App)
  .use(router)
  .use(createPinia())
  .mount('#app');
