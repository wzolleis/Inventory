<template>
<div class="container ml-10 mt-5">

  <product-header></product-header>

</div>
</template>

<script>
import ProductHeader from "@/components/ProductHeader";
import APIRequests from "@/JS/API/APIRequests";
export default {
  name: "JobDescription",
  components: {ProductHeader},
  async beforeCreate() {
    await APIRequests.getURL("inventory/" + this.$route.query.deviceid)
    await APIRequests.setStore("SET_PRODUCT", this.$store.getters.getResponseData)
  }
}
</script>

<style scoped>

</style>