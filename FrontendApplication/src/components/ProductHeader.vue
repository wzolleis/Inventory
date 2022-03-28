<template>
  <div class="rounded-xl bg-white shadow-lg mb-4 " v-if="loaded">
    <div class="flex p-3 rounded-xl items-center">
      <img :src="this.getData('product', this.devkey).imageURL" class="w-20 mr-6" alt="">
      <div class="grid-rows-3 col-span-6 col-end-auto space-y-1">
        <p class="font-bold">{{this.getData('product', this.devkey).name }}</p>
        <p class="-mt-3  text-gray-400">SN: <strong>{{ this.getData('product', this.devkey).serialNumber }}</strong></p>
        <p class="-mt-3  text-gray-400">IN: <strong>{{ this.getData('product', this.devkey).inventoryNumber }}</strong></p>
      </div>
      <div class="flex ml-auto" @click="click" v-if="this.$route.fullPath.includes('job')">
        <div class="bg-indigo-600 rounded-xl p-2 ml-auto shadow-sm shadow-indigo-500 cursor-pointer hover:scale-105 transition ease-in">
          <div class="flex items-center">
            <!--        <button class="text-white text-xs sm:text-sm font-bold my-0 sm:mx-2" @click="$router.push('/job/' + this.getSingleJob(this.jobID, 'id'))">Ansehen</button>-->
            <button class="text-white text-xs font-bold my-0"></button>
            <img src="@/assets/arrow.png" class="max-h-3 sm:max-h-6 sm mx-2" alt="">
          </div></div>
      </div>
    </div>
    <div class="flex content-center bg-danger rounded-b" v-if="workshop">
      <p class=" text-white my-0 py-3" v-if="workshop">Problem: {{
          Hilfe
        }}</p>
    </div>
  </div>
</template>

<script>
import storeActions from "@/JS/mixins/storeActions";
import storeData from "@/JS/mixins/storeData";

export default {
  name: "ProductHeader",
  props: {
    devkey: String,
    jobkey: Number,
  },
  async mounted() {
    if(this.$route.fullPath.toString().includes("job")){
      await this.storeData("product", this.devkey)
      this.loaded = true
    }
    else this.loaded = true
  },
  data() {
    return {
      product: null,
      loaded: false,
      workshop: false,
      productID: this.$route.params.id,
    }

  },
  methods:{
    click(){
      this.$router.push('/product/' + this.getData('product', this.devkey).id);

    }
  },
  mixins: [storeActions, storeData]
}


</script>

<style scoped>

</style>