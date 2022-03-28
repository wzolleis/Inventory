<template>
  <div v-if="loaded" class="bg-white rounded-xl shadow-lg mt-4 -mb-2 p-2">
    <div class="flex space-x-4 items-center px-2 justify-between">
      <div class="flex items-center space-x-4">
        <img src="@/assets/job.png" class="h-8">
        <div class="grid items-center my-2">
          <p class="text-xs sm:text-sm mb-2 text-gray-400">{{ this.getData('job', this.jobID).customer }}</p>
          <p class="-mt-3  font-bold p-0 mb-0">{{ this.getData('job', this.jobID).description }}</p>
        </div>
      </div>
      <div
          class="bg-indigo-600 rounded-xl p-2 ml-auto shadow-sm shadow-indigo-500 cursor-pointer hover:scale-105 transition ease-in">
        <div class="flex items-center" @click="click">
          <!--        <button class="text-white text-xs sm:text-sm font-bold my-0 sm:mx-2" @click="$router.push('/job/' + this.getSingleJob(this.jobID, 'id'))">Ansehen</button>-->
          <button class="text-white text-xs sm:text-sm font-bold my-0 sm:mx-2">Ansehen</button>
          <img src="@/assets/arrow.png" class="max-h-3 sm:max-h-6 sm mx-2" alt="">
        </div>
      </div>
    </div>

  </div>
</template>

<script>
import storeData from "@/JS/mixins/storeData";

export default {
  name: "ProductJob",
  mixins: [storeData],
  methods: {
    click() {
      this.$router.push('/job/' + this.getData('product', this.productID).jobID)

    }
  },
  data() {
    return {
      loaded: false,
      description: "Aktueller Job",
      productID: this.$route.params.id,
      jobID: null
    }
  },
  async mounted() {
    await this.storeData("job", this.getData('product', this.productID).jobID)
    this.jobID = this.getData('product', this.productID).jobID
    this.loaded = true;
  }
}
</script>

<style scoped>

</style>