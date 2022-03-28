<template>
  <div class="my-4">
<p class="text-xl font-bold my-4">Beschreibung</p>
  <p class="text-sm -mt-3 text-gray-400">{{this.getData('product', this.$route.params.id).description}}</p>
  </div>
</template>

<script>
import storeData from "@/JS/mixins/storeData";

export default {
  name: "ProductDescription",
  mixins:[storeData]
}
</script>

<style scoped>

</style>