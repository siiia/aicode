import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import { join } from "path";
import AutoImport from 'unplugin-auto-import/vite'
// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue(), AutoImport({
    imports: ['vue'], dts: 'src/auto-import.d.ts'
  })],
  resolve: {
    extensions: ['.js', '.vue', '.json'],
    alias: {
      '@': join(__dirname, "src"),
    }
  },
  server: {
    proxy: {
      "/aicode": {
        target: "http://localhost:8080",
        changeOrigin: true,
      },
    },
  },
})
