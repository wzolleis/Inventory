<template>
  <div class="bg-white rounded-xl shadow shadow-lg p-3" v-if="loaded">
    <div class="flex items-center">
      <img src="@/assets/job.png" alt="" class="max-h-8">
      <div class="px-3 my-0">
        <p class="text-sm text-gray-400 -my-1">Job</p>
        <p class="font-bold text-xl my-0">{{this.getData('job', this.jobkey).description}}</p>
      </div>
      <div @click="click" class="bg-indigo-600 rounded-xl p-2 ml-auto shadow-sm shadow-indigo-500 cursor-pointer hover:scale-105 transition ease-in">
        <div class="flex items-center">
          <button class="text-white text-xs sm:text-sm font-bold my-0 sm:mx-2">Ansehen</button>
          <img src="@/assets/arrow.png" class="max-h-3 sm:max-h-6 sm mx-2" alt="">
        </div>
      </div>
    </div>

    <div class="flex items-center space-x-1 mt-2">

      <div class="flex items-center">
        <img src="@/assets/user.png" class="max-h-6 " alt="">
        <p class="text-gray-400 text-sm my-0 mx-2">{{this.getData('job', this.jobkey).customer}}</p>
      </div>

      <div class="flex items-center">
        <img src="@/assets/expiration.png" class="max-h-6 " alt="">
        <p class="text-gray-400 text-sm my-0 mx-2">{{this.getData('job', this.jobkey).endDate}}</p>
      </div>

    </div>
  </div>
</template>

<script>
import storeActions from "@/JS/mixins/storeActions";
import storeData from "@/JS/mixins/storeData";

export default {
  name: "JobHeader",
  props: {
    jobkey: Number,
  },
  async mounted() {
    await this.storeData("job", this.jobkey)

    this.loaded = true
  },
  data(){
    return{
      loaded: false
    }
  },
  methods:{
    click(){
      this.$router.push("/job/" + this.jobkey)
    }
  },
  mixins: [storeActions, storeData]
}
</script>

<style scoped>

</style>