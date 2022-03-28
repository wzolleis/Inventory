<template>
  <div class="bg-gray-200 text-sm rounded-xl px-3 py-1 flex justify-items-center align-items-center">
  <span class="text-gray-600 font-bold">{{ content }}</span>
  </div>
</template>

<script>
export default {
  name: "ProductBadge",
  props: {
    content: String,

  }
}
</script>
