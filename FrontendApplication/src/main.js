import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import "bootstrap/dist/css/bootstrap.css";
import './assets/tailwind.css'
import Multiselect from "vue-multiselect";
import vSelect from 'vue-select'
import "./assets/vue-multiselect.css"

const application =  createApp(App)
const Vue = application
Vue.component('multiSelectComponent', Multiselect)
Vue.component('v-select', vSelect)
application.use(store).use(router).mount('#app')
