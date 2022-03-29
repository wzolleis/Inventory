import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import "bootstrap/dist/css/bootstrap.css";
import './assets/tailwind.css'
import "./assets/vue-multiselect.css"

const application =  createApp(App)
application.use(store).use(router).mount('#app')
