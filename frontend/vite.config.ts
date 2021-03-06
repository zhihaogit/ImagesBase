import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import AutoImport from 'unplugin-auto-import/vite'
import Components from 'unplugin-vue-components/vite'
import { ElementPlusResolver } from 'unplugin-vue-components/resolvers'
import path from 'path'

// https://vitejs.dev/config/
export default defineConfig({
  server: {
    port: 5000,
    proxy: {
      '^/api': {
        target: 'http://localhost:8000/',
        // target: 'http://119.3.210.172:18000/',
        changeOrigin: true,
        rewrite: url => {
          return url.replace(/^\/api/, '');
        },
      },
      '^/images': {
        target: 'http://localhost:8000/',
        // target: 'http://119.3.210.172:18000/',
        changeOrigin: true,
        rewrite: url => {
          return url.replace(/^\/images/, '');
        },
      },
    },
  },
  resolve: {
    alias: {
      '@': path.resolve(__dirname, 'src'),
    },
  },
  plugins: [
    vue(),
    AutoImport({
      resolvers: [ElementPlusResolver()],
    }),
    Components({
      resolvers: [ElementPlusResolver()],
    }),
  ],
});
