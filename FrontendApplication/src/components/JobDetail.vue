<template>
  <div class="container ml-10 mt-5" v-if="loaded">
    <p class="text-2xl font-bold my-0">Job: {{ this.getData('job', this.jobID).description}}</p>
    <div class="flex space-x-3">
    <div class="flex mt-2 items-center space-x-2">
      <img src="@/assets/user.png" class="max-h-6" alt="">
    <p class="text-gray-400 my-0 -mt-3">{{this.getData('job', this.jobID).customer}}</p>
    </div>

    <div class="flex mt-2 items-center space-x-2">
      <img src="@/assets/expiration.png" class="max-h-6" alt="">
      <p class="text-gray-400 my-0 -mt-3">{{this.getData('job', this.jobID).endDate}}</p>
    </div>
    </div>
    <div class="mt-3 space-y-3">
      <p class="font-bold text-xl">Aktive Artikel</p>
    </div>
    <product-header v-for="device in this.getData('jobid', this.jobID)" :key="device.id" :devkey="device.id"></product-header>
    <div class="my-3 flex row mx-1 space-y-3">
      <button class="rounded-xl bg-indigo-600 font-bold text-white py-3">Bearbeiten</button>
      <button class="rounded-xl bg-danger font-bold text-white py-3">Löschen</button>
    </div>


  </div>





</template>

<script>
import storeActions from "@/JS/mixins/storeActions";
import storeData from "@/JS/mixins/storeData";
import productHeader from "@/components/ProductHeader";
export default {
  name: "JobDetail",
  mixins: [storeActions, storeData],
  components: {productHeader },
  data(){
    return{
      loaded: false,
      jobID: null
    }
  },
  async created() {
    this.jobID = this.$route.params.id
    await this.storeData("job", this.jobID)
    await this.storeData("jobid", this.jobID)
    this.loaded = true
  }
}
</script>

<style scoped>

</style>