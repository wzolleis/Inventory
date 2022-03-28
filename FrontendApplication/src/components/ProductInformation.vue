<template>
<div>
  <div class="mt-4">
    <div class="flex">
      <div class="bg-gray-200 rounded-xl p-2">
      <img src="@/assets/position.png" class="max-h-8 w-auto" v-if="pos">
      <img src="@/assets/barcode.png" class="max-h-8 w-auto" alt="" v-if="!pos && !category">
        <img src="@/assets/category.png" class="max-h-8 w-auto" alt="" v-if="category"></div>
      <div class="grid grid-rows-2">
      <p class="text-xs sm:text-sm ml-2 mt-1 mb-0 text-gray-400 ">{{ description }}</p>
      <p class=" -mt-0 mb-0 p-0 ml-2 text-xs sm:text-sm text-gray-600 font-bold">{{ position }}</p></div>
    </div>
  </div>


</div>
</template>

<script>
export default {
  name: "ProductInformation",
  props: {
    description: String,
    position: String,
    imageURL: String,
    pos: Boolean,
    category: Boolean

  }
}
</script>

<style scoped>

</style>