<template>
  <div class="container mt-5 ml-10 space-y-3" v-if="loaded">
    <job-header v-for="job in this.getData('job','all')" :key="job.id" :jobkey="job.id"></job-header>
  </div>
</template>

<script>

import JobHeader from "@/components/JobHeader";
import storeActions from "@/JS/mixins/storeActions";
import storeData from "@/JS/mixins/storeData";
export default {
  name: "JobSummary",
  mixins: [storeActions, storeData],
  components: {JobHeader},
  data(){
    return{
      loaded: false
    }
  },
  async created() {
    await this.storeData("job", "all");
    this.loaded = true

  }
}
</script>

<style scoped>

</style>