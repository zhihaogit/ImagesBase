import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import pinia from './store'
// 按需引用 element-plus的组件，需要同时手动导入组件样式
import 'element-plus/es/components/message/style/css'
import 'element-plus/es/components/message-box/style/css'

createApp(App)
  .use(pinia)
  .use(router)
  .mount('#app');
