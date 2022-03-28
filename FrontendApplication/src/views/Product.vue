<template>
  <div>
  <product-overview v-if="loaded"></product-overview>
  </div>
</template>
<script>
import ProductOverview from "@/components/ProductOverview";
import storeData from "@/JS/mixins/storeData";

export default {
  name: "ProductTest",
  components: {ProductOverview},
  mixins:[storeData],
  data() {
    return {
      loaded: false,
    }
  },
  async created() {
    await this.storeData("product", this.$route.params.id)
    this.loaded = true
    },
  methods: {
    test(){
      this.loaded = true
    }
    }

  }
</script>

<style scoped>

</style>