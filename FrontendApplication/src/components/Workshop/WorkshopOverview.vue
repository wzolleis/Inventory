<template>
  <div v-if="loaded" class="container mt-5 ml-10 space-y-3">
<div v-for="wsjob in $store.getters.getAllWorkshopJobs" :key="wsjob.deviceID">
  <product-header :jobkey="wsjob.id" :devkey="wsjob.deviceID"></product-header>
</div>
  </div>
</template>

<script>
import APIRequests from "@/JS/API/APIRequests";
import store from "@/store";
import ProductHeader from "@/components/ProductHeader";

export default {
  name: "WorkshopOverview",
  components: {ProductHeader, },
  data(){
    return{
      loaded: false
    }
  },
  async beforeCreate() {
    await APIRequests.getURL("workshop/all")
    await APIRequests.setStore("SET_WORKSHOP", store.getters.getResponseData)
    this.loaded = true
  }
}
</script>

<style scoped>

</style>