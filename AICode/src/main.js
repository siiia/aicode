import { createApp } from 'vue'
import './style.css'
import Router from '@/router'
import App from './App.vue'
const app = createApp(App)
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

import { registerAllModules } from 'handsontable/registry';
import 'handsontable/dist/handsontable.full.css';
registerAllModules()

app.use(Router)
app.use(ElementPlus)
app.mount('#app')
