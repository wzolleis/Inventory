<template>
  <div class="container ml-10 ">
    <div class="bg-white rounded-xl shadow shadow-lg p-3">
      <div class="flex items-center">
        <img src="@/assets/store.png" alt="" class="max-h-8">
        <div class="px-3 my-0">
          <p class="text-sm text-gray-400 -my-1">Position</p>
          <p class="font-bold text-xl my-0">Lager Schrank A</p>
        </div>
      </div>
      <div class="flex space-x-2 mt-2">
      <product-badge content="Lager"></product-badge>
      <product-badge content="Artikel: 300"></product-badge>
        </div>
    </div>






  </div>
</template>

<script>
import ProductBadge from "@/components/ProductBadge";
export default {
  name: "LocationHeader",
  components: {ProductBadge}
}
</script>

<style scoped>

</style>