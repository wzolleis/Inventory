<template>
  <div class="rounded-xl bg-white shadow-lg flex mb-4 row" v-if="loaded">
    <div class="grid grid-cols-8 p-3 rounded-xl">
      <img :src="this.getSingleProduct(this.productID, 'imageURL' )" class="max-h-24 mr-5" alt="">
      <div class="grid-rows-3 col-span-5">
        <p class="text-xl font-bold">{{this.getSingleProduct(this.productID, "name" ) }}</p>
        <p class="-mt-3 text-gray-400">SN: <strong>{{ this.getSingleProduct(this.productID, "sn") }}</strong></p>
        <p class="-mt-3 text-gray-400">IN: <strong>{{ this.getSingleProduct(this.productID, "inventoryNumber") }}</strong></p>
      </div>
    </div>
    <div class="flex content-center bg-danger rounded-b" v-if="workshop">
      <p class=" text-white my-0 py-3" v-if="workshop">Problem: {{
          $store.getters.getWsJobByID(this.jobkey).description
        }}</p>
    </div>
  </div>
</template>

<script>
import storeActions from "@/JS/mixins/storeActions";

export default {
  name: "TestHeader",
  methods:{
    dataTest(data){
      return data;
    }
  },
  props: {
    devkey: Number,
    jobkey: Number,
  },
  async mounted() {
    await this.storeProduct(this.productID)
    this.loaded = true

  },
  data() {
    return {
      product: null,
      loaded: false,
      workshop: false,
      productID: this.$route.params.id
    }
  },
  mixins: [storeActions]
}


</script>

<style scoped>

</style>